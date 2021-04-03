package product.app.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import product.app.domain.Questions;

@RunWith(SpringRunner.class)
@MybatisTest
@TestPropertySource(locations = "classpath:test.properties")

public class QuestionsRepositoryTest {

	@Autowired
	private QuestionsRepository sut;

	//初期化しておく
	@Before
	public void Setup() throws Exception {
		sut.deleteQuestions();

		List<Integer> questionList = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			questionList.add(i);
		}
		sut.insertQuestions(questionList);
	}

	@Test
	public void 全件検索して問題リストを取得できること() throws Exception {
		List<Questions> actual = sut.selectAll();
		assertThat(actual.size()).isEqualTo(10);
	}

	@Test
	public void 問題数を取得すること() throws Exception {
		int actual = sut.countQuestions();
		assertThat(actual, is(10));

	}

	@Test
	public void 出題リストの初期化のためリストを全件削除すること() throws Exception {
		sut.deleteQuestions();

		for (int i = 1; i <= 10; i++) {
			Questions actual = sut.selectOne(i);
			assertThat(actual).isNull();
		}
	}

	@Test
	public void 出題リストに登録し質問を１件検索して結果がキーに紐づく１件を取得できること() throws Exception {
		Questions actual = sut.selectOne(1);
		assertThat(actual.getId()).isEqualTo(1);
		assertThat(actual.getQuestion()).isEqualTo("どちらかというと自分は元気だと思うか？");
		assertThat(actual.getChoiceY()).isEqualTo("そうだ");
		assertThat(actual.getChoiceN()).isEqualTo("ちがう");
		assertThat(actual.getAnswer()).isEqualTo(0);
		assertThat(actual.isAnswered()).isEqualTo(false);
		assertThat(actual.isAnswerRate()).isEqualTo(false);

	}

	@Test
	public void 出題テーブルの問題数を取得すること() throws Exception {
		int actual = sut.countMyQuestions();
		assertThat(actual, is(10));
	}

	@Test
	public void 未回答の質問IDを取得すること() throws Exception {
		sut.answerdQuestion(1);
		List<Integer> actual = sut.idQuestion();
		assertThat(actual.size()).isEqualTo(9);
	}

	@Test
	public void ストレス項目へ回答したらtureとなること() throws Exception {
		sut.reviewQuestion(1);
		Questions actual = sut.selectOne(1);
		assertThat(actual.isAnswerRate()).isEqualTo(true);
	}

	@Test
	public void 回答したらtrueとなり回答済みになること() throws Exception {
		sut.answerdQuestion(1);
		Questions actual = sut.selectOne(1);
		assertThat(actual.isAnswered()).isEqualTo(true);
	}

}
