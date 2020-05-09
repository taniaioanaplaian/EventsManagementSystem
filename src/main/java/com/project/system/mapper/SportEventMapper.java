package com.project.system.mapper;

import com.project.system.dto.SportEventDto;
import com.project.system.entity.SportEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class SportEventMapper {

    @Mapping(target = "id", source = "eventId")
    public abstract SportEventDto toDto(SportEvent sportEvent);

    @Mapping(target = "eventId", source = "id")
    public abstract SportEvent toEntity(SportEventDto sportEventDto);

    @Mapping(target = "eventId", source = "id")
    public abstract void toEntityUpdate(@MappingTarget SportEvent sportEvent, SportEventDto sportEventDto);

}
