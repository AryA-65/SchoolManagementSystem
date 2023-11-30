package Arya.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Setter
@EqualsAndHashCode
@Getter

/**
 * class that creates an object school management system and assigns it values given by the user
 * there are method that creates student, teachers, departments and courses, prints them and finds them
 * adds a teacher to a course and adds a student to a course.
 */

public class SchoolManagementSystem {
    private static final byte MAX_DEPARTMENT_NUM = 5;
    private static final byte MAX_COURSE_NUM = 30;
    private static final byte MAX_TEACHER_NUM = 20;
    private static final byte MAX_COURSE_REGISTER_NUM = 5;
    private static final int MAX_STUDENT_NUM = 200;

    private String smsName;
    private Department[] smsDepartments;
    private Student[] smsStudents;
    private Teacher[] smsTeachers;
    private Course[] smsCourses;
    private String sNames;

    /**
     * constructor that assigns a name to the object
     * @param smsName the school management system name
     */
    public SchoolManagementSystem(String smsName) {
        this.smsName = smsName;
        this.smsDepartments = new Department[MAX_DEPARTMENT_NUM];
        this.smsTeachers = new Teacher[MAX_TEACHER_NUM];
        this.smsCourses = new Course[MAX_COURSE_NUM];
        this.smsStudents = new Student[MAX_STUDENT_NUM];
        this.sNames = "";
    }

    //department section

    /**
     * adds a department
     * @param dName name of the department
     */
    public void addDepartment(String dName) {
        //test
        if (smsDepartments[MAX_DEPARTMENT_NUM - 1] != null) {
            System.out.printf("You've created the maximum allocated departments (%d)\n", MAX_DEPARTMENT_NUM);
        } else {
            for (int i = 0; i < MAX_DEPARTMENT_NUM; i++) {
                if (smsDepartments[i] == null) {
                    smsDepartments[i] = new Department(dName);
                    break;
                }
            }
        }
    }

    /**
     * finds department based on the department id
     * @param dId id of the department
     * @return returns the department
     */
    public Department findDepartment(String dId) {
        for (int i = 0; i < MAX_DEPARTMENT_NUM; i++) {
            if (smsDepartments[i].getId().equals(dId)) {
                return smsDepartments[i];
            }
        }
        System.out.printf("The department with id %s does not exist or is out of bound\n", dId);
        return null; //temporary return value
    }

    /**
     * method that prints all the departments (only the non-null ones)
     */
    public void printDepartments() {
        for (int i = 0; i < MAX_DEPARTMENT_NUM; i++) {
            if (smsDepartments[i] != null) {
                System.out.println(smsDepartments[i]);
            }
        }
    }

    //course section

    /**
     * adds a course and assigns a teacher to the course
     * @param cName the course name
     * @param cred the course credit
     * @param dId the teacher id
     */
    public void addCourse(String cName, double cred, String dId) {
        if (smsCourses[MAX_COURSE_NUM - 1] != null) {
            System.out.printf("You've reached the maximum allocated courses (%d)\n", MAX_COURSE_NUM);
        } else {
            for (int i = 0; i < MAX_COURSE_NUM; i++) {
                if (smsCourses[i] == null) {
                    smsCourses[i] = new Course(cName, cred, findDepartment(dId));
                    break;
                }
            }
        }
    }

    /**
     * finds a course based on the course id
     * @param cId the course id
     * @return returns a course
     */
    public Course findCourse(String cId) {
        for (int i = 0; i < MAX_COURSE_NUM; i++) {
            if (smsCourses[i].getId().equals(cId)) {
                return smsCourses[i];
            }
        }
        System.out.printf("The course with id %s does not exist or is out of bound\n", cId);
        return null;
    }

    /**
     * method that modifies the teacher assigned to a course
     * @param cId the course id
     * @param tId the teacher id
     */
    public void modifyCourseTeacher(String cId, String tId) {
        Course course = findCourse(cId);

        if (course != null && findTeacher(tId) != null) {
            course.setTeacher(findTeacher(tId));
        } else {
            System.out.printf("Cannot modify teacher for course with id %s\n", cId);
        }
    }

    /**
     * displays all courses, except the ones that are null
     */
    public void printCourses() {
        for (int i = 0; i < MAX_COURSE_NUM; i++) {
            if (smsCourses[i] != null) {
                System.out.println(smsCourses[i]);
            }
        }
    }

    //teacher section
    /**
     * add a teacher to the system and adds them to a department
     * @param fName teacher first name
     * @param lName teacher last name
     * @param dId department which they belong to
     */
    public void addTeacher(String fName, String lName, String dId) {
        if (smsTeachers[MAX_TEACHER_NUM - 1] != null) {
            System.out.printf("You've reached the maximum allocated teachers (%d)\n", MAX_TEACHER_NUM);
        } else {
            for (int i = 0; i < MAX_TEACHER_NUM; i++) {
                if (smsTeachers[i] == null) {
                    smsTeachers[i] = new Teacher(fName, lName, findDepartment(dId));
                    break;
                }
            }
        }
    }

