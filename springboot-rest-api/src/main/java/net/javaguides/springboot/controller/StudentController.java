package net.javaguides.springboot.controller;


import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(1,"Madhavi","Thurlapati");
        return student;
    }

    //http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2,"Murali","Alamalakala"));
        students.add(new Student(3,"Maddie","Alamalakala"));
        students.add(new Student(4,"Shruthi","Alamalakala"));
        students.add(new Student(5,"Adithya","Alamalakala"));
        return students;
    }

    //Spring boot rest api with path variable
    //http://localhost:8080/students/1
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId,firstName,lastName);
    }

    //Spring boot rest api with request param annotation
    //http://localhost:8080/students/query?id=1&firstName="Madhavi"&"lastName="Thurlapati"
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(id,firstName,lastName);
    }

    //Spring boot rest api with post request
    //http://localhost:8080/students/create
    @PostMapping("students/create")
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

}
