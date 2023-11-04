package uinti.uimakoulu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String courseName, place, date, time,coach;
	
	public Course() {}
	
	public Course(Long id, String courseName, String place, String date, String time, String coach) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.place = place;
		this.date = date;
		this.time = time;
		this.coach = coach;
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
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", place=" + place + ", date=" + date + ", time="
				+ time + ", coach=" + coach + "]";
	}
	
}
