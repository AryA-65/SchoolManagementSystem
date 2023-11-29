# SchoolManagementSystem Final Project

## Functionalities of the program:
1. School class contains a maximum of 5 different departments which have their own id (ex: D001). The id increases with each department
2. School class contains a maximum of 200 different students which have their own id (ex: S001). The id increases with each student. Each student can register for a maximum of 5 courses. Initially, a student is not assigned to a course.
3. School class contains a maximum of 20 different teachers which have their own id (ex: T001). The id increases with each teacher.
4. School class contains a maximum of 30 different courses which have their own id (ex: C001). The id increases with each course. Each course is taught by one teacher and can be registered by a maximum of 5 students. Initially, a teach and students are not assigned to a specific course.
5. The program should be able to:
   - Add a new department
   - Add a new student
   - Add a new teacher
   - Add a new course
   - Display all department, and only the ones that aren't *null*.
   - Display all students, and only the ones that aren't *null*. Also display registered departments and names, if any.
   - Display all teachers, and only the ones that aren't *null*. Also display registered courses and departments, if any.
   - Display all courses, and only the ones that aren't *null*. Also display the names of the teachers, students and departments, if any (this method is not displayed in the **Class Diagram**).
   - Search a department based on the department id (if the department id doesn't exist, return *null*)
   - Search a teacher based on the teacher id (if the teacher id doesn't exist, return *null*)
   - Search a student based on the student id (if the student id doesn't exist, return *null*)
   - Search a course based on the course id (if the course id doesn't exist, return *null*)
   - Assign a teacher to a specific course based on the teacher id and the course id (if both ids don't exist, return *null*)
   - Register a course for a student based on the student id and course id. This method will check:
     * If the student id and course id exist. If not, print a message
     * If the student has registered all of his allowed classes (a maximum of 5 classes per student). If so, return a message
     * If the course has been registered by the allowed amount of student (a maximum of 5 students per course). If so, return a message
     * If the course has already been registered by the student. If so, print a message
     * If none of the above are true, add the course to the students registered courses (Course[] array), and also add the courses to the registered student (Student[] array)

## Class diagram
  ![Class Diagram](https://github.com/AryA-65/SchoolManagementSystem/assets/113271844/450c99af-2f4d-4ac7-b73f-357e9f73e1ae)
