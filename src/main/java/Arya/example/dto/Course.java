package Arya.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@EqualsAndHashCode
@Getter
@ToString

/**
 * class that creates an object course and assigns it values given by the user
 */

public class Course {
    private static final byte MAX_STUDENTS = 5;
    private String id;
    private static int nextId = 0;
    private Department department;
    private double credit;
    private byte studentNum;
    private Teacher teacher;
    private Student[] student;
    private String courseName;

    /**
     * method that assigns the object a course name, credit, id, teacher, student, number of students and the department it belongs to
     * @param courseName the course name
     * @param credit course credit
     * @param department which department it belongs in
     */
    public Course(String courseName, double credit, Department department) {
        this.courseName = courseName;
        this.credit = credit;
        this.department = department;
        this.teacher = null;
        this.studentNum = 0;
        this.student = new Student[MAX_STUDENTS];
        this.id = String.format("C%03d", ++nextId);
    }
}
