package JavaTeamProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class StudentsTestDrive {

	/*
	 * D:\WorkspaceEclipse\LITS_homeTask_JavaTeam> mvn exec:java
	 * -Dexec.mainClass="JavaTeamProject.StudentsTestDrive"
	 */
	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, IOException, FileNotFoundException {
		InputStream input = new FileInputStream("src/main/resources/Students.json");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		TypeFactory typeFactory = TypeFactory.defaultInstance();
		List<StudentsJsonDTO> studentsList = objectMapper.readValue(input,
				typeFactory.constructCollectionType(ArrayList.class, StudentsJsonDTO.class));

		for (int i = 0; i < studentsList.size(); i++) {
			System.out.print(studentsList.get(i).getLast_name() + ", ");
			System.out.print(studentsList.get(i).getCourse() + ", ");
			System.out.println(studentsList.get(i).getAge());
		}
		Comparator<StudentsJsonDTO> com1 = new Comparator<StudentsJsonDTO>() {

			public int compare(StudentsJsonDTO o1, StudentsJsonDTO o2) {
				int c;
				c = o1.getLast_name().compareTo(o2.getLast_name());
				if (c == 0) {
					c = o1.getCourse().compareTo(o2.getCourse()); // compareToIgnoreCase
				}
				if (c == 0) {
					c = o1.getAge() - o2.getAge();
				}
				return c;
			}
		};
		Collections.sort(studentsList, com1);
		System.out.println("\n" + "After sorting" + "\n");

		for (int i = 0; i < studentsList.size(); i++) {
			System.out.print(studentsList.get(i).getLast_name() + ", ");
			System.out.print(studentsList.get(i).getCourse() + ", ");
			System.out.println(studentsList.get(i).getAge());
		}
	}
}
