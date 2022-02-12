package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class StudentController {
	
	
	@GetMapping("/student")
	public Student getStudent() {
		return new Student ("Ramesh", "Fadatre");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student("Ramesh", "Fadatare"));
		students.add(new Student("Suresh", "Jain"));
		students.add(new Student("Amit", "Kumar"));
		students.add(new Student("Tony", "Cena"));
		students.add(new Student("Arpit", "Kaur"));
		return students;
		
		
	}
	
	// https://localhost:8080/student/ramesh/fadatare
	//@PathVariable annotation
	@GetMapping("/student/{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return new Student (firstName, lastName);
	}
	
	
	//build rest API to handle query parameters
	// https://localhost:8080/student?firstName=Ramesh&lastName=Fadatare
	@GetMapping("/student/query")
	public Student studentQueryParam(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName") String lastName) {
		return new Student(firstName, lastName);
	}
	
	
}
