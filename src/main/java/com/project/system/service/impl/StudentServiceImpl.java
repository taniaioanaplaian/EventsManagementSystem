package com.project.system.service.impl;

import com.project.system.dto.StudentDto;
import com.project.system.entity.Student;
import com.project.system.mapper.StudentMapper;
import com.project.system.repository.StudentDAO;
import com.project.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO, StudentMapper studentMapper) {
        this.studentDAO = studentDAO;
        this.studentMapper = studentMapper;
    }


    @Override
    public StudentDto save(StudentDto studentReceived) {
        Student student;
        if(studentReceived.getId() != null) {
            student = studentDAO.findById(studentReceived.getId()).orElse(null);
        } else {
            student = new Student();
        }
        studentMapper.toEntityUpdate(student, studentReceived);
        assert student != null;
        return studentMapper.toDto(studentDAO.save(student));
    }
}
