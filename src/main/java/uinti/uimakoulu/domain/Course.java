package uinti.uimakoulu.domain;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String courseName, place, date, time,coach;
	
	@ManyToOne
	@JoinColumn(name="poolid")
	private Pool pool;
	
	
	public Course() {}
	
	public Course(Long id, String courseName, String place, String date, String time, String coach, Pool pool) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.place = place;
		this.date = date;
		this.time = time;
		this.coach = coach;
		this.pool = pool;
	
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Pool getPool() {
		return pool;
	}

	public void setPool(Pool pool) {
		this.pool = pool;
	}
	

	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}

	@Override
	public String toString() {
		if (this.pool !=null)
			return "Course [id=" + id + ", courseName=" + courseName + ", place=" + place + ", date=" + date + ", time="
				+ time + ", coach=" + coach + ", pool=" + pool + "]";
		else
			return "Course [id=" + id + ", courseName=" + courseName + ", place=" + place + ", date=" + date + ", time="
					+ time + ", coach=" + coach + "]";
	}
	
	
}
