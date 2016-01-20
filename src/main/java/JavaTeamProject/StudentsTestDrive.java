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

		for(StudentsJsonDTO student : studentsList) {
			System.out.print(student.getLast_name() + ", ");
			System.out.print(student.getCourse() + ", ");
			System.out.println(student.getAge());	
		}
		
		System.out.println();
		System.out.println("Sorted students:");
		
		StudentsSort studentsSort = new StudentsSort(studentsList);
		studentsSort.sort();
		
		List<StudentsJsonDTO> sortedStudents = studentsSort.getSortedStudents();
		
		for (StudentsJsonDTO student : sortedStudents) {
			System.out.print(student.getLast_name() + ", ");
			System.out.print(student.getCourse() + ", ");
			System.out.println(student.getAge());	
		}
	}

}
