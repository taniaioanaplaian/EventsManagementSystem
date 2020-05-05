package com.project.system.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "ps_student")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY, optional = false,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "user_id",unique= true, nullable=true, insertable=true, updatable=true)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    @OneToMany(mappedBy = "student")
    @MapKey(name = "id")
    private List<StudentClass> studentClasses;

    public List<StudentClass> getStudentClass() {
        return studentClasses;
    }

    public void setStudentClass(List<StudentClass> sportClasses) {
        this.studentClasses = sportClasses;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
