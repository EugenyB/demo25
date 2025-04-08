package com.example.demo.controller;

import com.example.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping
    public String showAllStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id) {
        studentService.delete(id);
        return "redirect:/students";
    }

    @PostMapping("/edit")
    public String editStudent(
            @RequestParam("id") int id,
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam double rating) {
        studentService.updateStudent(id, name, age, rating);
        return "redirect:/students";
    }

    @PostMapping("/add")
    public String addStudent(@RequestParam String name,
                             @RequestParam int age,
                             @RequestParam double rating) {
        studentService.addStudent(name, age, rating);
        return "redirect:/students";
    }
}

