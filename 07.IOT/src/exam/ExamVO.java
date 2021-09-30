package exam;

import java.io.Serializable;

public class ExamVO implements Serializable{
	//ctrl + shift + y == 소문자로 바꾸기 (영역)
	private String questionnumber ;
	private String question       ;
	private String choice1        ;
	private String choice2        ;
	private String choice3        ;
	private String choice4        ;
	private String answer          ;
	private String answerall      ;
	//실제 DB에서 가져온 내용들.
	//열 단위로 선택을 하기 위해서는 "ALT + SHIFT + A" 키를 눌러  블록 선택 모드로 바꿉니다.
	
	//사용자의 요청(답안제출)시 필요한 데이터를 담기 위한 필드.
	public String user_result; //사용자가 제출한 답안.
	public int result ; //정답이냐 아니냐
	
	
	//Getter and Setter만 만들고, 생성자는 안만들어줌 VO에서는
	public String getQuestionnumber() {
		return questionnumber;
	}
	public void setQuestionnumber(String questionnumber) {
		this.questionnumber = questionnumber;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getChoice1() {
		return choice1;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	public String getChoice3() {
		return choice3;
	}
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	public String getChoice4() {
		return choice4;
	}
	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswerall() {
		return answerall;
	}
	public void setAnswerall(String answerall) {
		this.answerall = answerall;
	}


}
