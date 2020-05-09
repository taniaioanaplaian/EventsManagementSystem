package com.project.system.controller;

import com.project.system.dto.TeacherDto;
import com.project.system.entity.Teacher;
import com.project.system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/save")
    public TeacherDto saveTeacher(@RequestBody TeacherDto teacher){
        return this.teacherService.save(teacher);
    }

}
