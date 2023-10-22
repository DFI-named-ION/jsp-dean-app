package com.dfi.deanapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dfi.deanapp.models.Student;

public interface StudentsRepoInterface extends JpaRepository<Student, Long> {
	
}
