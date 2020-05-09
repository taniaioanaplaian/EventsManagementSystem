package com.project.system.mapper;

import com.project.system.dto.StudentDto;
import com.project.system.dto.UserDto;
import com.project.system.entity.Student;
import com.project.system.entity.User;
import com.project.system.repository.StudentDAO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@Mapper(uses = UserMapper.class)
public abstract class StudentMapper {

    @Autowired
    EntityManager entityManager;

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "studentId", source = "id")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "user", ignore  = true)
    public abstract void toEntityUpdate(@MappingTarget Student student, StudentDto studentDto);

    @Mapping(target = "firstName",source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "studentId", source = "id")
    @Mapping(target = "user", ignore = true)
    public abstract Student toEntity(StudentDto studentDto);

    @Mapping(target = "firstName",source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "id", source = "studentId")
    @Mapping(target = "userDto", source = "user")
    public abstract StudentDto toDto(Student student);

    @AfterMapping
    void toDtoAfterMapping(@MappingTarget Student student, StudentDto studentDto) {
        final User account = entityManager.find(User.class, studentDto.getUserDto().getId());
        student.setUser(account);
    }



}
