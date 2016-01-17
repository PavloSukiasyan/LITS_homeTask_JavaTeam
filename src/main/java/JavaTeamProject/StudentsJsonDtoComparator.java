package JavaTeamProject;

import java.util.Comparator;

public class StudentsJsonDtoComparator implements Comparator<StudentsJsonDTO> {

	public int compare(StudentsJsonDTO o1, StudentsJsonDTO o2) {
		String firstName = o1.getLast_name();
		String secondName = o2.getLast_name();
		return firstName.compareTo(secondName);
	}

}
