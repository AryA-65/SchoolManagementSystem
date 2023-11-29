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
 * class that creates an object student and assigns it values given by the user
 */

public class Student {
    private static final byte MAX_COURSE_NUM = 5;
    private String fName;
    private String lName;
    private Department department;
//    private Gender gender; adding later
    private String id;
    private static int nextId = 0;
    private byte courseNum;
    private Course[] courses;

    /**
     * constructor that assigns the object a student first name, last name, id, courses, number of courses and the department they belong to
     * @param fName student first name
     * @param lName student last name
     * @param department which department the student belongs to
     */
    public Student(String fName, String lName, Department department) {
        this.id = String.format("S%03d", ++nextId);
        this.fName = fName;
        this.lName = lName;
        this.department = department;
        this.courses = new Course[MAX_COURSE_NUM];
        this.courseNum = 0;
    }
}
