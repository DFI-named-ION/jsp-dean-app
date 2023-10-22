package com.dfi.deanapp.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dfi.deanapp.models.Teacher;
import com.dfi.deanapp.services.TeachersService;

@Controller
public class TeachersController {
	private TeachersService teachersService;
	
	public TeachersController(TeachersService teachersService) {
		super();
		this.teachersService = teachersService;
	}

	@GetMapping("/teachers/list")
	public String listTeachersPage(Model model) {
		model.addAttribute("pageTitle", "DeanOffice - Викладачі");
		model.addAttribute("teachersList", teachersService.getAllTeachers());
		return "teachers/list";
	}
	
	@GetMapping("/teachers/create")
	public String createPage(Model model) {
		model.addAttribute("pageTitle", "DeanOffice - Створення викладача");
		model.addAttribute("teacher", new Teacher());
		return "teachers/create";
	}
	
	@PostMapping("/teachers/saveNew")
	public String saveNewTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teachersService.saveTeacher(teacher);
		return "redirect:/teachers/list";
	}
	
	@GetMapping("/teachers/update/{id}")
	public String updatePage(@PathVariable Long id, Model model) {
		model.addAttribute("pageTitle", "DeanOffice - Оновити викладача");
		model.addAttribute("teacher", teachersService.getTeacherById(id));
		return "teachers/update";
	}
	
	@PostMapping("/teachers/saveAlt/{id}")
	public String saveTeacher(@PathVariable Long id, @ModelAttribute("teacher") Teacher teacher) {
		Teacher existingStudent = teachersService.getTeacherById(id);
		existingStudent.setFirstName(teacher.getFirstName());
		existingStudent.setLastName(teacher.getLastName());
		existingStudent.setSubject(teacher.getSubject());
		teachersService.updateTeacher(teacher);
		return "redirect:/teachers/list";
	}
	
	@GetMapping("/teachers/delete/{id}")
	public String deletePage(@PathVariable Long id, Model model) {
		model.addAttribute("pageTitle", "DeanOffice - Видалити викладача");
		teachersService.deleteTeacherById(id);
		return "redirect:/teachers/list";
	}
}
