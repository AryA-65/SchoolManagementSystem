package Arya.example.dto;

//import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@ToString
@Setter
@AllArgsConstructor
@Getter

public class Department {
    private String id;
    private static int nextId = 1;
    private String departmentName;

    public Department(String name) {
        this.id = String.format("D%03d", nextId);
        nextId++;
        this.departmentName = name;
    }

    @Override
    public String toString() {
        return String.format("id=%s, departmentName=%s", id, departmentName);
    }
}
