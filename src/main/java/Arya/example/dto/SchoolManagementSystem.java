package Arya.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
    }

    //department section

    /**
     * adds a department
     * @param dName name of the department
     */
    public void addDepartment(String dName) {
        dName = toUpper(dName);
        if (smsDepartments[MAX_DEPARTMENT_NUM - 1] != null) {
            System.out.printf("You've created the maximum allocated departments (%d)\n", MAX_DEPARTMENT_NUM);
        } else {
            for (int i = 0; i < MAX_DEPARTMENT_NUM; i++) {
                if (smsDepartments[i] == null) {
                    smsDepartments[i] = new Department(toUpper(dName));
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
        dId = toUpper(dId);
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
        cName = toUpper(cName);
        dId = toUpper(dId);
        if (cred >= 1.0 && cred <= 6.0) {
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
        } else {
            System.out.println("Enter a Valid Credit (Between 1.0 and 6.0)");
        }

    }

    /**
     * finds a course based on the course id
     * @param cId the course id
     * @return returns a course
     */
    public Course findCourse(String cId) {
        cId = toUpper(cId);
        for (int i = 0; i < MAX_COURSE_NUM; i++) {
            if (smsCourses[i].getId().equals(cId)) {
                return smsCourses[i];
            }
        }
        System.out.printf("The course with id %s does not exist or is out of bound\n", cId);
        return null;
    }

    /**
     * method that takes the scores of the students in a specific course and finds the average score
     * @param cId the course id (needed to find the students of the course and their individual scores)
     * @return the average score of the course
     */
    public double calcCourseAverage(String cId) {
        double result = 0;
        Student[] student;
        for (int i = 0; i < MAX_COURSE_REGISTER_NUM; i++) {
            student = findCourse(cId).getStudent();
            if (student[i] != null) {
                result += student[i].getScore();
            }
        }
        return (result / findCourse(cId).getStudentNum());
    }

    /**
     * method that modifies the teacher assigned to a course
     * @param cId the course id
     * @param tId the teacher id
     */
    public void modifyCourseTeacher(String cId, String tId) {
        cId = toUpper(cId);
        tId = toUpper(tId);
        if (findCourse(cId) != null && findTeacher(tId) != null) {
            findCourse(cId).setTeacher(findTeacher(tId));
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
        fName = toUpper(fName);
        lName = toUpper(lName);
        dId = toUpper(dId);
        if (smsTeachers[MAX_TEACHER_NUM - 1] != null) {
            System.out.printf("You've reached the maximum allocated teachers (%d). Teacher not added\n", MAX_TEACHER_NUM);
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
     * method that adds a gender to the teacher
     * @param gender input gender
     */
    public void addTeacherGender(String gender) {
        try {
            for (int i = 0; i < MAX_TEACHER_NUM; i++) {
                if (smsTeachers[i] != null && smsTeachers[i].getGender() == null) {
                    smsTeachers[i].setGender(Gender.valueOf(gender.toUpperCase()));
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Enter a valid gender (MALE, FEMALE, OTHER). Teacher not added");
        }
    }

    /**
     * method that finds a teacher based on their name and their id
     * @param tId the teacher id
     * @return returns a teacher
     */
    public Teacher findTeacher(String tId) {
        tId = toUpper(tId);
        for (int i = 0; i < MAX_TEACHER_NUM; i++) {
            if (smsTeachers[i] != null && smsTeachers[i].getId().equals(tId)) {
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
    public void addStudent(String fName, String lName, double score, String dId) {
        fName = toUpper(fName);
        lName = toUpper(lName);
        dId = toUpper(dId);
        if (smsStudents[MAX_STUDENT_NUM - 1] != null) {
            System.out.printf("You've reached the maximum allocated students (%d). Student not added\n", MAX_STUDENT_NUM);
        } else {
            for (int i = 0; i < MAX_STUDENT_NUM; i++) {
                if (smsStudents[i] == null) {
                    smsStudents[i] = new Student(fName, lName, score, findDepartment(dId));
                    break;
                }
            }
        }
    }

    /**
     * method that adds a gender to the student
     * @param gender input gender
     */
    public void addStudentGender(String gender) {
        try {
            for (int i = 0; i < MAX_STUDENT_NUM; i++) {
                if (smsStudents[i] != null && smsStudents[i].getGender() == null) {
                    smsStudents[i].setGender(Gender.valueOf(gender.toUpperCase()));
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Enter a valid gender (MALE, FEMALE, OTHER). Student not added");
        }
    }

    /**
     * finds the student based on the id (unless it doesn't exist)
     * @param sId the student id
     * @return returns a student
     */
    public Student findStudent(String sId) {
        sId = toUpper(sId);
        for (int i = 0; i < MAX_STUDENT_NUM; i++) {
            if (smsStudents[i] != null && smsStudents[i].getId().equals(sId)) {
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
        sId = toUpper(sId);
        cId = toUpper(cId);
        String sNames = "";
        if (findStudent(sId).getCourseNum() <= 5 && findCourse(cId).getStudentNum() <= 5) {
                Student[] s = findCourse(cId).getStudent();
                Course[] c = findStudent(sId).getCourses();

            for (byte i = findCourse(cId).getStudentNum(); i < 5 - findCourse(cId).getStudentNum(); i++) {
                if (s[i] == null) {
                    s[i] = findStudent(sId);
                    sNames += i == 0 ? s[i].getFName() + " " + s[i].getLName() : ", " + s[i].getFName() + " " + s[i].getLName();

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
            System.out.printf("Latest course info: Course{id=%s, courseName=%s, credit=%.1f, teacher=%s, department=%s, students=[%s], course average=%.1f}\n", cId, findCourse(cId).getCourseName(), findCourse(cId).getCredit(), (findCourse(cId).getTeacher().getFName() + " " + findCourse(cId).getTeacher().getLName()), findCourse(cId).getDepartment().getDepartmentName(), sNames, calcCourseAverage(cId));
        } else {
            if (findStudent(sId).getCourseNum() >= 5) {
                System.out.printf("The course with id %s has already been registered by 5 students\n", cId);
            } else {
                System.out.printf("The student with id %s has already registered for 5 courses\n", sId);
            }
        }
    }

    //extra stuff
    /**
     * method that returns the capitalized word(s)
     * @param strIn input
     * @return capitalized input string
     */
    public String toUpper(String strIn) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < strIn.length(); i++) {
            output.append(i == 0 ? strIn.toUpperCase().charAt(i) : strIn.charAt(i));
        }
        return output.toString();
    }

    /**
     * method that prints the sms object
     * @return returns the object in string format
     */
    @Override
    public String toString() {
        StringBuilder sNames = new StringBuilder();
        StringBuilder tNames = new StringBuilder();
        StringBuilder cNames = new StringBuilder();
        StringBuilder dNames = new StringBuilder();
        for (int i = 0; i < MAX_STUDENT_NUM; i++) {
            if (smsStudents[i] != null) {
                sNames.append(i == 0 ? smsStudents[i].getFName() + " " + smsStudents[i].getLName() : ", " + smsStudents[i].getFName() + " " + smsStudents[i].getLName());
            }
            if (i < MAX_TEACHER_NUM && smsTeachers[i] != null) {
                tNames.append(i == 0 ? smsTeachers[i].getFName() + " " + smsTeachers[i].getLName() : ", " + smsTeachers[i].getFName() + " " + smsTeachers[i].getLName());
            }
            if (i < MAX_DEPARTMENT_NUM && smsDepartments[i] != null) {
                dNames.append(i == 0 ? smsDepartments[i].getDepartmentName() : ", " + smsDepartments[i].getDepartmentName());
            }
            if (i < MAX_COURSE_NUM && smsCourses[i] != null) {
                cNames.append(i == 0 ? smsCourses[i].getCourseName() : ", " + smsCourses[i].getCourseName());
            }
        }
        return String.format("SchoolManagementSystem{name=%s, students=[%s], teachers=[%s], courses=[%s], departments=[%s]}", smsName, sNames, tNames.toString(), cNames.toString(), dNames.toString());
    }
}
