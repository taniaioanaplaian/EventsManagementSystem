package com.project.system.service.impl;

import com.project.system.dto.SportEventDto;
import com.project.system.entity.SportEvent;
import com.project.system.entity.Student;
import com.project.system.mapper.SportEventMapper;
import com.project.system.repository.SportEventDAO;
import com.project.system.service.SportEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportEventServiceImpl implements SportEventService {

    private final SportEventDAO sportEventDAO;
    private final SportEventMapper sportEventMapper;

    @Autowired
    public SportEventServiceImpl(SportEventDAO sportEventDAO, SportEventMapper sportEventMapper) {
        this.sportEventDAO = sportEventDAO;
        this.sportEventMapper = sportEventMapper;
    }

    @Override
    public SportEventDto addSportEvent(SportEventDto sportEventDto) {
        SportEvent sportEvent;
        if(sportEventDto.getId() != null) {
            sportEvent = sportEventDAO.findById(sportEventDto.getId()).orElse(null);
        } else {
            sportEvent = new SportEvent();
        }
        sportEventMapper.toEntityUpdate(sportEvent, sportEventDto);
        assert sportEvent != null;
        return sportEventMapper.toDto(sportEventDAO.save(sportEvent));
    }

    @Override
    public void deleteSportEvent(SportEventDto sportEventDto) {
        SportEvent sportEvent;
        if(sportEventDto.getId() == null){
            return ;
        }
        sportEvent = sportEventMapper.toEntity(sportEventDto);
        sportEventDAO.delete(sportEvent);
    }
}
