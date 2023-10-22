package com.dfi.deanapp.services;

import java.util.List;
import com.dfi.deanapp.models.Teacher;

public interface TeachersServiceInterface {
	List<Teacher> getAllTeachers();
	Teacher saveTeacher(Teacher student);
	Teacher getTeacherById(Long id);
	Teacher updateTeacher(Teacher student);
	void deleteTeacherById(Long id);
}
