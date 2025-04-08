package com.example.demo.service;

import com.example.demo.data.Student;
import com.example.demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void delete(int id) {
        studentRepository.deleteById(id);
    }

    public void updateStudent(int id, String name, int age, double rating) {
        studentRepository.findById(id).ifPresent(student -> {
           student.setName(name);
           student.setAge(age);
           student.setRating(rating);
           studentRepository.save(student);
        });
    }
}
