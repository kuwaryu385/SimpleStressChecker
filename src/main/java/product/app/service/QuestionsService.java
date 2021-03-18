package product.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.app.domain.Questions;
import product.app.repository.QuestionsRepository;

@Service
public class QuestionsService {

	@Autowired
	public QuestionsRepository questionsRepository;

	public List<Questions> selectAll() {
		return questionsRepository.selectAll();
	}

	public Questions selectOne(int id) {
		return questionsRepository.selectOne(id);
	}

	public int countQuestions() {
		return questionsRepository.countQuestions();
	}

	public int deleteQuestions() {
		return questionsRepository.deleteQuestions();
	}

	public int insertQuestions(List<Integer> id) {
		return questionsRepository.insertQuestions(id);
	}

	public int countMyQuestions() {
		return questionsRepository.countMyQuestions();
	}

	public List<Integer> idQuestion() {
		return questionsRepository.idQuestion();
	}

	public int reviewQuestion(int id) {
		return questionsRepository.reviewQuestion(id);
	}

	public int answerdQuestion(int id) {
		return questionsRepository.answerdQuestion(id);
	}

	public int countReview() {
		return questionsRepository.countReview();
	}

}
