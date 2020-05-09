package com.project.system.mapper;

import com.project.system.dto.UserDto;
import com.project.system.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class UserMapper {

    @Mapping(target = "username" , source ="username")
    @Mapping(target = "id" , source ="userId")
    @Mapping(target = "role" , source ="role")
    @Mapping(target = "password" , source ="password")
    public abstract UserDto toDTO(User user);

    @Mapping(target = "username" , source ="username")
    @Mapping(target = "userId" , source ="id")
    @Mapping(target = "role" , source ="role")
    @Mapping(target = "password" , source ="password")
    public abstract User toEntity(UserDto userDto);

    @Mapping(target = "username", source = "username")
    public abstract void toEntityUpdate(@MappingTarget User user, UserDto userDTO);


}
