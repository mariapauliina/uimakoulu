package uinti.uimakoulu;






import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import uinti.uimakoulu.domain.Course;
import uinti.uimakoulu.domain.CourseRepository;
import uinti.uimakoulu.domain.Pool;
import uinti.uimakoulu.domain.PoolRepository;


@SpringBootApplication
public class UimakouluApplication {
	private static final Logger log = LoggerFactory.getLogger(UimakouluApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(UimakouluApplication.class, args);
	}
	 @Bean
	    public CommandLineRunner addPools(CourseRepository crepository, PoolRepository prepository) {
	        return args -> {
	        	log.info("tallennetaan uimahallit");
	        	
	        	
	        	Pool pool1 = new Pool();
	            pool1.setPoolName("SYK");
	            prepository.save(pool1);
	            
	            Pool pool2 = new Pool();
	            pool2.setPoolName("Pirkkola");
	            prepository.save(pool2);
	            
	            Pool pool3 = new Pool();
	            pool3.setPoolName("Mäkelänrinteen uintikeskus");
	            prepository.save(pool3);

	           Course course1 = new Course();
	            course1.setCourseName("Aikuisten harkkaryhmä");
	            course1.setPlace("Helsinki");
	            course1.setDate("11.11.2023");
	            course1.setTime("klo 13");
	            course1.setCoach("Unto Uimari");
	            course1.setPool(pool1);
	            crepository.save(course1);
	            
	            
	           
	        };
	    }

}
