package com.project.system.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity(name = "ps_teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String profession;
    @OneToOne(fetch = FetchType.LAZY, optional = false,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "user_id",unique= true, nullable=true, insertable=true, updatable=true)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;
    @OneToMany(mappedBy = "teacher")
    private Set<SportClass> sportClasses;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public Set<SportClass> getSportClasses() {
        return sportClasses;
    }

    public void setSportClasses(Set<SportClass> sportClasses) {
        this.sportClasses = sportClasses;
    }
}
