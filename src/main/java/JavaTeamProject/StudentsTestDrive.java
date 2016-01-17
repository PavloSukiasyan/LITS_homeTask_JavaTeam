package JavaTeamProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class StudentsTestDrive {
	
	/*
	* D:\WorkspaceEclipse\LITS_homeTask_JavaTeam>
	* mvn exec:java -Dexec.mainClass="JavaTeamProject.StudentsTestDrive"
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

		System.out.print(studentsList.get(0).getLast_name() + ", ");
		System.out.print(studentsList.get(0).getCourse() + ", ");
		System.out.println(studentsList.get(0).getAge());

		System.out.print(studentsList.get(1).getLast_name() + ", ");
		System.out.print(studentsList.get(1).getCourse() + ", ");
		System.out.println(studentsList.get(1).getAge());

		System.out.print(studentsList.get(2).getLast_name() + ", ");
		System.out.print(studentsList.get(2).getCourse() + ", ");
		System.out.println(studentsList.get(2).getAge());

		System.out.print(studentsList.get(3).getLast_name() + ", ");
		System.out.print(studentsList.get(3).getCourse() + ", ");
		System.out.println(studentsList.get(3).getAge());

		System.out.println();
		System.out.println("Sorted students:");
		
		StudentsSort studentsSort = new StudentsSort();
		studentsSort.setStudents(studentsList);
		studentsSort.sort();
		
		List<StudentsJsonDTO> sortedStudents = studentsSort.getSortedStudents();
		
		for (StudentsJsonDTO student : sortedStudents) {
			System.out.print(student.getLast_name() + ", ");
			System.out.print(student.getCourse() + ", ");
			System.out.println(student.getAge());	
		}
		
	}

}
