package uinti.uimakoulu.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uinti.uimakoulu.domain.Course;
import uinti.uimakoulu.domain.CourseRepository;

@RestController
public class RestCourseController {

	@Autowired
	CourseRepository courseRepository;
	
	
	@GetMapping("/courses") // kurssien listan palauttaminen
	public Iterable<Course> getCourse(){
		return courseRepository.findAll();
	}
	
	@PutMapping("/courses/{id}") // kurssien muokkaaminen
		Course editCourse(@RequestBody Course editedCourse, @PathVariable Long id) {
		editedCourse.setId(id);
		return courseRepository.save(editedCourse);
	}
	
	@DeleteMapping("/courses/{id}") // kurssin poistaminen
	public Iterable<Course>  deleteCourse(@PathVariable Long id) {
		courseRepository.deleteById(id);
	return courseRepository.findAll();
	}
	
	@PostMapping("courses") // uuden kurssin luominen
	Course newCourse(@RequestBody Course newCourse) {
		return courseRepository.save(newCourse);
	}
	
}
