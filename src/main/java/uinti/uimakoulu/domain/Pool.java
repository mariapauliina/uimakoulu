package uinti.uimakoulu.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pool {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long poolid;
    private String poolName;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pool")
    private List<Course> courses;
    
    public Pool() {}
    public Pool(String poolName) {
    	super();
    	this.poolName = poolName;
    }

    public Long getPoolid() {
        return poolid;
    }

    public void setPoolid(Long poolid) {
        this.poolid = poolid;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

       

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

	@Override
	public String toString() {
		return "Pool [poolid=" + poolid + ", poolName=" + poolName + "]";
	}
}

