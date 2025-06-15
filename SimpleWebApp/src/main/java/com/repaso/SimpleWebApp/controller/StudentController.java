package com.repaso.SimpleWebApp.controller;

import com.repaso.SimpleWebApp.entity.student;
import com.repaso.SimpleWebApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String getStudents(Model model) {
        model.addAttribute("students",studentRepository.findAll());
        return "index";
    }

    @GetMapping("/buscar")
    public String getStudentByCedula(Model model, String id) {
        studentRepository.findById(id).ifPresentOrElse(
                student -> model.addAttribute("students", List.of(student)),
                () -> model.addAttribute("students", List.of())
        );
        return "index";
    }

    @PostMapping("/crear")
    public String postStudent(Model model, String nombre,String apellido,String direccion,String telefono) {
        studentRepository.save(new student(nombre, apellido,direccion,telefono));
        return "redirect:/";
    }

    @PostMapping("/editar")
    public String putStudent(Model model,String id, String nombre,String apellido,String direccion,String telefono) {
        studentRepository.save(new student(id,nombre, apellido,direccion,telefono));
        return "redirect:/";
    }

    @PostMapping("/borrar/{id}")
    public String deleteStudent(Model model, @PathVariable String id) {
        studentRepository.deleteById(id);
        return "redirect:/";
    }
}
