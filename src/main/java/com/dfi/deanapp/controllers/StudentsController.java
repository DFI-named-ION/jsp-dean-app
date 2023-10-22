package com.dfi.deanapp.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dfi.deanapp.models.Student;
import com.dfi.deanapp.services.StudentsService;

@Controller
public class StudentsController {
	
	private StudentsService studentsService;
	
	public StudentsController(StudentsService studentsService) {
		super();
		this.studentsService = studentsService;
	}

	@GetMapping("/students/list")
	public String listStudentsPage(Model model) {
		model.addAttribute("pageTitle", "DeanOffice - Студенти");
		model.addAttribute("studentsList", studentsService.getAllStudents());
		return "students/list";
	}
	
	@GetMapping("/students/create")
	public String createPage(Model model) {
		model.addAttribute("pageTitle", "DeanOffice - Створення студента");
		model.addAttribute("student", new Student());
		return "students/create";
	}
	
	@PostMapping("/students/saveNew")
	public String saveNewStudent(@ModelAttribute("student") Student student) {
		studentsService.saveStudent(student);
		return "redirect:/students/list";
	}
	
	@GetMapping("/students/update/{id}")
	public String updatePage(@PathVariable Long id, Model model) {
		model.addAttribute("pageTitle", "DeanOffice - Оновити студента");
		model.addAttribute("student", studentsService.getStudentById(id));
		return "students/update";
	}
	
	@PostMapping("/students/saveAlt/{id}")
	public String saveStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
		Student existingStudent = studentsService.getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setFirstName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		studentsService.updateStudent(student);
		return "redirect:/students/list";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deletePage(@PathVariable Long id, Model model) {
		model.addAttribute("pageTitle", "DeanOffice - Видалити студента");
		studentsService.deleteStudentById(id);
		return "redirect:/students/list";
	}
}
