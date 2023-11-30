package Arya.example;

import Arya.example.dto.SchoolManagementSystem;

//import java.util.Scanner;

/**
 * @author Arya Khosravi 2361373
 * program that creates a school management system, teachers, students, courses and departments and assigns them to one
 * another (look in SchoolManagementSystem class for the methods and what is assigned to each other)
 */

public class Main {
    public static void main(String[] args) {

//        Scanner input = new Scanner(System.in);

//        do {
//
//        } while (true);

        SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem("Vanier");

        /* test section */

        //adding and finding departments, and printing
        schoolManagementSystem.addDepartment("math");
        schoolManagementSystem.addDepartment("science");
        schoolManagementSystem.addDepartment("social");
        schoolManagementSystem.addDepartment("mechanics");
        schoolManagementSystem.addDepartment("arts");
        schoolManagementSystem.addDepartment("health");
        System.out.println(schoolManagementSystem.findDepartment("D001"));
        schoolManagementSystem.printDepartments();

        //adding and printing teacher
        schoolManagementSystem.addTeacher("yi", "wang", "D002");
        schoolManagementSystem.printTeachers();

        //adding and printing student
        schoolManagementSystem.addStudent("arya", "khosravi", "D002");
        schoolManagementSystem.printStudents();
        schoolManagementSystem.addStudent("joshua", "eid", "D002");
        schoolManagementSystem.printStudents();

        //adding and printing a course
        schoolManagementSystem.addCourse("CSM", 3.0, "D002");
        schoolManagementSystem.printCourses();

        //modifying and printing a course
        schoolManagementSystem.modifyCourseTeacher("C001", "T001");
        schoolManagementSystem.printCourses();

        //register course
        schoolManagementSystem.registerCourse("S001", "C001");
        schoolManagementSystem.registerCourse("S002", "C001");

        System.out.println(schoolManagementSystem);
    }
}
