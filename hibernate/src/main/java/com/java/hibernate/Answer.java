package com.java.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Answer {
	@Id
	@Column(name="answer_id")
	private int id;
	private String answer;
	@OneToOne
	@JoinColumn(name="q_id")
	private Question question;

	public int getId() {
		return id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + ", question=" + question + "]";
	}
	
	

}
