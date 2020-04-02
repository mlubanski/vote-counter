package vote.counter.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Language API")
@RequestMapping("/survey-overview")
public class QuestionController {
	
	@Autowired
	private SurveyRepository repository;
	
	@ApiOperation(value = "View a list of questions for selected survey")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = "surveyId")
    public ResponseEntity<List<Question>> getQuestions(@RequestParam(value = "surveyId", required = true) String surveyId) {	
		Survey survey = repository.findSurveyById(surveyId);
		
		if (survey == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(survey.getQuestions(), HttpStatus.OK);
    }
	
	@ApiOperation(value = "Create question with answers for selected Survey")
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, params = "surveyId")
    public ResponseEntity<Question> createQuestion(@RequestParam(value = "surveyId", required = true) String surveyId, @RequestBody(required = true) Question question) {
		Survey survey = repository.findSurveyById(surveyId);
		
		if (survey == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		survey.addQuestion(question);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
}
