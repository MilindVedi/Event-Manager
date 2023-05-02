package com.milind.usermanagement.controller;

import com.milind.usermanagement.model.Student;
import com.milind.usermanagement.model.DepartmentUpdateRequest;
import com.milind.usermanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public String addUser(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Student student = studentService.getStudentFromStudentId(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List <Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/updateStudentDepartment")
    public String updateStudentDepartment(@RequestBody DepartmentUpdateRequest request) {
        Boolean updated = studentService.updateStudentDepartment(request);
        if(updated) {
            return "Department updated for student "
                    + studentService.getStudentFromStudentId(request.getStudentId()).getFirstName()
                    + " " + studentService.getStudentFromStudentId(request.getStudentId()).getFirstName() + " updated"
                    + " as " + request.getDepartment();
        }
        else {
            return "No such student present";
        }
    }

    @PostMapping("/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudentWithStudentId(studentId);
        return "Student Removed";
    }
}
