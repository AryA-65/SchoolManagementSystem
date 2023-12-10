package Arya.example;

import Arya.example.dto.SchoolManagementSystem;

import java.util.Scanner;

/**
 * @author Arya Khosravi 2361373
 * program that creates a school management system, teachers, students, courses and departments and assigns them to one
 * another (look in SchoolManagementSystem class for the methods and what is assigned to what)
 */

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String id;
        String temp;

        System.out.println("Welcome to the School Management System Program");
        System.out.println("Firstly, Add School Management System Name (ex 'Vanier')");
        SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem(input.nextLine());
        System.out.println(" ");
        System.out.println("Lets starts with some basics:");
        System.out.println("You can have a maximum of 5 departments");
        System.out.println("You can have a maximum of 200 students");
        System.out.println("You can have a maximum of 30 courses");
        System.out.println("You can have a maximum of 20 students");
        System.out.println("You can have a maximum of 5 students registered per course and a maximum of 5 courses registered per student");
        System.out.println("To select an option, either enter the number or the letter of the first word (exception: specific prompts like 'Enter Name')\n");

        /* Testing modify course teacher and registering student */
//        SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem("vanier");
//        schoolManagementSystem.addDepartment("arts");
//        schoolManagementSystem.addDepartment("math");
//        schoolManagementSystem.addDepartment("science");
//        schoolManagementSystem.addDepartment("health");
//        schoolManagementSystem.addDepartment("philosophy");
//        schoolManagementSystem.addStudent("arya", "khosravi", "d001");
//        schoolManagementSystem.addStudentGender("male");
//        schoolManagementSystem.addStudent("joshua", "eid",  "d001");
//        schoolManagementSystem.addStudentGender("male");
//        schoolManagementSystem.addTeacher("yi", "wang", (byte) 10, "d001");
//        schoolManagementSystem.addTeacherGender("male");
//        schoolManagementSystem.addTeacher("Mark", "wayne", (byte) 15, "d004");
//        schoolManagementSystem.addTeacherGender("male");
//        schoolManagementSystem.addCourse("photography", 3.0, "d001");
//        schoolManagementSystem.addCourse("biology", 3.0, "d004");
//        schoolManagementSystem.modifyCourseTeacher("c001", "t001");
//        schoolManagementSystem.modifyCourseTeacher("c002", "t002");
//        schoolManagementSystem.registerCourse("s001","c001", 90);
//        schoolManagementSystem.registerCourse("s001","c002", 80);
//        schoolManagementSystem.registerCourse("s002","c001", 70);
//        System.out.println(schoolManagementSystem.findCourse("c001"));
//        System.out.println(" ");
//        schoolManagementSystem.removeItems("s001","c001");

        do {
            System.out.println("Select an Option\n1. Creating Objects and Others\n2. Find Objects\n3. Print Objects\n4. Remove Objects and Registration\n5. Exit"); //add deleting
            temp = input.nextLine();

            if (temp.equalsIgnoreCase("5") || temp.equalsIgnoreCase("e")) {
                System.out.println("Exiting");
                break;
            }

            if (temp.length() > 1) {
                continue;
            }

            switch (temp) {
                case "1", "c" -> {
                    System.out.println("Select an Option\n1. Create a Objects\n2. Modifying Object\n3. Exit");
                    int iterations;
                    temp = input.nextLine();

                    if (temp.equals("1") || temp.equals("c")) {
                        System.out.println("Select an Option\n1. Create a Department\n2. Create a Student\n3. Create a Teacher\n4. Create a Course\n5. Exit");
                        temp = input.nextLine();

                        if (temp.equalsIgnoreCase("5") || temp.equalsIgnoreCase("e")) {
                            break;
                        }

                        if (temp.length() > 1) {
                            continue;
                        }

                        switch (temp) {
                            case "1", "d" -> {
                                System.out.println("How many departments do you want to create?");
                                iterations = input.nextInt();
                                if (iterations == 0) {
                                    System.out.println("Cannot enter 0");
                                    break;
                                }
                                for (int i = 0; i < iterations; i++) {
                                    System.out.println("Add Department Name");
                                    schoolManagementSystem.addDepartment(input.nextLine());
                                }
                            }
                            case "2", "s" -> {
                                System.out.println("How many departments do you want to create?");
                                iterations = input.nextInt();
                                if (iterations == 0) {
                                    System.out.println("Cannot enter 0");
                                    break;
                                }
                                for (int i = 0; i < iterations; i++) {
                                    try {
                                        System.out.println("Add First Name");
                                        String fName = input.nextLine();
                                        System.out.println("Add Last Name");
                                        String lName = input.nextLine();
                                        System.out.println("Department Id (ex 'D036')");
                                        id = input.nextLine();
                                        schoolManagementSystem.addStudent(fName, lName, id);
                                        System.out.println("Add Gender (MALE, FEMALE, OTHERS)");
                                        schoolManagementSystem.addStudentGender(input.nextLine());
                                    } catch (Exception e) {
                                        System.out.println("This Department Doesn't Exist");
                                    }
                                }
                            }
                            case "3", "t" -> {
                                System.out.println("How many departments do you want to create?");
                                iterations = input.nextInt();
                                if (iterations == 0) {
                                    System.out.println("Cannot enter 0");
                                    break;
                                }
                                for (int i = 0; i < iterations; i++) {
                                    try {
                                        System.out.println("Add First Name");
                                        String fName = input.nextLine();
                                        System.out.println("Add Last Name");
                                        String lName = input.nextLine();
                                        System.out.println("Enter Teacher Experience");
                                        byte years = input.nextByte();
                                        input.nextLine();
                                        System.out.println("Add to Department (ex 'D023')");
                                        id = input.nextLine();
                                        schoolManagementSystem.addTeacher(fName, lName, years, id);
                                        System.out.println("Add Gender (MALE, FEMALE, OTHERS)");
                                        schoolManagementSystem.addTeacherGender(input.nextLine());
                                    } catch (Exception e) {
                                        System.out.println("This Department Doesn't Exist");
                                    }
                                }
                            }
                            case "4", "c" -> {
                                System.out.println("How many departments do you want to create?");
                                iterations = input.nextInt();
                                if (iterations == 0) {
                                    System.out.println("Cannot enter 0");
                                    break;
                                }
                                for (int i = 0; i < iterations; i++) {
                                    try {
                                        System.out.println("Add Course Name");
                                        String cName = input.nextLine();
                                        System.out.println("Add Credit");
                                        double cred = input.nextDouble();
                                        input.nextLine();
                                        System.out.println("Department Id (ex 'D006')");
                                        id = input.nextLine();
                                        schoolManagementSystem.addCourse(cName, cred, id);
                                    } catch (Exception e) {
                                        System.out.println("This Department Doesn't Exist");
                                    }
                                }
                            }
                            default -> {
                            }
                        }
                    } else if (temp.equals("2") || temp.equals("m")) {
                        System.out.println("Select an Option\n1. Modify Course Teacher\n2. Register Student Course\n3. Exit");
                        temp = input.nextLine();

                        if (temp.equalsIgnoreCase("3") || temp.equalsIgnoreCase("e")) {
                            break;
                        }

                        switch (temp) {
                            case "1", "m" -> {
                                System.out.println("How many teachers do you want to register?");
                                iterations = input.nextInt();
                                if (iterations == 0) {
                                    System.out.println("Cannot enter 0");
                                    break;
                                }
                                for (int i = 0; i < iterations; i++) {
                                    System.out.println("Enter Course Id (ex 'C092')");
                                    String cId = input.nextLine();
                                    System.out.println("Enter Teacher Id (ex 'T047')");
                                    id = input.nextLine();
                                    schoolManagementSystem.modifyCourseTeacher(cId, id);
                                }
                            }
                            case "2", "r" -> {
                                System.out.println("How many students do you want to register?");
                                iterations = input.nextInt();
                                if (iterations == 0) {
                                    System.out.println("Cannot enter 0");
                                    break;
                                }
                                for (int i = 0; i < iterations; i++) {
                                    System.out.println("Enter Course Id (ex 'C010')");
                                    String cId = input.nextLine();
                                    System.out.println("Enter Student Id (ex 'S011')");
                                    id = input.nextLine();
                                    System.out.println("Add Score");
                                    double score = input.nextDouble();
                                    input.nextLine();
                                    schoolManagementSystem.registerCourse(id, cId, score);
                                }
                            }
                            default -> {
                            }
                        }
                    }
                }
                case "2", "f" -> {
                    System.out.println("Select an Option\n1. Find a Department\n2. Find a Student\n3. Find a Teacher\n4. Find a Course\n5. Exit");
                    temp = input.nextLine();

                    if (temp.equalsIgnoreCase("5") || temp.equalsIgnoreCase("e")) {
                        break;
                    }

                    if (temp.length() > 1) {
                        continue;
                    }

                    switch (temp) {
                        case "1", "d" -> {
                            System.out.println("Enter Department Id (ex 'D064')");
                            System.out.println(schoolManagementSystem.findDepartment(input.nextLine()));
                        }
                        case "2", "s" -> {
                            System.out.println("Find a Student (ex 'S025')");
                            System.out.println(schoolManagementSystem.findStudent(input.nextLine()));
                        }
                        case "3", "t" -> {
                            System.out.println("Find a Teacher (ex 'T074')");
                            System.out.println(schoolManagementSystem.findTeacher(input.nextLine()));
                        }
                        case "4", "c" -> {
                            System.out.println("Find a Course (ex 'C017')");
                            System.out.println(schoolManagementSystem.findCourse(input.nextLine()));
                        }
                        default -> {
                        }
                    }
                }
                case "3", "p" -> {
                    System.out.println("Select an Option\n1. Print a Department\n2. Print a Student\n3. Print a Teacher\n4. Print a Course\n5. Print School Management System\n6. Exit");
                    temp = input.nextLine();

                    if (temp.equalsIgnoreCase("6") || temp.equalsIgnoreCase("e")) {
                        break;
                    }

                    if (temp.length() > 1) {
                        continue;
                    }

                    switch (temp) {
                        case "1", "d" -> schoolManagementSystem.printDepartments();
                        case "2", "s" -> schoolManagementSystem.printStudents();
                        case "3", "t" -> schoolManagementSystem.printTeachers();
                        case "4", "c" -> schoolManagementSystem.printCourses();
                        case "5", "m" -> System.out.println(schoolManagementSystem);
                        default -> {
                        }
                    }
                }
                case "4" -> {
                    System.out.println("Enter an Object You Want to Remove or Unregister\n1.Everything\n2.Department\n3.Student\n4.Courses\n5.Teachers\n6.Registered Teacher\n7.Registered Student\n8.Exit");
                    temp = input.nextLine();

                    if (temp.equalsIgnoreCase("8") || temp.equalsIgnoreCase("e")) {
                        break;
                    }

                    if (temp.length() > 1) {
                        continue;
                    }

                    if (temp.equals("7")) {
                        System.out.println("Enter Course Id");
                        String cId = input.nextLine();
                        System.out.println("Enter Student Id");
                        String sId = input.nextLine();
                        schoolManagementSystem.removeItems(sId,cId);
                    } else {
                        System.out.println("Enter How Many You Want to Remove");
                        int count = input.nextInt();
                        System.out.println("Enter the Id of the Object You Want to Remove");
                        String startingId = input.nextLine();
                        schoolManagementSystem.removeItems(temp, count, startingId);
                    }
                }
                default -> {
                }
            }
        } while (true);

        /* simple version (test section/extra methods not included in this version)*/
