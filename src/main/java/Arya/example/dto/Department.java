package Arya.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@EqualsAndHashCode
@Getter
@ToString

public class Department {
    private String id;
    private static int nextId = 1;
    private String departmentName;

    public Department(String departmentName) {
        this.id = String.format("D%03d", nextId);
        nextId++;
        this.departmentName = departmentName;
    }
}
