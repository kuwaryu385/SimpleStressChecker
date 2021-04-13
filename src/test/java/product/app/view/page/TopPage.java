package product.app.view.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class TopPage {

	private static final String URL = "http://localhost:8080/sqtop";

	@FindBy(id = "startButton")
	private SelenideElement startButton;

	public static TopPage open() {
		return Selenide.open(URL, TopPage.class);
	}

	public String title() {
		return Selenide.title();
	}

	public NowPage 出題ページ画面へ遷移する() {
		startButton.click();
		return page(NowPage.class);
	}

}
