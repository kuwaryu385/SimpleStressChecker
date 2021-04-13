package product.app.view.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class ResultPage {
	//仮実装
	//	@FindBy(id = "answerRrate")
	//	private SelenideElement answerRrate;
	//
	//	@FindBy(id = "countMyQuestion")
	//	private SelenideElement countMyQuestion;
	//
	//	@FindBy(id = "countReview")
	//	private SelenideElement countReview;
	//
	//	@FindBy(id = "resultMsg")
	//	private SelenideElement resultMsg;

	@FindBy(id = "topButton")
	private SelenideElement topButton;

	@FindBy(id = "adviceButton")
	private SelenideElement adviceButton;

	public String title() {
		return Selenide.title();
	}
	//	仮実装
	//
	//	public AdvicePage ストレス度は(String ストレス度) {
	//		answerRrate.setValue(ストレス度);
	//		return page(AdvicePage.class);
	//	}
	//
	//	public AdvicePage 問題数は(String 問題数) {
	//		countMyQuestion.setValue(問題数);
	//		return page(AdvicePage.class);
	//	}
	//
	//	public AdvicePage ストレス項目への回答数は(String 回答数) {
	//		countReview.setValue(回答数);
	//		return page(AdvicePage.class);
	//
	//	}
	//
	//	public AdvicePage 回答率ごとのメッセージは(String メッセージ) {
	//		resultMsg.setValue(メッセージ);
	//		return page(AdvicePage.class);
	//
	//	}

	public AdvicePage アドバイス画面へ遷移() {
		adviceButton.click();
		return page(AdvicePage.class);
	}

	public TopPage topへ戻る() {
		topButton.click();
		return page(TopPage.class);
	}

}
