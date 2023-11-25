package Arya.example.dto;

public class SchoolManagementSystem {
    private String smsName;
    private static final byte MAX_DEPARTMENT_NUM = 5;
    private static final byte MAX_COURSE_NUM = 30;
    private static final byte MAX_TEACHER_NUM = 20;
    private static final byte MAX_COURSEREGISTER_NUM = 5;
    private static final int MAX_STUDENT_NUM = 200;

    public SchoolManagementSystem(String smsName) {
        this.smsName = smsName;
    }

    //department section
    public void addDepartment(String dName) {
    
    }

//    public Department findDepartment(String dId) {
//
//    }

    public void printDepartments() {

    }

    //course section
    public void addCourse(String cName, double cred, String tName) { //replace temp with something else

    }

//    public Course findCourse(String cName) {
//
//    }

    public void modifyCourseTeacher(String cName, String tName) {

    }

    public void registerCourse(String sId, String cId) {

    }

    //teacher section
    public void addTeacher(String tName) {

    }

//    public Teacher findTeacher(String tId) {
//
//    }

    public void printTeachers() {

    }

    //student section
    public void addStudent(String fName, String lName, String cName) { //replace temp with something else

    }

    public void printStudents() {

    }

//    public Student findStudent(String sId) {
//
//    }

}
