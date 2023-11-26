package Arya.example.dto;

/**
 * class that creates an object school management system and assigns it values given by the user
 * there are method that creates student, teachers, departments and courses, prints them and finds them
 * adds a teacher to a course and adds a student to a course.
 */

public class SchoolManagementSystem {
    private String smsName;
    private static final byte MAX_DEPARTMENT_NUM = 5;
    private static final byte MAX_COURSE_NUM = 30;
    private static final byte MAX_TEACHER_NUM = 20;
    private static final byte MAX_COURSE_REGISTER_NUM = 5;
    private static final int MAX_STUDENT_NUM = 200;

    /**
     *  constructor that assigns a name to the object
     * @param smsName the school management system name
     */
    public SchoolManagementSystem(String smsName) {
        this.smsName = smsName;
    }

    //department section

    /**
     * adds a department
     * @param dName name of the department
     */
    public void addDepartment(String dName) {
    
    }

    /**
     * finds department based on the department id
     * @param dId id of the department
     * @return returns the department
     */
    public Department findDepartment(String dId) {
        return null; //temporary return value
    }

    /**
     * method that prints all the departments (only the non-null ones)
     */
    public void printDepartments() {

    }

    //course section

    /**
     * adds a course and assigns a teacher to the course
     * @param cName the course name
     * @param cred the course credit
     * @param tId the teacher id
     */
    public void addCourse(String cName, double cred, String tId) {

    }

    /**
     * finds a course based on the course id
     * @param cId the course id
     * @return returns a course
     */
    public Course findCourse(String cId) {
        return null;
    }

    /**
     * method that modifies the teacher assigned to a course
     * @param cId the course id
     * @param tid the teacher id
     */
    public void modifyCourseTeacher(String cId, String tid) {

    }

    /**
     * displays all courses, except the ones that are null
     */
    public void printCourses() {

    }

    //teacher section
    /**
     * add a teacher to the system and adds them to a department
     * @param fName teacher first name
     * @param lName teacher last name
     * @param dId department which they belong to
     */
    public void addTeacher(String fName, String lName, String dId) {

    }

    /**
     * method that finds a teacher based on their name and their id
     * @param tId the teacher id
     * @return returns a teacher
     */
    public Teacher findTeacher(String tId) {
        return null; //temporary return value
    }

    /**
     * prints all teachers, except for the ones that are null
     */
    public void printTeachers() {

    }

    //student section
    /**
     * adds a student to the system and add them to a department
     * @param fName the student first name
     * @param lName the student last name
     * @param dId the course id
     */
    public void addStudent(String fName, String lName, String dId) {

    }

    /**
     * finds the student based on the id (unless it doesn't exist)
     * @param sId the student id
     * @return returns a student
     */
    public Student findStudent(String sId) {
        return null; //temporary return value
    }

    /**
     * prints all students, except the ones that are null
     */
    public void printStudents() {

    }

    /**
     * method that registers a student to a course using the student and course id (unless the id of both don't exist)
     * @param sId the student id
     * @param cId the course id
     */
    public void registerCourse(String sId, String cId) {

    }
}
