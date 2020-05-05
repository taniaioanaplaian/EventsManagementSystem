package com.project.system.mapper;

import com.project.system.dto.NameIdDTO;
import com.project.system.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface NameIdMapper {

    @Mapping(target = "name", source = "username")
    NameIdDTO userToNameIdDTO(User user);

}
