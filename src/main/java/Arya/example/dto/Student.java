package Arya.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;

@Setter
@EqualsAndHashCode
@Getter

/**
 * class that creates an object student and assigns it values given by the user
 */

public class Student {
    private static final byte MAX_COURSE_NUM = 5;
    private String fName;
    private String lName;
    private double score;
    private Department department;
    private Gender gender; //adding later
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
    public Student(String fName, String lName, double score, Department department) {
        this.id = String.format("S%03d", ++nextId);
        this.fName = fName;
        this.lName = lName;
        this.gender = null;
        this.department = department;
        this.courses = new Course[MAX_COURSE_NUM];
        this.courseNum = 0;
        this.score = score;
    }

    /**
     *
     * @return values of the object in string form
     */
    @Override
    public String toString() {
        String cNames = "";
        for (int i = 0; i < MAX_COURSE_NUM; i++) {
            if (courses[i] != null) {
                if (i == 0) {
                    cNames = courses[i].getCourseName();
                } else
                    cNames = ", " + courses[i].getCourseName();
            }
        }
        return String.format("Student{id=%s, fname=%s, lname=%s, gender=%s, department=%s, courseNum=%d, courses=[%s]}", id, fName, lName, gender, department.getDepartmentName(), courseNum, cNames);
    }
}
