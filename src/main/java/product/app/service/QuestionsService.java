package product.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import product.app.domain.Questions;
import product.app.repository.QuestionsRepository;

@Service
public class QuestionsService {

	@Autowired
	public QuestionsRepository questionsRepository;

	// 全件検索する。
	public List<Questions> selectAll() {
		return questionsRepository.selectAll();
	}

	//１件検索する
	public Questions selectOne(int id) {
		return questionsRepository.selectOne(id);
	}

	//質問数をカウントする
	public int countQuestions() {
		return questionsRepository.countQuestions();
	}

	//初期化のため質問集を削除
	@Transactional
	public int deleteQuestions() {
		return questionsRepository.deleteQuestions();
	}

	//初期化後の質問の登録
	@Transactional
	public int insertQuestions(List<Integer> id) {
		return questionsRepository.insertQuestions(id);
	}

	// 質問数を取得する。
	public int countMyQuestions() {
		return questionsRepository.countMyQuestions();
	}

	//未出題IDを取得する
	public List<Integer> idQuestion() {
		return questionsRepository.idQuestion();
	}

	//正解・不正解結果メソッド
	@Transactional
	public int reviewQuestion(int id) {
		return questionsRepository.reviewQuestion(id);
	}

	//解答済結果を取得する。
	@Transactional
	public int answerdQuestion(int id) {
		return questionsRepository.answerdQuestion(id);
	}

	//「はい」と回答した数取得する。
	public int countReview() {
		return questionsRepository.countReview();
	}

	//回答後IDを取得する
	public List<Integer> idUesedQuestion() {
		return questionsRepository.idUesedQuestion();
	}

	//未回答に設定して前の問題へ戻る。
	@Transactional
	public int unanswerdQuestion(int id) {
		return questionsRepository.unanswerdQuestion(id);
	}

}
