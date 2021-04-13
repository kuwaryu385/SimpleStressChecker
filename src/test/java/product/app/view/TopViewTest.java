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
import product.app.view.page.TopPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT) //ポートはアプリケーションのプロパティで指定されたポートを使用
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS) //テストを実効したあとDI破棄
@TestPropertySource(locations = "classpath:test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//注釈を使用し@FixMethodOrder方法ソーターでMethodSorters.NAME_ASCENDING 。
//これにより、クラス内のすべてのテストが決定的かつ予測可能な順序で実行されます。

public class TopViewTest {

	private TopPage page;

	@BeforeClass
	public static void setUp() {
		// テストが終了後もブラウザを開いたままにしない
		Configuration.holdBrowserOpen = true;
	}

	@Before
	public void setUpTest() {
		page = TopPage.open();
	}

	@Test
	public void No1_トップ画面から出題ページへ画面遷移できること() throws Exception {
		NowPage actual = page.出題ページ画面へ遷移する();

		assertThat(actual.title()).isEqualTo("SQ.出題！");
	}

}
