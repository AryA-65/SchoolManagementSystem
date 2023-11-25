package Arya.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@EqualsAndHashCode
@Getter
@ToString

public class Teacher {
    private String fName;
    private String lName;
    private Department department;
    private String id;
    private static int nextId = 0;

    public Teacher(String fName, String lName, Department department) {
        this.fName = fName;
        this.lName = lName;
        ++nextId;
        this.id = String.format("T%03d", nextId);
        this.department = null;
    }

}
