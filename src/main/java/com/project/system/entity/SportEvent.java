package com.project.system.entity;

import com.project.system.enumeration.SportType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity(name = "ps_event")
public class SportEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    @NotBlank
    private String name;
    @NotBlank
    private String location;
    @Enumerated(value = EnumType.STRING)
    private SportType type;
    @OneToMany(mappedBy = "sportEvent")
    private Set<SportClass> sportEvents;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public SportType getType() {
        return type;
    }

    public void setType(SportType type) {
        this.type = type;
    }

    public Set<SportClass> getSportEvents() {
        return sportEvents;
    }

    public void setSportEvents(Set<SportClass> sportEvents) {
        this.sportEvents = sportEvents;
    }
}
