package com.project.system.entity;

import javax.persistence.*;
import java.util.Set;

@Entity( name = "ps_university")
public class University {

    @Id
    @GeneratedValue
    private Long universityId;
    private String name;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "university")
    private Set<Teacher> teachers;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "university")
    private Set<Teacher> students;

    public Long getUniversityId() {
        return universityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }


}

