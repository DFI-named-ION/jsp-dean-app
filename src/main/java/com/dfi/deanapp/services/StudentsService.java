package com.dfi.deanapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dfi.deanapp.models.Student;
import com.dfi.deanapp.repos.StudentsRepoInterface;
import com.dfi.deanapp.services.StudentsServiceInterface;

@Service
public class StudentsService implements StudentsServiceInterface {
	private StudentsRepoInterface studentsRepo;
	
	public StudentsService(StudentsRepoInterface studentsRepo) {
		super();
		this.studentsRepo = studentsRepo;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentsRepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentsRepo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentsRepo.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentsRepo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentsRepo.deleteById(id);		
	}
}
