package Arya.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@EqualsAndHashCode
@Getter
@ToString

public class Course {
    private String id;
    private static int nextId = 0;
    private Department department;
    private double credit;
    private byte studentNum;
    private Teacher teacher;
    private Student student;
    private String courseName;

    public Course(String courseName, double credit, Department department) {
        this.courseName = courseName;
        this.credit = credit;
        this.department = department;
        this.teacher = null;
        this.studentNum = 0;
        this.student = null;
        this.id = String.format("C%03d", ++nextId);
    }
}
