package com.project.system.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "ps_class")
public class SportClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private SportEvent sportEvent;

    private LocalDateTime classDate ;
    private Integer capacity;

    @OneToMany(mappedBy = "sportClass")
    @MapKey(name = "id")
    private Set<StudentClass> sportClasses;




    public Set<StudentClass> getStudentClass() {
        return sportClasses;
    }

    public void setStudentClass(Set<StudentClass> sportClasses) {
        this.sportClasses = sportClasses;
    }


    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long class_id) {
        this.classId = class_id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public SportEvent getSportEvent() {
        return sportEvent;
    }

    public void setSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }

    public LocalDateTime getClassDate() {
        return classDate;
    }

    public void setClassDate(LocalDateTime classDate) {
        this.classDate = classDate;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


}