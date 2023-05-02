package com.milind.usermanagement.service;

import com.milind.usermanagement.model.DepartmentUpdateRequest;
import com.milind.usermanagement.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class StudentService {
    private static HashMap<Long, Student> StudentIdsToStudents = new HashMap<>();
    public String addStudent(Student student) {
        StudentIdsToStudents.put(student.getId(), student);
        return "User " + student.getFirstName() + " " + student.getLastName() + " Saved";
    }

    public Student getStudentFromStudentId(long userid) {
        System.out.println(StudentIdsToStudents);
        return StudentIdsToStudents.get(userid);
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>(StudentIdsToStudents.values());
        return students;
    }

    public void deleteStudentWithStudentId(int id) {
        StudentIdsToStudents.remove(id);
    }

    public Boolean updateStudentDepartment(DepartmentUpdateRequest request) {
        if (!StudentIdsToStudents.containsKey(request.getStudentId())) {
            return false;
        }
        Student student = StudentIdsToStudents.get(request.getStudentId());
        student.setDepartment(request.getDepartment());
        StudentIdsToStudents.put(request.getStudentId(), student);
        return true;
    }
}
