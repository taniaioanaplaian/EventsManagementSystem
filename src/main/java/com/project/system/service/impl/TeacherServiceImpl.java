package com.project.system.service.impl;

import com.project.system.dto.TeacherDto;
import com.project.system.entity.Student;
import com.project.system.entity.Teacher;
import com.project.system.mapper.TeacherMapper;
import com.project.system.repository.TeacherDAO;
import com.project.system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherDAO teacherDAO;
    private final TeacherMapper teacherMapper;

    @Autowired
    public TeacherServiceImpl(TeacherDAO teacherDAO, TeacherMapper teacherMapper) {
        this.teacherDAO = teacherDAO;
        this.teacherMapper = teacherMapper;
    }


    @Override
    public TeacherDto save(TeacherDto teacherReceived) {
        Teacher teacher;
        if(teacherReceived.getId() != null) {
            teacher = teacherDAO.findById(teacherReceived.getId()).orElse(null);
        } else {
            teacher = new Teacher();
        }
        teacherMapper.toEntityUpdate(teacher, teacherReceived);
        assert teacher != null;
        return teacherMapper.toDto(teacherDAO.save(teacher));
    }
}