//        //creating SchoolManagementSystem
//        SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem("Vanier");
//
//        //adding and finding departments, and printing
//        schoolManagementSystem.addDepartment("math");
//        schoolManagementSystem.addDepartment("science");
//        schoolManagementSystem.addDepartment("social");
//        schoolManagementSystem.addDepartment("mechanics");
//        schoolManagementSystem.addDepartment("arts");
//        schoolManagementSystem.addDepartment("health");
//        System.out.println(schoolManagementSystem.findDepartment("D001"));
//        schoolManagementSystem.printDepartments();
//
//        //adding and printing teacher
//        schoolManagementSystem.addTeacher("yi", "wang", "D002");
//        schoolManagementSystem.addTeacherGender("MALE");
//        schoolManagementSystem.printTeachers();
//
//        //adding and printing student
//        schoolManagementSystem.addStudent("arya", "khosravi","D002");
//        schoolManagementSystem.addStudentGender("asjhfvsbjf");
//        schoolManagementSystem.addStudentGender("male");
//        schoolManagementSystem.addStudent("joshua", "eid","D002");
//        schoolManagementSystem.addStudentGender("male");
//        schoolManagementSystem.printStudents();
//
//        //adding and printing a course
//        schoolManagementSystem.addCourse("CSM", 3.0, "D002");
//        schoolManagementSystem.printCourses();
//
//        //modifying and printing a course
//        schoolManagementSystem.modifyCourseTeacher("C001", "T001");
//        schoolManagementSystem.printCourses();
//
//        //register course
//        schoolManagementSystem.registerCourse("S001", "C001");
//        schoolManagementSystem.registerCourse("S002", "C001");
//
//        System.out.println(schoolManagementSystem);
    }
}
