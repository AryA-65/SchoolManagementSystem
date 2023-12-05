package Arya.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@EqualsAndHashCode
@Getter

/**
 * class that creates an object teacher and assigns it values given by the user
 */

public class Teacher {
    private String fName;
    private String lName;
    private Gender gender;
    private Department department;
    private String id;
    private static int nextId = 1;
    private byte experience;

    /**
     * constructor that assigns the object a teacher first name, last name, id and department they belong to
     * @param fName teacher first name
     * @param lName teacher last name
     * @param department which department the teacher belongs to
     */
    public Teacher(String fName, String lName, byte experience, Department department) {
        this.fName = fName;
        this.lName = lName;
        this.id = String.format("T%03d", nextId++);
        this.department = department;
        this.gender = null;
        this.experience = experience;
    }

    /**
     * method that prints the object
     * @return values of the object in string form
     */
    @Override
    public String toString() {
        return String.format("Teacher{id=%s, fName=%s, lName=%s, experience=%d, gender=%s, department=%s}", id, fName, lName, experience, gender, department.getDepartmentName());
    }
}
