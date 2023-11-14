package Arya.example.dto;

public class Department {
    private String id;
    private static int nextId = 1;
    private String departmentName;

    public Department(String name) {
        this.id = "D%3d" + nextId;
        nextId++;
    }

}
