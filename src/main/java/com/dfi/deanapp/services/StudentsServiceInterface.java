package com.dfi.deanapp.services;

import java.util.List;
import com.dfi.deanapp.models.Student;

public interface StudentsServiceInterface {
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
}
