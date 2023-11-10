package uinti.uimakoulu.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import uinti.uimakoulu.domain.Course;
import uinti.uimakoulu.domain.CourseRepository;

@Controller
public class UimakouluController {
	@Autowired
	private CourseRepository repository; 
	
	@RequestMapping(value= {"/", "/listCourses"})
	public String courseList(Model model) {
		model.addAttribute("courses", repository.findAll());
		return "listCourses";
	}
	
	@GetMapping("/showForm") //uusi lomake
	public String showForm(Model model) {
	model.addAttribute("course", new Course());
	return "addNewCourse";
	}
	
	@PostMapping("/addCourse") // tallentaa uuden kurssin
	public String addCourse(@ModelAttribute Course course) {
		repository.save(course);
		return"redirect:listCourses";
	} 
	
	@GetMapping(value="/delete/{id}") //kurssin poistaminen
	public String deleteCourse(@PathVariable("id") Long courseId, Model model) {
		repository.deleteById(courseId);
		return"redirect:/listCourses";
	}
	
	 @GetMapping("/editCourse/{id}")
	    public String showEditBookForm(@PathVariable Long id, Model model) { //muokkaaminen
	        Course course = repository.findById(id).orElse(null);
	        model.addAttribute("course", course);	        
	        return "editCourse";
	    }

	    @PostMapping("/editCourse")
	    public String editCourse(@ModelAttribute Course course) {
	        repository.save(course); 
	        return "redirect:/listCourses";
	    }
	    
	    
	
	
}
