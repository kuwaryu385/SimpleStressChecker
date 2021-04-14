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

import product.app.view.page.AdvicePage;
import product.app.view.page.ResultPage;
import product.app.view.page.TopPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT) //ポートはアプリケーションのプロパティで指定されたポートを使用
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS) //テストを実効したあとDI破棄
@TestPropertySource(locations = "classpath:test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ResultViewTest {

	private ResultPage page;

	@BeforeClass
	public static void setUp() {
		Configuration.holdBrowserOpen = true;
	}

	@Before
	public void setUpTest() {
		page = TopPage.open().出題ページ画面へ遷移する().すべての問題に答えたら結果画面へ遷移する();

	}

	@Test
	public void No1_結果画面からアドバイスページに遷移する() throws Exception {
		AdvicePage actual = page.アドバイス画面へ遷移();
		assertThat(actual.title()).isEqualTo("SQ.アドバイスページ");
	}

	@Test
	public void No2_結果画面からTop画面へ戻れること() throws Exception {
		TopPage actual = page.topへ戻る();
		assertThat(actual.title()).isEqualTo("SQ.Topページ");
	}

}
