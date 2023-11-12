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
import uinti.uimakoulu.domain.PoolRepository;

@Controller
public class UimakouluController {
	@Autowired
	private CourseRepository repository; 
	
	@Autowired
	private PoolRepository prepository;
	
	@RequestMapping(value= {"/", "/listCourses"}) //näyttää kaikki kurssit
	public String courseList(Model model) {
		model.addAttribute("courses", repository.findAll());
		return "listCourses";
	}
	
	@GetMapping("/showForm") //näyttää lomakkeen uuden kurssin lisäämistä varten
	public String showForm(Model model) {
	model.addAttribute("course", new Course());
	model.addAttribute("pools", prepository.findAll());
	return "addNewCourse";
	}
	
	@PostMapping(value="/save") // tallentaa uuden kurssin lomakkeelta
	public String save(@ModelAttribute Course course) {
	    // Check if the pool is a new instance (unsaved)
	    if (course.getPool() != null && course.getPool().getPoolid() == null) {
	        // Save the new pool
	        prepository.save(course.getPool());
	    }

	    // Save the course (this will also save the pool if it's a new instance)
	    repository.save(course);

	    return "redirect:listCourses";
	}
	
	
	

		
	
	@GetMapping(value="/delete/{id}") //kurssin poistaminen
	public String deleteCourse(@PathVariable("id") Long courseId, Model model) {
		repository.deleteById(courseId);
		return"redirect:/listCourses";
	}
	
	 @GetMapping("/editCourse/{id}")
	    public String showEditCourseForm(@PathVariable Long id, Model model) { //muokkaaminen
	        Course course = repository.findById(id).orElse(null);
	        model.addAttribute("course", course);
	        model.addAttribute("pools", prepository.findAll());
	        return "editCourse";
	    }

	    @PostMapping("/editCourse")
	    public String editCourse(@ModelAttribute Course course) {
	        repository.save(course); 
	        return "redirect:/listCourses";
	    }
	   
	    
	
	
}
