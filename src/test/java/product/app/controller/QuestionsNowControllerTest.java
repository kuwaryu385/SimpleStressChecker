package product.app.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import product.app.domain.Questions;
import product.app.service.QuestionsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class QuestionsNowControllerTest {

	private MockMvc mockMvc;

	// モック化するクラスのインスタンスを生成
	@MockBean
	private QuestionsService service;

	// モックを注入するクラスのインスタンスを生成、DIコンテナに登録
	@Autowired
	private QuestionsNowController target;

	//ここで初期設定。Test用に設定。mockMvcインスタンスを利用して、仮想のリクエストを発生させテストを実行します。
	@Before
	public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		mockMvc = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();

	}

	//setUp エンティティ
	private Questions setUpQuestions(int 質問ID, String 質問, String そうだ, String ちがう, int ストレス項目, boolean 回答後,
			boolean 回答率) {
		Questions questions = new Questions();
		questions.setId(質問ID);
		questions.setQuestion(質問);
		questions.setChoiceY(そうだ);
		questions.setChoiceN(ちがう);
		questions.setAnswer(ストレス項目);
		questions.setAnswered(回答後);
		questions.setAnswerRate(回答率);
		return questions;
	}

	@Test
	public void 出題数を取得し画面に表示する() throws Exception {

		List<Integer> questionIdList = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			questionIdList.add(i);
		}

		//		when(service.insertQuestions(questionList)).thenReturn(10);
		when(service.idQuestion()).thenReturn(questionIdList);
		when(service.countMyQuestions()).thenReturn(questionIdList.size());

		mockMvc.perform(get("/sqtop/questions")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("/questions"))
				.andExpect(model().attribute("totalQuestionNumber", "全10問中"));

	}

	@Test
	public void 現在何問目かを取得し画面に表示する() throws Exception {

		//when(service.insertQuestions(questionList)).thenReturn(10);と過程
		//TopControllerで質問テーブルをinsert後
		List<Integer> questionIdList = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			questionIdList.add(i);
		}

		when(service.idQuestion()).thenReturn(questionIdList);
		when(service.countMyQuestions()).thenReturn(questionIdList.size());

		mockMvc.perform(get("/sqtop/questions")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("/questions"))
				.andExpect(model().attribute("nowQuestionNumber", "1問目"));

	}

	@Test
	public void 出題テーブルから未回答の1列を取得する() throws Exception {

		//質問リスト//１問目は回答済みと仮定
		Questions qtTable1 = setUpQuestions(1, "どちらかというと自分は元気だと思うか？", "そうだ", "ちがう", 0, true, false);
		Questions qtTable2 = setUpQuestions(2, "イライラすることは多いか？", "そうだ", "ちがう", 1, false, false);
		Questions qtTable3 = setUpQuestions(3, "朝起きたとき体に疲れが残っていることが多いか?", "そうだ", "ちがう", 1, false, false);

		//質問テーブル
		List<Questions> qtList = new ArrayList<Questions>();
		qtList.add(qtTable1);
		qtList.add(qtTable2);
		qtList.add(qtTable3);

		//質問テーブルは０〜２までの合計３問なので
		int qtCount = qtList.size() - 1;

		//when(service.insertQuestions(questionList)).thenReturn(3)
		//TopControllerでinsertされたと過程。
		List<Integer> questionIdList = new ArrayList<>();
		for (int i = 0; i <= qtCount; i++) {
			questionIdList.add(i);
		}

		//出題リスト
		List<Questions> nowQList = new ArrayList<Questions>();

		//リストから未回答の問題を取得。
		for (int i = 0; i <= qtCount; i++) {
			if (qtList.get(i).isAnswered() == false) {
				nowQList.add(qtList.get(i));
			}
		}

		when(service.idQuestion()).thenReturn(questionIdList);
		when(service.countMyQuestions()).thenReturn(questionIdList.size());
		when(service.selectOne(questionIdList.get(0))).thenReturn(nowQList.get(0));

		mockMvc.perform(get("/sqtop/questions")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("/questions"))
				.andExpect(model().attribute("nowQuestion", nowQList.get(0)));

		assertThat(nowQList.get(0).getId(), is(2));

	}

	@Test
	public void 全問終了後結果画面に返る事() throws Exception {

		//質問テーブル未回答の問題は0と仮定する。
		List<Integer> questionList = new ArrayList<>();

		when(service.insertQuestions(questionList)).thenReturn(0);
		when(service.idQuestion()).thenReturn(questionList);

		mockMvc.perform(get("/sqtop/questions")).andDo(print())
				.andExpect(status().isFound())
				.andExpect(view().name("redirect:/sqtop/result"));
	}

	@Test
	public void ストレス項目へに答えたか回答済みか判定しリダイレクトされる() throws Exception {
		//質問リスト
		Questions qtTable1 = setUpQuestions(1, "どちらかというと自分は元気だと思うか？", "そうだ", "ちがう", 0, false, false);

		when(service.selectOne(1)).thenReturn(qtTable1);

		mockMvc.perform(
				post("/sqtop/questions/answer").param("id", "1").param("answer", "0"))
				.andDo(print())
				.andExpect(redirectedUrl("/sqtop/questions"))
				.andExpect(status().isFound())
				//302isfoundはリダイレクトで使用。リソースを一時的に示されたところへ移動する。
				.andExpect(view().name("redirect:/sqtop/questions"));

		verify(service, times(1)).reviewQuestion(1);
		verify(service, times(1)).answerdQuestion(1);

	}

}
