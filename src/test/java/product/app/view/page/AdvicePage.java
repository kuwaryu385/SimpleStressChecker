package product.app.view.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class AdvicePage {

	@FindBy(id = "topButton")
	private SelenideElement topButton;

	public String title() {
		return Selenide.title();
	}

	public TopPage topへ戻る() {
		topButton.click();
		return page(TopPage.class);
	}

}
