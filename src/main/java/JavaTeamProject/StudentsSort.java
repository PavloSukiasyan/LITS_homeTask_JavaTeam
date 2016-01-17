package JavaTeamProject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StudentsSort {
	
	private List<StudentsJsonDTO> students;
	
	public StudentsSort() {
		students = new ArrayList<StudentsJsonDTO> ();
	}
	
	public void setStudents(Collection <StudentsJsonDTO> students) {
		this.students.addAll(students);
	}
	
	public void sort() {
		Collections.sort(students, new StudentsJsonDtoComparator());
	}
	
	public List<StudentsJsonDTO> getSortedStudents() {
		return students;
	}
	
}
