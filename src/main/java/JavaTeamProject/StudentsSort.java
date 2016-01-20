package JavaTeamProject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StudentsSort {
	
	private List<StudentsJsonDTO> students;
	
	public StudentsSort(Collection <StudentsJsonDTO> studentsCollection) {
		students = new ArrayList<StudentsJsonDTO> ();
		students.addAll(studentsCollection);
	}
	
	public void sort() {
		Collections.sort(students, new StudentsJsonDtoComparator());
	}
	
	public List<StudentsJsonDTO> getSortedStudents() {
		return students;
	}
	
}
