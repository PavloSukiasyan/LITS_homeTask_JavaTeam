package JavaTeamProject;

import java.util.Comparator;

public class StudentsJsonDtoComparator implements Comparator<StudentsJsonDTO> {

	public int compare(StudentsJsonDTO o1, StudentsJsonDTO o2) {
		String lastName1 = o1.getLast_name();
		String lastName2 = o2.getLast_name();
		
		int lastNameCompareRes = lastName1.compareTo(lastName2);
		
		if (lastNameCompareRes != 0) {
			return  lastNameCompareRes;
		} else {
			return Integer.valueOf(o1.getAge()).compareTo(o2.getAge());
		}
	}

}
