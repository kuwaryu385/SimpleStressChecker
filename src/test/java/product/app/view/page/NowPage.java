package product.app.view.page;

import static com.codeborne.selenide.Selenide.*;

import java.util.Random;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class NowPage {
	//仮実装
	//	@FindBy(id = "totalQuestionNumber")
	//	private SelenideElement totalQuesionNumber;
	//
	//	@FindBy(id = "nowQuestionNumber")
	//	private SelenideElement nowQuestionNumber;
	//
	//	@FindBy(id = "qestionText")
	//	private SelenideElement qestionText;
	//
	//	@FindBy(id = "yesText")
	//	private SelenideElement yesText;
	//
	//	@FindBy(id = "noText")
	//	private SelenideElement noText;

	@FindBy(id = "yesButton")
	private SelenideElement yesButton;

	@FindBy(id = "noButton")
	private SelenideElement noButton;

	public String title() {
		return Selenide.title();
	}

	public NowPage そうだを選択し次の質問へ遷移する() {
		yesButton.click();
		return page(NowPage.class);
	}

	public NowPage ちがうを選択し次の質問へ遷移する() {
		noButton.click();
		return page(NowPage.class);
	}

	public ResultPage すべての問題に答えたら結果画面へ遷移する() {

		Random r = new Random();

		//ランダムにどちらか押す感じ。
		for (int i = 0; i < 10; i++) {

			boolean Q = r.nextBoolean();
			System.out.println(Q);

			if (Q == true) {
				yesButton.click();
			} else {
				noButton.click();
			}
		}
		return page(ResultPage.class);
	}

}

//	public NowPage 全問題数は(String 全問題数) {
//		totalQuesionNumber.setValue(全問題数);
//		return page(NowPage.class);
//
//	}
//
//	public NowPage 現在何問目かは(String 何問目) {
//		totalQuesionNumber.setValue(何問目);
//		return page(NowPage.class);
//
//	}
//
//	public NowPage 質問内容は(String 質問内容) {
//		totalQuesionNumber.setValue(質問内容);
//		return page(NowPage.class);
//
//	}
//
//	public NowPage 選択肢肯定か(String 肯定) {
//		totalQuesionNumber.setValue(肯定);
//		return page(NowPage.class);
//
//	}
//
//	public NowPage 選択肢否定か(String 否定) {
//		totalQuesionNumber.setValue(否定);
//		return page(NowPage.class);
//
//	}
