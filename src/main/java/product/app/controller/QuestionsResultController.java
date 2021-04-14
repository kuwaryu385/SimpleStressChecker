package product.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import product.app.service.QuestionsService;

@Controller
@RequestMapping("/sqtop/result")
public class QuestionsResultController {

	@Autowired
	private QuestionsService service;

	//結果処理
	@GetMapping
	public String result(Model model) {
		//出題数を取得
		int countmyquestion = service.countMyQuestions();
		model.addAttribute("countmyquestion", countmyquestion);

		//ストレス項目項目への回答数を取得
		int countreview = service.countReview();
		model.addAttribute("countreview", countreview);

		//ストレス度を算出
		double answerrate = (double) countreview / countmyquestion * 100;
		model.addAttribute("answerrate", answerrate);

		if (answerrate >= 70) {
			model.addAttribute("resultmsg", "あなたは高ストレス傾向です！！直ちに休息をとってください");
		} else if (answerrate >= 30 && answerrate <= 60) {
			model.addAttribute("resultmsg", "あなたは中ストレス傾向です！無理は禁物。意識的に休息を取りましょう！");
		} else {
			model.addAttribute("resultmsg", "あなたは低ストレス傾向です！日頃のケアに努めていきましょう");
		}

		return "result";
	}

}
