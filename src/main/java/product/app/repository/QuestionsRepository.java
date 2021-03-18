package product.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import product.app.domain.Questions;

@Mapper
public interface QuestionsRepository {

	// 全件検索用する。
	public List<Questions> selectAll();

	// １件検索する。
	public Questions selectOne(int id);

	// 質問題数カウント用メソッド
	public int countQuestions();

	//初期化のため質問集を削除
	public int deleteQuestions();

	//初期化後の質問集の登録
	public int insertQuestions(List<Integer> id);

	// 質問数を取得する。
	public int countMyQuestions();

	//出題IDを取得する
	public List<Integer> idQuestion();

	//正解・不正解結果メソッド
	public int reviewQuestion(int id);

	//解答済結果メソッド
	public int answerdQuestion(int id);

	//正解数取得メソッド
	public int countReview();

}
