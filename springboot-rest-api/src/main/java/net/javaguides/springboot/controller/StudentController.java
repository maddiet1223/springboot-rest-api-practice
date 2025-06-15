package net.javaguides.springboot.controller;


import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1,"Madhavi","Thurlapati");
        //return new ResponseEntity<>(student,HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header","Maddie").body(student);
    }

    //http://localhost:8080/students
    @GetMapping()
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2,"Murali","Alamalakala"));
        students.add(new Student(3,"Maddie","Alamalakala"));
        students.add(new Student(4,"Shruthi","Alamalakala"));
        students.add(new Student(5,"Adithya","Alamalakala"));
        return ResponseEntity.ok(students);
    }

    //Spring boot rest api with path variable
    //http://localhost:8080/students/1
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId,firstName,lastName);
        return ResponseEntity.ok(student);
    }

    //Spring boot rest api with request param annotation
    //http://localhost:8080/students/query?id=1&firstName="Madhavi"&"lastName="Thurlapati"
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        Student student = new Student(id,firstName,lastName);
        return ResponseEntity.ok(student);
    }

    //Spring boot rest api with post request
    //http://localhost:8080/students/create
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //Spring boot rest api with put request
    //http://localhost:8080/students/3/update
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //Spring boot rest api with delete request
    //http://localhost:8080/students/3/delete
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
       return ResponseEntity.ok("Student deleted successfully!");
    }
}
