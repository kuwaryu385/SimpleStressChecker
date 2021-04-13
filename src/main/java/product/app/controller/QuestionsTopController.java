package product.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import product.app.service.QuestionsService;

@Controller
@RequestMapping("/sqtop")
public class QuestionsTopController {

	@Autowired
	private QuestionsService service;

	@GetMapping
	public String top() {
		return "top";
	}

	@PostMapping(value = "start")
	public String start() {

		//問題数の取得
		int questionCount = service.countQuestions();

		//出題テーブルを初期化
		service.deleteQuestions();

		//出題リスト
		List<Integer> questionList = new ArrayList<>();
		for (int i = 1; i <= questionCount; i++) {
			questionList.add(i);
		}
		//出題リストに登録
		service.insertQuestions(questionList);

		return "redirect:/sqtop/questions";
	}

}
