package com.project.system.service;

import com.project.system.dto.SportEventDto;
import com.project.system.entity.SportEvent;

public interface SportEventService {

    SportEventDto addSportEvent(SportEventDto sportEventDto);
    void deleteSportEvent(SportEventDto sportEventDto);

}
