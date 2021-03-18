package product.app.domain;

public class Questions {

	private int id;
	private String question;
	private String choiceY;
	private String choiceN;
	private int answer;
	private boolean answered;
	private boolean answerRate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getChoiceY() {
		return choiceY;
	}

	public void setChoiceY(String choiceY) {
		this.choiceY = choiceY;
	}

	public String getChoiceN() {
		return choiceN;
	}

	public void setChoiceN(String choiceN) {
		this.choiceN = choiceN;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public boolean isAnswered() {
		return answered;
	}

	public void setAnswered(boolean answered) {
		this.answered = answered;
	}

	public boolean isAnswerRate() {
		return answerRate;
	}

	public void setAnswerRate(boolean answerRate) {
		this.answerRate = answerRate;
	}

}
