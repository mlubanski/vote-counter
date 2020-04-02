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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Language API")
@RequestMapping("/survey")
public class SurveyController {
	
	@Autowired
	private SurveyRepository repository;

	@ApiOperation(value = "View a list of created surveys")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Survey>> getSurveys() {        
        return new ResponseEntity<>(repository.getAll(), HttpStatus.OK);
    }
	
	@ApiOperation(value = "Create new Survey surveys")
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Survey> createSurvey(@RequestBody(required = true) Survey survey) {
		repository.add(survey);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }
	
	@RequestMapping(value="/survey-overview.html")
	@ResponseBody
	public String pathVars() {
		return "survey-overview.html";
	}
}
