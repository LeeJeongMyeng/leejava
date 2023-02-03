package book_project;

public class QnAVO {
private String qnano;
private String userno;
private String Question;
private String Answer;

public QnAVO() {
}


public QnAVO(String qnano, String userno, String question, String answer) {
	this.qnano = qnano;
	this.userno = userno;
	Question = question;
	Answer = answer;
}


public QnAVO(String userno, String question, String answer) {
	this.userno = userno;
	Question = question;
	Answer = answer;
}

public QnAVO(String userno, String question) {
	this.userno = userno;
	Question = question;
}

public QnAVO(String answer) {
	Answer = answer;
}


public String getQnano() {
	return qnano;
}


public void setQnano(String qnano) {
	this.qnano = qnano;
}


public String getUserno() {
	return userno;
}

public void setUserno(String userno) {
	this.userno = userno;
}

public String getQuestion() {
	return Question;
}

public void setQuestion(String question) {
	Question = question;
}

public String getAnswer() {
	return Answer;
}

public void setAnswer(String answer) {
	Answer = answer;
}

}
