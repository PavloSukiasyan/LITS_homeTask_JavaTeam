package JavaTeamProject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentsJsonDTO {

	private String last_name;
	private String course;
	private int age;
	
	@JsonCreator
	public StudentsJsonDTO (@JsonProperty("last_name") String last_name,
			@JsonProperty("course") String course,
			@JsonProperty("age") int age) {
		this.last_name = last_name;
		this.course = course;
		this.age = age;
	}
	
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}