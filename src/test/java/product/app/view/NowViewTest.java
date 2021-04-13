package product.app.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.codeborne.selenide.Configuration;

import product.app.view.page.NowPage;
import product.app.view.page.ResultPage;
import product.app.view.page.TopPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestPropertySource(locations = "classpath:test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class NowViewTest {

	private NowPage page;

	@BeforeClass
	public static void setUp() {
		Configuration.holdBrowserOpen = true;
	}

	@Before
	public void setUpTest() {
		page = TopPage.open().出題ページ画面へ遷移する();
	}

	@Test
	public void No1_そうだと答えて次の画面へ遷移する() throws Exception {
		NowPage actual = page.そうだを選択し次の質問へ遷移する();
		assertThat(actual.title()).isEqualTo("SQ.出題！");

	}

	@Test
	public void No2_ちがうと答えて次の画面へ遷移する() throws Exception {
		NowPage actual = page.ちがうを選択し次の質問へ遷移する();
		assertThat(actual.title()).isEqualTo("SQ.出題！");

	}

	@Test
	public void No3_すべての問題に答えたら結果画面に遷移する() throws Exception {
		ResultPage actual = page.すべての問題に答えたら結果画面へ遷移する();
		assertThat(actual.title()).isEqualTo("SQ.結果");

	}

}
