package vote.counter.boundary;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.util.Strings;

public class Question {
	
	private String id;
	private String title;
	private List<String> answers;
	
	public Question(String title) {
		this();
		this.title = title;
	}
	
	public Question() {
		id = RandomStringUtils.randomAlphabetic(5);
		answers = new ArrayList<>();
	}
	
	public Question add(String answer) {
		if (!Strings.isBlank(answer)) {
			answers.add(answer);
		}
		
		return this;
	}
	
	public String gettitle() {
		return title;
	}
	
	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", answers=" + answers + "]";
	}
}
