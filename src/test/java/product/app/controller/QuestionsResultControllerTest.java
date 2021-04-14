package product.app.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

import product.app.service.QuestionsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class QuestionsResultControllerTest {
	private MockMvc mockMvc;

	// モック化するクラスのインスタンスを生成
	@MockBean
	private QuestionsService service;

	// モックを注入するクラスのインスタンスを生成、DIコンテナに登録
	@Autowired
	private QuestionsResultController target;

	//ここで初期設定。Test用に設定。mockMvcインスタンスを利用して、仮想のリクエストを発生させテストを実行します。
	@Before
	public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		mockMvc = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();

	}

	@Test
	public void 出題数とストレス項目への回答数を画面に表示する() throws Exception {

		when(service.countMyQuestions()).thenReturn(10);
		when(service.countReview()).thenReturn(5);

		mockMvc.perform(get("/sqtop/result")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("result"))
				.andExpect(model().attribute("countmyquestion", 10))
				.andExpect(model().attribute("countreview", 5))
				.andExpect(model().attribute("answerrate", 50.0));

	}

	@Test
	public void ストレス度が70以上の場合のメッセージを表示する() throws Exception {

		when(service.countMyQuestions()).thenReturn(10);
		when(service.countReview()).thenReturn(7);

		mockMvc.perform(get("/sqtop/result")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("result"))
				.andExpect(model().attribute("countmyquestion", 10))
				.andExpect(model().attribute("countreview", 7))
				.andExpect(model().attribute("answerrate", 70.0))
				.andExpect(model().attribute("resultmsg", "あなたは高ストレス傾向です！！直ちに休息をとってください"));

	}

	@Test
	public void ストレス度が60以下30以上の場合のメッセージを表示する() throws Exception {

		when(service.countMyQuestions()).thenReturn(10);
		when(service.countReview()).thenReturn(3);

		mockMvc.perform(get("/sqtop/result")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("result"))
				.andExpect(model().attribute("countmyquestion", 10))
				.andExpect(model().attribute("countreview", 3))
				.andExpect(model().attribute("answerrate", 30.0))
				.andExpect(model().attribute("resultmsg", "あなたは中ストレス傾向です！無理は禁物。意識的に休息を取りましょう！"));

	}

	@Test
	public void ストレス度が20以下の場合のメッセージを表示する() throws Exception {

		when(service.countMyQuestions()).thenReturn(10);
		when(service.countReview()).thenReturn(2);

		mockMvc.perform(get("/sqtop/result")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("result"))
				.andExpect(model().attribute("countmyquestion", 10))
				.andExpect(model().attribute("countreview", 2))
				.andExpect(model().attribute("answerrate", 20.0))
				.andExpect(model().attribute("resultmsg", "あなたは低ストレス傾向です！日頃のケアに努めていきましょう"));

	}

}
