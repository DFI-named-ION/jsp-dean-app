package com.dfi.deanapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dfi.deanapp.models.Teacher;

public interface TeachersRepoInterface extends JpaRepository<Teacher, Long> {
	
}
