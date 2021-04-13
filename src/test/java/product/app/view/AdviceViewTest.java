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
import product.app.view.page.TopPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT) //ポートはアプリケーションのプロパティで指定されたポートを使用
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS) //テストを実効したあとDI破棄
@TestPropertySource(locations = "classpath:test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AdviceViewTest {

	private AdvicePage page;

	@BeforeClass
	public static void setUp() {
		Configuration.holdBrowserOpen = true;
	}

	@Before
	public void setUpTest() {
		page = TopPage.open().出題ページ画面へ遷移する().すべての問題に答えたら結果画面へ遷移する().アドバイス画面へ遷移();

	}

	@Test
	public void No1_アドバイスページからTop画面へ戻れること() throws Exception {
		TopPage actual = page.topへ戻る();
		assertThat(actual.title()).isEqualTo("SQ.Topページ");
	}

}
