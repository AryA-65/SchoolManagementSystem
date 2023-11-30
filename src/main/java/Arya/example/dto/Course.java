package Arya.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;

@Setter
@EqualsAndHashCode
@Getter

/**
 * class that creates an object course and assigns it values given by the user
 */

public class Course {
    private static final byte MAX_STUDENT_NUM = 5;
    private String id;
    private static int nextId = 0;
    private Department department;
    private double credit;
    private byte studentNum;
    private Teacher teacher;
    private Student[] student;
    private String courseName;
//    private Gender gender;

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
        this.student = new Student[MAX_STUDENT_NUM];
        this.id = String.format("C%03d", ++nextId);
//        this.gender = null;
    }



    @Override
    public String toString() {
        String names = "";
        for (int i = 0; i < MAX_STUDENT_NUM; i++) {
            if (student[i] != null) {
                names = student[i].getFName() + " " + student[i].getLName() + ", ";
            }
        }

        return String.format("Course{id=%s, courseName=%s, credit=%.1f, teacher=%s, department=%s, studentNums=%d, students=[%s]}", id, courseName, credit, teacher, department.getDepartmentName(), studentNum, names);
    }
}
