package Arya.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@EqualsAndHashCode
@Getter
@ToString

public class Student {
    private String fName;
    private String lName;
    private Department department;
//    private Gender gender;
    private String id;
    private static int nextId = 0;
    private int courseNum;
    private Course[] courses;


    public Student(String fName, String lName, Department department) {
        this.fName = fName;
        this.lName = lName;
        this.department = department;
        this.id = String.format("S%03d", ++nextId);
        this.courses = null;
        this.courseNum = 0;
    }
}
