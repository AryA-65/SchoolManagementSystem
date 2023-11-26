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
 * class that creates an object department and assigns it values given by the user
 */

public class Department {
    private String id;
    private static int nextId = 1;
    private String departmentName;

    /**
     * constructor that assigns a department id and name to the object to the object
     * @param departmentName the department name (input)
     */
    public Department(String departmentName) {
        this.id = String.format("D%03d", nextId);
        nextId++;
        this.departmentName = departmentName;
    }
}
