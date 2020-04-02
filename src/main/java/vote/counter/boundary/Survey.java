package vote.counter.boundary;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

public class Survey {

	private String id;
	private String title;
	private List<Question> questions;

	public Survey(String title) {
		this();
		this.title = title;
	}
	
	public Survey() {
		questions = new ArrayList<>();
	}

	public Survey addQuestion(Question question) {
		if (question != null) {
			questions.add(question);
		}
		return this;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public List<Question> getQuestions() {
		return questions;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", title=" + title + ", questions=" + questions + "]";
	}
}
