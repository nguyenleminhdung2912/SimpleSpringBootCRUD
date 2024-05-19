package com.simpleCRUD.demo.Controller;

import com.simpleCRUD.demo.DTO.StudentDTO;
import com.simpleCRUD.demo.Entity.Student;
import com.simpleCRUD.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Create
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    //Read
    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

    //Update
    @PutMapping("/update/{id}")
    public Student updateStudent (@PathVariable Integer id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return "Student Deleted";
    }

}
