package com.project.system.controller;

import com.project.system.dto.SportEventDto;
import com.project.system.service.SportEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class SportEventController {
    private final SportEventService sportEventService;

    @Autowired
    public SportEventController(SportEventService sportEventService) {
        this.sportEventService = sportEventService;
    }

    @PostMapping("/add")
    public SportEventDto addEvent(SportEventDto sportEventDto){
            return sportEventService.addSportEvent(sportEventDto);
    }


}
