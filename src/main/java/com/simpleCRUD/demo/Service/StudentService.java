package com.simpleCRUD.demo.Service;

import com.simpleCRUD.demo.DTO.StudentDTO;
import com.simpleCRUD.demo.Entity.Student;
import com.simpleCRUD.demo.Repository.StudentRepository;
import com.simpleCRUD.demo.Utils.PersistenceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //Create
    public Student createStudent(Student student) {
        try {
            return studentRepository.save(student);
        } catch (Exception e) {
            throw new RuntimeException("Cannot add this student");
        }
    }

    //Read
    public List<Student> findAllStudents() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Cannot show student list");
        }

    }

    //Update
    public Student updateStudent(Integer id, Student student) {
        try {
            Student curStudent = studentRepository.findById(id).get();
            if (curStudent == null) {
                throw new RuntimeException("The student with this ID doesn't exist.");
            }
            student = (Student) PersistenceUtils.partialUpdate(curStudent, student);
            return studentRepository.save(student);
        } catch (Exception e) {
            throw new RuntimeException("Cannot update this student");
        }
    }

    //Delete
    public void deleteStudent(Integer id) {
        try {
            Student curStudent = studentRepository.findById(id).get();
            if (curStudent == null) {
                throw new RuntimeException("The student with this ID doesn't exist.");
            }
            studentRepository.delete(curStudent);
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete this student");
        }
    }
}
