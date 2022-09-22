package edu.deakin.sit218.coachwebapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "exam") // Just to be explicit
public class Exam {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	protected int id;

	@NotEmpty (message = "need to fill this in")
	String area;
	
	@NotEmpty (message = "need to fill this in")
	String question;
	
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z]*", message = "Accepting only one word for answer")
	String answer;

	public Exam(String area, String question, String answer) {
		super();
		this.area = area;
		this.question = question;
		this.answer = answer;
	}

	public Exam() {
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return "client = [area: "+getArea()+", question: "+getQuestion()+
				", answer: "+ getAnswer()+"]";
	}

}
