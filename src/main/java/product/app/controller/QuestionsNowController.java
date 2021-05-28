package product.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.app.domain.Questions;
import product.app.service.QuestionsService;

@Controller
@RequestMapping("/questions")
public class QuestionsNowController {

	@Autowired
	private QuestionsService service;

	@GetMapping
	public String question(Model model) {

		//質問テーブルから未回答のIDを取得
		List<Integer> questionIdlist = new ArrayList<Integer>();
		questionIdlist = service.idQuestion();

		//質問テーブルから回答済みのIDを取得
		List<Integer> questionUesedIdlist = new ArrayList<Integer>();
		questionUesedIdlist = service.idUesedQuestion();

		//全問終了
		if (questionIdlist.size() == 0) {
			return "redirect:/result";
		}

		//出題数を取得
		int countmyquestion = service.countMyQuestions();
		model.addAttribute("totalQuestionNumber", "全" + countmyquestion + "問中");

		//現在何問目か
		int nowQuestionNumber = countmyquestion - questionIdlist.size() + 1;
		model.addAttribute("nowQuestionNumber", nowQuestionNumber + "問目");

		//出題
		model.addAttribute("nowQuestion", service.selectOne(questionIdlist.get(0)));

		//戻るボタンへ値を渡す。
		if (questionUesedIdlist.size() == 0) {
			model.addAttribute("uesedQuestion", null);
		} else {
			model.addAttribute("uesedQuestion", service.selectOne(questionUesedIdlist.get(0)));
		}

		return "/questions";

	}

	@PostMapping(value = "answer")
	public String ansewr(@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "answer", required = false) Integer answer) {

		//ストレス項目への回答したか？（はいと答えたかの判定）
		Questions question = service.selectOne(id);

		if (answer == question.getAnswer()) {
			service.reviewQuestion(id);
		}
		//回答済みにセット
		service.answerdQuestion(id);

		return "redirect:/questions";

	}

	@PostMapping(value = "oneBefor")
	public String oneBefor(@RequestParam(name = "id", required = false) Integer id) {
		//未回答の問題を取得
		service.unanswerdQuestion(id);

		return "redirect:/questions";

	}

}
