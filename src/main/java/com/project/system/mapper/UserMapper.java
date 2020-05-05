package com.project.system.mapper;
import com.project.system.dto.NameIdDTO;
import com.project.system.dto.UserDTO;
import com.project.system.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@Mapper(uses = NameIdMapper.class)
public abstract class UserMapper {

    @Autowired
    private EntityManager entityManager;

    @Mapping(target = "username", source = "name")
    public abstract User toEntity(UserDTO userDTO);

    @Mapping(target = "username", source = "name")
    public abstract void toEntityUpdate(@MappingTarget User user, UserDTO userDTO);

    @Mapping(target = "name", source = "username")
    public abstract UserDTO toDTO(User user);

    public User toEntity(NameIdDTO nameIdDTO) {
        return entityManager.find(User.class, nameIdDTO.getId());
    }
}
