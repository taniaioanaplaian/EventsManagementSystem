package com.project.system.mapper;

import com.project.system.dto.StudentDto;
import com.project.system.dto.TeacherDto;
import com.project.system.entity.Student;
import com.project.system.entity.Teacher;
import com.project.system.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;


@Mapper(uses = UserMapper.class)
public abstract class TeacherMapper {

    @Autowired
    EntityManager entityManager;

    @Mapping(target = "user", source = "userDto")
    @Mapping(target = "teacherId", source = "id")
    public abstract Teacher toEntity(TeacherDto teacherDto);

    @Mapping(target = "userDto", source = "user")
    @Mapping(target = "id", source = "teacherId")
    public abstract TeacherDto toDto(Teacher teacher);

    @Mapping(target = "user", ignore  = true)
    @Mapping(target = "teacherId", source = "id")
    public abstract void toEntityUpdate(@MappingTarget Teacher teacher, TeacherDto teacherDto);


    @AfterMapping
    void toDtoAfterMapping(@MappingTarget Teacher teacher, TeacherDto teacherDto) {
        final User account = entityManager.find(User.class, teacherDto.getUserDto().getId());
        teacher.setUser(account);
    }

}
