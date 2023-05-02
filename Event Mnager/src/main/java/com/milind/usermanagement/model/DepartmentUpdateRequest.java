package com.milind.usermanagement.model;

public class DepartmentUpdateRequest {
    private long studentId;
    private String department;

    public long getStudentId() {
        return studentId;
    }
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
