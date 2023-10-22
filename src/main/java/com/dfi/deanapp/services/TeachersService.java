package com.dfi.deanapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.dfi.deanapp.models.Teacher;
import com.dfi.deanapp.repos.TeachersRepoInterface;
import com.dfi.deanapp.services.TeachersServiceInterface;

@Service
public class TeachersService implements TeachersServiceInterface {
	private TeachersRepoInterface teachersRepo;
	
	public TeachersService(TeachersRepoInterface teachersRepo) {
		super();
		this.teachersRepo = teachersRepo;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teachersRepo.findAll();
	}

	@Override
	public Teacher saveTeacher(Teacher student) {
		return teachersRepo.save(student);
	}

	@Override
	public Teacher getTeacherById(Long id) {
		return teachersRepo.findById(id).get();
	}

	@Override
	public Teacher updateTeacher(Teacher student) {
		return teachersRepo.save(student);
	}

	@Override
	public void deleteTeacherById(Long id) {
		teachersRepo.deleteById(id);		
	}
}
