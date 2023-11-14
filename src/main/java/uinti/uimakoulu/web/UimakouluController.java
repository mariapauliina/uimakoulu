package uinti.uimakoulu.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
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
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
	    model.addAttribute("course", new Course());
	    model.addAttribute("pools", prepository.findAll());
	    return "addNewCourse";
	}

	@PostMapping("/add")
	public String addCourse(@Valid Course course, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        model.addAttribute("pools", prepository.findAll());
	        return "addNewCourse";
	    }if (course.getPool() != null && course.getPool().getPoolid() == null) {
	        // Tallenna uimahalli, jos se ei ole vielä tallennettu
	        prepository.save(course.getPool());
	    }

	    repository.save(course); // Tallennetaan kurssi tietokantaan

	    return "redirect:/listCourses"; // Ohjataan käyttäjä kurssien listaussivulle 
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
