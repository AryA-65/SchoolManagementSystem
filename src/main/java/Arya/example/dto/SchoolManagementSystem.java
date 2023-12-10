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
        for (Department department : smsDepartments) {
            if (department != null && department.getId().equals(dId)) {
                return department;
            }
        }
        System.out.printf("The department with id %s does not exist or is out of bound\n", dId);
        return null; //temporary return value
    }

    /**
     * method that prints all the departments (only the non-null ones)
     */
    public void printDepartments() {
        for (Department department : smsDepartments) {
            if (department != null) {
                System.out.println(department);
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
        if (cred >= 1.0 && cred <= 3.0) {
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
        for (Course course : smsCourses) {
            if (course != null && course.getId().equals(cId)) {
                return course;
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
        cId = toUpper(cId);
        tId = toUpper(tId);
        if (findCourse(cId) != null && findTeacher(tId) != null) {
            findCourse(cId).setTeacher(findTeacher(tId));
        } else {
            System.out.printf("Cannot modify teacher with id %s for course with id %s\n", tId, cId);
        }
    }

    /**
     * displays all courses, except the ones that are null
     */
    public void printCourses() {
        for (Course course : smsCourses) {
            if (course != null) {
                System.out.println(course);
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
    public void addTeacher(String fName, String lName, byte experience, String dId) {
        fName = toUpper(fName);
        lName = toUpper(lName);
        dId = toUpper(dId);
        if (smsTeachers[MAX_TEACHER_NUM - 1] != null) {
            System.out.printf("You've reached the maximum allocated teachers (%d). Teacher not added\n", MAX_TEACHER_NUM);
        } else {
            for (int i = 0; i < MAX_TEACHER_NUM; i++) {
                if (smsTeachers[i] == null) {
                    smsTeachers[i] = new Teacher(fName, lName, experience, findDepartment(dId));
                    break;
                }
            }
        }
    }

    /**
     * method that adds a gender to the teacher
     * @param gender input gender
     */
    public void addTeacherGender(String gender) { //add teacher id to the parameters
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
        for (Teacher teacher : smsTeachers) {
            if (teacher != null && teacher.getId().equals(tId)) {
                return teacher;
            }
        }
        System.out.printf("The teacher with id %s does not exist or is out of bound\n", tId);
        return null;
    }

    /**
     * prints all teachers, except for the ones that are null
     */
    public void printTeachers() {
        for (Teacher teacher : smsTeachers) {
            if (teacher != null) {
                System.out.println(teacher);
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
        fName = toUpper(fName);
        lName = toUpper(lName);
        dId = toUpper(dId);
        if (smsStudents[MAX_STUDENT_NUM - 1] != null) {
            System.out.printf("You've reached the maximum allocated students (%d). Student not added\n", MAX_STUDENT_NUM);
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
     * method that adds a gender to the student
     * @param gender input gender
     */
    public void addStudentGender(String gender) { //check add teacher gender (add sId)
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
        for (Student student : smsStudents) {
            if (student != null && student.getId().equals(sId)) {
                return student;
            }
        }
        System.out.printf("The teacher with id %s does not exist or is out of bound\n", sId);
        return null;
    }

    /**
     * prints all students, except the ones that are null
     */
    public void printStudents() {
        for (Student student : smsStudents) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    /**
     * method that registers a student to a course using the student and course id (unless the id of both don't exist)
     * @param sId the student id
     * @param cId the course id
     */
    public void registerCourse(String sId, String cId, double score) {
        sId = toUpper(sId);
        cId = toUpper(cId);

        Student student = findStudent(sId);
        Course course = findCourse(cId);

        StringBuilder cNames = new StringBuilder();

        if (student.getCourseNum() >= MAX_COURSE_REGISTER_NUM) {
            System.out.printf("The student with id %s has already registered for 5 courses\n", sId);
            return;
        }

        if (course.getStudentNum() >= MAX_COURSE_REGISTER_NUM) {
            System.out.printf("The course with id %s has already been registered by 5 students\n", cId);
            return;
        }

        for (Course c : student.getCourses()) {
            if (c == course) {
                System.out.printf("The course with id %s has already been registered by student with id %s", cId, sId);
                return;
            }
        }

        Course[] studentCourses = student.getCourses();
        Double[] scores = student.getScore();
        double averageScore = 0;
        byte studentCourseNum = student.getCourseNum();

        studentCourses[studentCourseNum] = course;
        student.setCourses(studentCourses);
        student.setCourseNum(++studentCourseNum);
        for (int i = 0; i < MAX_COURSE_REGISTER_NUM; i++) {
            if (scores[i] != null) {
                averageScore += scores[i];
            }
            if (scores[i] == null) {
                scores[i] = score;
                averageScore += score;
                averageScore /= studentCourseNum;
                break;
            }
        }
        student.setAvgScore(averageScore);

        Student[] courseStudent = course.getStudent();
        byte courseStudentNum = course.getStudentNum();

        courseStudent[courseStudentNum] = student;
        course.setStudent(courseStudent);
        course.setStudentNum((byte) (courseStudentNum + 1));

        for (int i = 0; i < MAX_COURSE_REGISTER_NUM; i++) {
            if (courseStudent[i] != null) {
                cNames.append(i == 0 ? courseStudent[i].getFName() + " " + courseStudent[i].getLName() : ", " + courseStudent[i].getFName() + " " + courseStudent[i].getLName());
            }
        }

        System.out.printf("Latest student info: %s\n", student);
        System.out.printf("Latest course info: Course{id=%s, courseName=%s, credit=%.1f, teacher=%s, course average=%.1f, department=%s, students=[%s]}\n", cId, course.getCourseName(), course.getCredit(), (course.getTeacher().getFName() + " " + course.getTeacher().getLName()), calcCourseAverage(cId), course.getDepartment().getDepartmentName(), cNames);
    }

    //extra methods
    /**
     * method that returns the capitalized word(s)
     * @param strIn input
     * @return capitalized input string
     */
    public String toUpper(String strIn) {
        if (!(strIn == null || strIn.isEmpty()) && !(Character.isUpperCase(strIn.charAt(0)))) {
            char firstLetter = Character.toUpperCase(strIn.charAt(0));
            return firstLetter + strIn.substring(1);
        }
        return strIn;
    }

    /**
     * method that takes the scores of the students in a specific course and finds the average score
     * @param cId the course id (needed to find the students of the course and their individual scores)
     * @return the average score of the course
     */
    public double calcCourseAverage(String cId) {
        double result = 0;
        Student[] students = findCourse(cId).getStudent();
        for (int i = 0; i < MAX_COURSE_REGISTER_NUM; i++) {
            if (students[i] != null) {
                result += students[i].getAvgScore();
            }
        }
        return (result / findCourse(cId).getStudentNum());
    }

    /**
     * method that removes 1 or more item from the system based on the input "item", the amount "count", and which one/where it starts
     * @param item item to remove(student, department, course, teacher, everything)
     * @param count how many items to remove
     * @param startingId which specific item to remove (if count = 1) or from what item to start removing
     */
    public void removeItems(String item, int count, String startingId) {
        item = item.toLowerCase();
        switch (item) {
            case "everything" -> {
                for (int i = 0; i < MAX_STUDENT_NUM; i++) {
                    smsStudents[i] = null;
                    if (i < MAX_COURSE_NUM) {
                        smsCourses[i] = null;
                    }
                    if (i < MAX_TEACHER_NUM) {
                        smsTeachers[i] = null;
                    }
                    if (i < MAX_DEPARTMENT_NUM) {
                        smsDepartments[i] = null;
                    }
                }
            }
            case "department" -> {
                if (count == 0) {
                    System.out.println("Enter more than 1 item to remove");
                } else if (count == 1) {
                    Department department = findDepartment(startingId);
                    if (department == null) {
                        break;
                    }
                    for (int i = 0; i < MAX_DEPARTMENT_NUM; i++) {
                        if (smsDepartments[i] == department) {
                            smsDepartments[i] = null;
                            break;
                        }
                    }
                } else  {
                    Department department = findDepartment(startingId);
                    if (department == null) {
                        break;
                    }
                    for (int i = 0; i < MAX_DEPARTMENT_NUM; i++) {
                        if (smsDepartments[i] == department) {
                            for (int j = i; j < (i + count); j++) {
                                smsDepartments[j] = null;
                            }
                            break;
                        }
                    }
                }
            }
            case "student" -> {
                if (count == 0) {
                    System.out.println("Enter more than 1 item to remove");
                } else if (count == 1) {
                    Student student = findStudent(startingId);
                    if (student == null) {
                        break;
                    }
                    for (int i = 0; i < MAX_STUDENT_NUM; i++) {
                        if (smsStudents[i] == student) {
                            smsStudents[i] = null;
                            break;
                        }
                    }
                } else  {
                    Student student = findStudent(startingId);
                    if (student == null) {
                        break;
                    }
                    for (int i = 0; i < MAX_STUDENT_NUM; i++) {
                        if (smsStudents[i] == student) {
                            for (int j = i; j < (i + count); j++) {
                                smsStudents[j] = null;
                            }
                            break;
                        }
                    }
                }
            }
            case "teacher" -> {
                if (count == 0) {
                    System.out.println("Enter more than 1 item to remove");
                } else if (count == 1) {
                    Teacher teacher = findTeacher(startingId);
                    if (teacher == null) {
                        break;
                    }
                    for (int i = 0; i < MAX_TEACHER_NUM; i++) {
                        if (smsTeachers[i] == teacher) {
                            smsTeachers[i] = null;
                            break;
                        }
                    }
                } else  {
                    Teacher teacher = findTeacher(startingId);
                    if (teacher == null) {
                        break;
                    }
                    for (int i = 0; i < MAX_TEACHER_NUM; i++) {
                        if (smsTeachers[i] == teacher) {
                            for (int j = i; j < (i + count); j++) {
                                smsTeachers[j] = null;
                            }
                            break;
                        }
                    }
                }
            }
            case "courses" -> {
                if (count == 0) {
                    System.out.println("Enter more than 1 item to remove");
                } else if (count == 1) {
                    Course course = findCourse(startingId);
                    if (course == null) {
                        break;
                    }
                    for (int i = 0; i < MAX_COURSE_NUM; i++) {
                        if (smsCourses[i] == course) {
                            smsCourses[i] = null;
                            break;
                        }
                    }
                } else {
                    Course course = findCourse(startingId);
                    if (course == null) {
                        break;
                    }
                    for (int i = 0; i < MAX_COURSE_NUM; i++) {
                        if (smsCourses[i] == course) {
                            for (int j = i; j < (i + count); j++) {
                                smsCourses[j] = null;
                            }
                            break;
                        }
                    }
                }
            }
            case "registered teacher" -> {
                Course course = findCourse(startingId);
                if (course == null) {
                    break;
                }
                for (int i = 0; i < MAX_COURSE_NUM; i++) {
                    if (smsCourses[i] == course) {
                        smsCourses[i].setTeacher(null);
                    }
                }
            }
            default -> System.out.println("Enter a valid option");
        }
    }

    /**
     * method that removes a registered student from a course and vice versa
     * @param sId student id
     * @param cId course id
     */
    public void removeItems(String sId, String cId) {
        sId = toUpper(sId);
        cId = toUpper(cId);

        Student student = findStudent(sId);
        Course course = findCourse(cId);

        StringBuilder cNames = new StringBuilder();

        if (student.getCourseNum() <= 0) {
            System.out.printf("The student with id %s is not registered to any courses\n", sId);
            return;
        }

        if (course.getStudentNum() <= 0) {
            System.out.printf("The course with id %s is not registered by any student\n", cId);
            return;
        }

        Course[] studentCourses = student.getCourses();
        Course[] newStudentCourses = new Course[]{null, null, null, null, null};
        double studentAvgScore = student.getAvgScore();
        Double[] studentScores = student.getScore();
        Double[] newStudentScores = new Double[]{null, null, null, null, null};
        byte studentCourseNum = student.getCourseNum();

        for (int i = 0; i < MAX_COURSE_REGISTER_NUM; i++) {
            if (studentCourses[i] == course) {
                studentCourses[i] = null;
                student.setAvgScore((studentAvgScore * studentCourseNum - studentScores[i]) / (--studentCourseNum));
                studentScores[i] = null;
                student.setCourseNum(studentCourseNum);
            }
            if (studentCourses[i] != null) {
                newStudentCourses[i] = studentCourses[i];
                newStudentScores[i] = studentScores[i];
            }
        }

        Student[] courseStudent = course.getStudent();
        Student[] newCourseStudent = new Student[] {null, null, null, null, null};
        double courseScores = course.getAvgScore();
        byte courseStudentNum = course.getStudentNum();

        for (int i = 0; i < MAX_COURSE_REGISTER_NUM; i++) {
            if (courseStudent[i] == student) {
                courseStudent[i] = null;
                course.setAvgScore((courseScores * courseScores - student.getAvgScore()) / (--courseStudentNum));
                course.setStudentNum(courseStudentNum);
            }
            if (courseStudent[i] != null) {
                newCourseStudent[i] = courseStudent[i];
            }
        }

        course.setStudent(newCourseStudent);

        System.out.printf("Latest student info: %s\n", student);
        System.out.printf("Latest course info: Course{id=%s, courseName=%s, credit=%.1f, teacher=%s, course average=%.1f, department=%s, students=[%s]}\n", cId, course.getCourseName(), course.getCredit(), (course.getTeacher().getFName() + " " + course.getTeacher().getLName()), calcCourseAverage(cId), course.getDepartment().getDepartmentName(), cNames);
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
        return String.format("SchoolManagementSystem{name=%s, students=[%s], teachers=[%s], courses=[%s], departments=[%s]}", smsName, sNames, tNames, cNames, dNames);
    }
}
