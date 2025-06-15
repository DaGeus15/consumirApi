package com.repaso.SimpleWebApp.repository;

import com.repaso.SimpleWebApp.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<student, String> {
}
