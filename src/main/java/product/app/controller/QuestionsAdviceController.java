package product.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/advice")
public class QuestionsAdviceController {

	@GetMapping
	public String advice() {

		return "advice";

	}

}
