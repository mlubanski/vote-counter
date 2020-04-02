package vote.counter.boundary;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class SurveyRepository {

	private List<Survey> surveys = new ArrayList<>();
	
	private String generateId() {
		return RandomStringUtils.randomAlphabetic(5);
	}

	public List<Survey> getAll() {
		return surveys;
	}

	public Survey add(Survey survey) {
		survey.setId(generateId());
		surveys.add(survey);
		return survey;
	}
	
	public Survey findSurveyById(String id) {
		for (Survey survey : surveys) {
			if (survey.getId().equals(id)) {
				return survey;
			}
		}
		return null;
	}
}
