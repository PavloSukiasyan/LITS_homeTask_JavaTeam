package JavaTeamProject;

import java.util.Comparator;

public class StudentsJsonDtoComparator implements Comparator<StudentsJsonDTO> {

	public int compare(StudentsJsonDTO o1, StudentsJsonDTO o2) {
		int lastNameCompareRes = o1.getLast_name().compareTo(o2.getLast_name());
		
		if (lastNameCompareRes != 0) {
			return  lastNameCompareRes;
		} else {
			int courseCompareRes = o1.getCourse().compareTo(o2.getCourse());
			
			if (courseCompareRes != 0) {
				return courseCompareRes;
			} else {
				return Integer.valueOf(o1.getAge()).compareTo(o2.getAge());
			}
		}
	}

}
