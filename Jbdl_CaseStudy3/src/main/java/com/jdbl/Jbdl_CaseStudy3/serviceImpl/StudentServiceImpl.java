package com.jdbl.Jbdl_CaseStudy3.serviceImpl;

import com.jdbl.Jbdl_CaseStudy3.entity.Student;
import com.jdbl.Jbdl_CaseStudy3.repository.studentRepository;
import com.jdbl.Jbdl_CaseStudy3.requests.studentRequest;
import com.jdbl.Jbdl_CaseStudy3.service.StudentServeInterf;
import org.springframework.beans.factory.annotation.Autowired;


public class StudentServiceImpl implements StudentServeInterf {

    @Autowired
    com.jdbl.Jbdl_CaseStudy3.repository.studentRepository studentRepository;

    @Override
    public Student saveStudent(studentRequest studentRequestt) {
        return saveFromStudent(studentRequestt.studentStatus());
    }

    public Student saveFromStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(int studentId) {
        return studentRepository.findById(studentId).get();
    }
}
