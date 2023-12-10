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
    private Double[] score;
    private double avgScore;
    private Department department;
    private Gender gender;
    private String id;
    private static int nextId = 1;
    private byte courseNum;
    private Course[] courses;

    /**
     * constructor that assigns the object a student first name, last name, id, courses, number of courses and the department they belong to
     * @param fName student first name
     * @param lName student last name
     * @param department which department the student belongs to
     */
    public Student(String fName, String lName, Department department) {
        this.id = String.format("S%03d", nextId++);
        this.fName = fName;
        this.lName = lName;
        this.gender = null;
        this.department = department;
        this.courses = new Course[MAX_COURSE_NUM];
        this.courseNum = 0;
        this.score = new Double[MAX_COURSE_NUM];
        this.avgScore = 0;
    }

    /**
     * method that prints the object
     * @return values of the object in string form
     */
    @Override
    public String toString() {
        StringBuilder names = new StringBuilder();
        StringBuilder scores = new StringBuilder();
        for (int i = 0; i < MAX_COURSE_NUM; i++) {
            if (courses[i] != null) {
                names.append(i == 0 ? courses[i].getCourseName() : ", " + courses[i].getCourseName());
            }
            if (score[i] != null) {
                scores.append(i == 0 ? score[i] : ", " + score[i]);
            }
        }
        return String.format("Student{id=%s, fname=%s, lname=%s, gender=%s, courseNum=%d, courses=[%s], scores=[%s], average=%.1f, department=%s}", id, fName, lName, gender, courseNum, names, scores, avgScore, department.getDepartmentName());
    }
}
