package com.project.system.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentClassKey implements Serializable {

    private Long studentId;
    private Long classId;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long courseId) {
        this.classId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClassKey that = (StudentClassKey) o;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, classId);
    }
}
