package com.relationship.example.controller;

import com.relationship.example.entity.Course;
import com.relationship.example.entity.Student;
import com.relationship.example.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student-course/api/v1")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping("/create-student")
    public Student createStudent(@RequestBody Student student){
        return studentCourseService.createStudentWithCourse(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentCourseService.findAllStudents();
    }

    @GetMapping("/students/{studentId}")
    private Student getStudent(@PathVariable Long studentId){
        Optional<Student> student = studentCourseService.findStudent(studentId);
        return student.get();
    }

    @GetMapping("/searchStudent/{studentName}")
    public List<Student> getStudentByName(@PathVariable String studentName){
        return studentCourseService.getStudentByName(studentName);
    }

    @GetMapping("/getBudgetCourse/{fees}")
    public List<Course> getCourseLessThanPrice(double fees){
        return studentCourseService.getCourseLessThanPrice(fees);
    }
}
