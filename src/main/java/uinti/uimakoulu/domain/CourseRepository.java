package uinti.uimakoulu.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByCourseName(String courseName);

}