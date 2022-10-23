package com.relationship.example.service;

import com.relationship.example.entity.Course;
import com.relationship.example.entity.Student;
import com.relationship.example.repository.CourseRepository;
import com.relationship.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseService {

    private StudentRepository studentRepository;

    private CourseRepository courseRepository;

    public StudentCourseService(StudentRepository studentRepository,
                                   CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Student createStudentWithCourse(Student student){
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> findStudent(Long studentId){
        return studentRepository.findById(studentId);
    }

    public List<Student> getStudentByName(String name){
        return studentRepository.findByNameContaining(name);
    }

    public List<Course> getCourseLessThanPrice(double fees){
        return courseRepository.findByFeesLessThan(fees);
    }
}
