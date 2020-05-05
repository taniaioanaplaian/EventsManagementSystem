package com.project.system.entity;
import javax.persistence.*;

@Entity(name = "ps_student_class")
public class StudentClass {

    @EmbeddedId
    private StudentClassKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("classId")
    @JoinColumn(name = "class_id")
    private SportClass sportClass;

    private Boolean isPresent;
    private Double grade;

    public StudentClassKey getId() {
        return id;
    }

    public void setId(StudentClassKey id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SportClass getSportClass() {
        return sportClass;
    }

    public void setSportClass(SportClass sportClass) {
        this.sportClass = sportClass;
    }

    public Boolean getPresent() {
        return isPresent;
    }

    public void setPresent(Boolean present) {
        isPresent = present;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
