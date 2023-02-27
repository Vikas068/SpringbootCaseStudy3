package com.jdbl.Jbdl_CaseStudy3.service;

import com.jdbl.Jbdl_CaseStudy3.entity.Student;
import com.jdbl.Jbdl_CaseStudy3.requests.studentRequest;

public interface StudentServeInterf {

    Student saveStudent(studentRequest studentRequestt);
    Student saveFromStudent(Student student);
    Student findById(int StudentId);
}