    /**
     * method that finds a teacher based on their name and their id
     * @param tId the teacher id
     * @return returns a teacher
     */
    public Teacher findTeacher(String tId) {
        for (int i = 0; i < MAX_TEACHER_NUM; i++) {
            if (smsTeachers[i].getId().equals(tId)) {
                return smsTeachers[i];
            }
        }
        System.out.printf("The teacher with id %s does not exist or is out of bound\n", tId);
        return null;
    }

    /**
     * prints all teachers, except for the ones that are null
     */
    public void printTeachers() {
        for (int i = 0; i < MAX_TEACHER_NUM; i++) {
            if (smsTeachers[i] != null) {
                System.out.println(smsTeachers[i]);
            }
        }
    }

    //student section
    /**
     * adds a student to the system and add them to a department
     * @param fName the student first name
     * @param lName the student last name
     * @param dId the course id
     */
    public void addStudent(String fName, String lName, String dId) {
        if (smsStudents[MAX_STUDENT_NUM - 1] != null) {
            System.out.printf("You've reached the maximum allocated students (%d)\n", MAX_STUDENT_NUM);
        } else {
            for (int i = 0; i < MAX_STUDENT_NUM; i++) {
                if (smsStudents[i] == null) {
                    smsStudents[i] = new Student(fName, lName, findDepartment(dId));
                    break;
                }
            }
        }
    }

    /**
     * finds the student based on the id (unless it doesn't exist)
     * @param sId the student id
     * @return returns a student
     */
    public Student findStudent(String sId) {
        for (int i = 0; i < MAX_STUDENT_NUM; i++) {
            if (smsStudents[i].getId().equals(sId)) {
                return smsStudents[i];
            }
        }
        System.out.printf("The teacher with id %s does not exist or is out of bound\n", sId);
        return null;
    }

    /**
     * prints all students, except the ones that are null
     */
    public void printStudents() {
        for (int i = 0; i < MAX_STUDENT_NUM; i++) {
            if (smsStudents[i] != null) {
                System.out.println(smsStudents[i]);
            }
        }
    }

    /**
     * method that registers a student to a course using the student and course id (unless the id of both don't exist)
     * @param sId the student id
     * @param cId the course id
     */
    public void registerCourse(String sId, String cId) {
        if (findStudent(sId).getCourseNum() <= 5 && findCourse(cId).getStudentNum() <= 5) {
                Student[] s = findCourse(cId).getStudent();
                Course[] c = findStudent(sId).getCourses();

                for (byte i = findCourse(cId).getStudentNum(); i < 5 - findCourse(cId).getStudentNum(); i++) {
                    if (s[i] == null) {
                        s[i] = findStudent(sId);
                        sNames += s[i].getFName() + " " + s[i].getLName() + ", ";
                        findCourse(cId).setStudent(s);
                        findCourse(cId).setStudentNum((byte) (i + 1));
                        break;
                    }
                }
                for (byte i = findStudent(sId).getCourseNum(); i < 5 - findStudent(sId).getCourseNum(); i++) {
                    if (c[i] == null) {
                        c[i] = findCourse(cId);
                        findStudent(sId).setCourses(c);
                        findStudent(sId).setCourseNum((byte) (i + 1));
                        break;
                    }
                }

                System.out.printf("Latest student info: %s\n", findStudent(sId));
                System.out.printf("Latest course info: Course{id=%s, courseName=%s, credit=%.1f, teacher=%s, department=%s, students=[%s]}\n", cId, findCourse(cId).getCourseName(), findCourse(cId).getCredit(), (findCourse(cId).getTeacher().getFName() + " " + findCourse(cId).getTeacher().getLName()), findCourse(cId).getDepartment().getDepartmentName(), sNames);
        } else {
            if (findStudent(sId).getCourseNum() >= 5) {
                System.out.printf("The course with id %s has already been registered by 5 students\n", cId);
            } else {
                System.out.printf("The student with id %s has already registered for 5 courses\n", sId);
            }
        }
    }

    @Override
    public String toString() {
        String tNames = "";
        String cNames = "";
        String dNames = "";
        for (int i = 0; i < MAX_TEACHER_NUM; i++) {
            if (smsTeachers[i] != null) {
                tNames += smsTeachers[i].getFName() + " " + smsTeachers[i].getLName() + ", ";
            }
        }
        for (int i = 0; i < MAX_COURSE_NUM; i++) {
            if (smsCourses[i] != null) {
                cNames += smsCourses[i].getCourseName() + ", ";
            }
        }
        for (int i = 0; i < MAX_DEPARTMENT_NUM; i++) {
            if (smsDepartments[i] != null) {
                dNames += smsDepartments[i].getDepartmentName() + ", ";
            }
        }

        return String.format("SchoolManagementSystem{name=%s, students=[%s], teachers=[%s], courses=[%s], departments=[%s]}", smsName, sNames, tNames, cNames, dNames);
    }
}
