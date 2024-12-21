import com.sun.source.tree.TryTree;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void add_Course() {
        ArrayList<String> prerequisites = new ArrayList<>();
        prerequisites.add("DSA");
        prerequisites.add("AP");
        Course course1 = new Course(101, "Computer Science", 4, 1, "9:00-10:00 (MWF)", "10:00-11:00", "Syllabus", 2, prerequisites);
        CourseInventory.courses.add(course1);
        CourseInventory.courseMap.put(101, course1);



        Course course2 = new Course(202, "Mathematics", 4, 1, "9:00-10:00 (MWF)", "10:00-11:00", "Syllabus", 3, prerequisites);
        CourseInventory.courses.add(course2);
        CourseInventory.courseMap.put(202, course2);

        Course course3 = new Course(303, "Operating System", 4, 1, "9:00-10:00 (MWF)", "9:00-10:00 (MWF)", "Syllabus", 3, prerequisites);
        CourseInventory.courses.add(course3);
        CourseInventory.courseMap.put(303, course3);

        Course course4 = new Course(404, "Discrete Mathematics", 4, 2, "9:00-10:00 (MWF)", "9:00-10:00 (MWF)", "Syllabus", 3, prerequisites);
        CourseInventory.courses.add(course4);
        CourseInventory.courseMap.put(404, course4);

        Course course5 = new Course(505, "Data Structures and Algorithms", 4, 2,  "9:00-10:00 (MWF)", "9:00-10:00 (MWF)", "Syllabus", 3, prerequisites);
        CourseInventory.courses.add(course5);
        CourseInventory.courseMap.put(505, course5);
        Course course6 = new Course(606, "Database Management Systems", 4, 2, "9:00-10:00 (MWF)", "9:00-10:00 (MWF)", "Syllabus", 3, prerequisites);
        CourseInventory.courses.add(course6);
        CourseInventory.courseMap.put(606, course6);
    }
    public static void add_Complaint() {
        Complaint complaint1 = new Complaint("complaint 1", "s");
        Complaint complaint2 = new Complaint("complaint 2", "s");
        Complaint complaint3 = new Complaint("complaint 3", "s");
        Complaint complaint4 = new Complaint("complaint 4", "s");

        ComplaintInventory.complaints.add(complaint1);
        ComplaintInventory.complaints.add(complaint2);
        ComplaintInventory.complaints.add(complaint3);
        ComplaintInventory.complaints.add(complaint4);
    }

    public static void add_Student() {
        Student student1 = new Student("s1", "s1", "s1", 1);
        Student student2 = new Student("s2", "s2", "s2", 1);
        Student student3 = new Student("s3", "s3", "s3", 1);
        User.students.add(student1);
        User.students.add(student2);
        User.students.add(student3);
    }

    public static void add_Proff() {
        Professor professor1 = new Professor("p1", "p1", "p1");
        Professor professor2 = new Professor("p2", "p2", "p2");

        User.professors.add(professor1);
        User.professors.add(professor2);

    }

    public static void add_Administrator() {
        Administrator admin1 = new Administrator("a1", "a1", "password");

        User.administrators.add(admin1);

    }




    public static void main(String[] args) {
        add_Course();
        add_Complaint();
        add_Student();
        add_Proff();
        add_Administrator();



        Scanner sc = new Scanner(System.in);
        boolean exitSystem = false;

        System.out.println("WELCOME TO UNIVERSITY COURSE REGISTRATION SYSTEM");

        System.out.println("Enter 'Enter' to log in/sign up or 'Exit' to leave the system:");
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("exit")) {
            System.out.println("Thank you for using the system. Goodbye!");
            exitSystem = true;
        }

        while (!exitSystem) {
            if (input.equalsIgnoreCase("enter")) {
                boolean loggedOut = false;

                while (!loggedOut) {
                    System.out.println("Enter as Student (S), Professor (P), Teaching Assistant(TA) , or Administrator (A)");
                    String role = sc.nextLine();

                    User user = null;
                    Student ta = null;

                    if (role.equalsIgnoreCase("S")) {
                        System.out.println("Enter 'login'(L) or 'sign up'(S):");
                        String action = sc.nextLine();

                        System.out.println("Enter your name, email, password and semester:");
                        String name = sc.nextLine();
                        String email = sc.nextLine();
                        String password = sc.nextLine();
                        int semester = sc.nextInt();
                        sc.nextLine();

                        if (action.equalsIgnoreCase("S")) {
                            user = new Student(name, email, password, semester);
                            user.signUp(email, password);
                        } else if (action.equalsIgnoreCase("L")) {
                            for (Student s : User.students) {
                                if (s.getEmail().equalsIgnoreCase(email)) {
                                    user = s;
                                    break;
                                }
                            }
                            try{
                                if (user != null) {
                                    user.login(email, password);
                                } else {
                                    throw new InvalidLoginException("InvalidLoginException");
                                }

                            }catch(InvalidLoginException e){
                                System.out.println(e.getMessage());
                                continue;
                            }

                        }

                        System.out.println("Enter Your Choice");
                        System.out.println("1. View Available Courses");
                        System.out.println("2. Register for Course");
                        System.out.println("3. View Your Marks");
                        System.out.println("4. View Schedule");
                        System.out.println("5. Submit Complaint");
                        System.out.println("6. Drop Course");
                        System.out.println("7. Submit Feedback");
                        System.out.println("8. Logout");
                        int choice = sc.nextInt();
                        sc.nextLine();

                        if (choice == 1) {
                            ((Student) user).viewAvailableCourses();
                        } else if (choice == 2) {
                            System.out.println("Enter the course code to register:");
                            int courseCode = sc.nextInt();
                            sc.nextLine();
                            ((Student) user).registerForCourse(courseCode);
                        } else if (choice == 3) {
                            ((Student) user).trackProgress();
                        } else if (choice == 4) {
                            ((Student) user).viewSchedule();
                        } else if (choice == 5) {
                            System.out.println("Enter your complaint:");
                            String complaint = sc.nextLine();
                            user.submitComplaint(complaint, user.getName());
                        } else if (choice == 6) {
                            System.out.println("Enter the course code to drop:");
                            int courseCode = sc.nextInt();
                            sc.nextLine();

                            ((Student) user).dropCourse(courseCode);
                        } else if (choice == 7) {
                            System.out.println("Give course code to give feedback");
                            int courseCode = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Enter your feedback:");
                            System.out.println("1.Rating");
                            System.out.println("2.Description");
                            int x=sc.nextInt();
                            sc.nextLine();
                            if(x == 1) {
                                System.out.println("Enter your rating:");
                                int rating = sc.nextInt();
                                sc.nextLine();
                                user.submit_Feedback(rating, user.getName(), courseCode);
                            } else if (x == 2) {
                                System.out.println("Enter your description:");
                                String description = sc.nextLine();
                                user.submit_Feedback(description, user.getName(), courseCode);
                            }

                        } else if (choice == 8) {
                            user.logout();
                            loggedOut = true;
                        }

                    } else if (role.equalsIgnoreCase("P")) {
                        System.out.println("Enter 'login'(L) or 'sign up'(S):");
                        String action = sc.nextLine();

                        System.out.println("Enter your name, email, and password:");
                        String name = sc.nextLine();
                        String email = sc.nextLine();
                        String password = sc.nextLine();



                        if (action.equalsIgnoreCase("S")) {
                            user = new Professor(name, email, password);
                            user.signUp(email, password);
                        }else if (action.equalsIgnoreCase("L")) {
                            for (Professor p : User.professors) {
                                if (p.getEmail().equalsIgnoreCase(email)) {
                                    user = p;
                                    break;
                                }
                            }
                            try{
                                if (user != null) {
                                    user.login(email, password);
                                } else {
                                    throw new InvalidLoginException("InvalidLoginException");
                                }
                            }catch (InvalidLoginException e) {
                                System.out.println(e.getMessage());
                                continue;
                            }
                        }


                        System.out.println("Enter Your Choice");
                        System.out.println("1. View Enrolled Students");
                        System.out.println("2. View Your Courses");
                        System.out.println("3. Update Course Details");
                        System.out.println("4. Assign Student Grades");
                        System.out.println("5. View Feedback");
                        System.out.println("6. Logout");
                        int choice = sc.nextInt();
                        sc.nextLine();

                        if (choice == 1) {
                            System.out.println("Enter the course code to view enrolled students:");
                            int courseCode = sc.nextInt();
                            sc.nextLine();
                            ((Professor) user).viewEnrolledStudents(courseCode);
                        } else if (choice == 2) {
                            System.out.println("Enrolled Courses:");
                            ((Professor) user).getcourses();
                        } else if (choice == 3) {
                            System.out.println("Enter the course code to update course details:");
                            int courseCode = sc.nextInt();
                            sc.nextLine(); // Consume newline

                            System.out.println("Enter the new timings:");
                            String timings = sc.nextLine();
                            System.out.println("Enter the new Office Hours:");
                            String officeHrs = sc.nextLine();
                            System.out.println("Enter the new Syllabus:");
                            String syllabus = sc.nextLine();
                            System.out.println("Enter the new Enrollment Limit:");
                            int enrollmentLimit = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the number of prerequisites:");
                            int numPrerequisites = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the prerequisites:");
                            ArrayList<String> prerequisites = new ArrayList<>();
                            for (int i = 0; i < numPrerequisites; i++) {
                                String prerequisite = sc.nextLine();
                                prerequisites.add(prerequisite);
                            }
                            ((Professor) user).update_Course_Details(courseCode, timings, officeHrs, syllabus, enrollmentLimit, prerequisites);
                        } else if (choice == 4) {
                            System.out.println("Enter the course title to assign grades:");
                            String courseTitle = sc.nextLine();
                            System.out.println("Enter the student email to assign grades:");
                            String studentEmail = sc.nextLine();
                            System.out.println("Enter the grade:");
                            int grade = sc.nextInt();
                            sc.nextLine();
                            ((Professor) user).Assign_Student_Grades(courseTitle, studentEmail, grade);
                        } else if (choice==5) {
                            FeedbackInventory.viewFeedback();

                        } else if (choice == 6) {
                            user.logout();
                            loggedOut = true;
                        }

                    } else if (role.equalsIgnoreCase("A")) {
                        System.out.println("Login");
                        System.out.println("Admin pass is password");

                        System.out.println("Enter your name, email, and password:");
                        String name = sc.nextLine();
                        String email = sc.nextLine();
                        String password = sc.nextLine();
                        user = new Administrator(name, email, password);

                        user.signUp(email, password);
                        try{
                            if(!password.equalsIgnoreCase("password")){
                                throw new InvalidLoginException("InvalidLoginException");
                            }
                        }catch(InvalidLoginException e){
                            System.out.println(e.getMessage());
                            continue;
                        }


                        System.out.println("Enter your Choice");
                        System.out.println("1. Add Course");
                        System.out.println("2. Remove Course");
                        System.out.println("3. View Courses");
                        System.out.println("4. View Student Information");
                        System.out.println("5. Set Student Marks");
                        System.out.println("6. Assign Professor to Course");
                        System.out.println("7. View Complaints");
                        System.out.println("8. Update Complaint Status");
                        System.out.println("9. Filter Complaints");
                        System.out.println("10. Add Completed Courses to Students");
                        System.out.println("11. View Feedback");
                        System.out.println("12. Assign TA to Course");
                        System.out.println("13 Update course details");
                        System.out.println("14. Update Course drop Deadline");
                        System.out.println("15. Logout");
                        int choice = sc.nextInt();
                        sc.nextLine();

                        if (choice == 1) {
                            System.out.println("Enter the course code:");
                            int courseCode = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the title:");
                            String title = sc.nextLine();
                            System.out.println("Enter the credits:");
                            int credits = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the semester:");
                            int semester = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the timings:");
                            String timings = sc.nextLine();
                            System.out.println("Enter the Office Hours:");
                            String officeHrs = sc.nextLine();
                            System.out.println("Enter the Syllabus:");
                            String syllabus = sc.nextLine();
                            System.out.println("Enter the Enrollment Limit:");
                            int enrollmentLimit = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the number of prerequisites:");
                            int numPrerequisites = sc.nextInt();
                            sc.nextLine();
                            ArrayList<String> prerequisites = new ArrayList<>();
                            for (int i = 0; i < numPrerequisites; i++) {
                                System.out.println("Enter prerequisite " + (i + 1) + ":");
                                String prerequisite = sc.nextLine();
                                prerequisites.add(prerequisite);
                            }

                            ((Administrator) user).add_Course(courseCode, title, credits, semester, timings, officeHrs, syllabus, enrollmentLimit, prerequisites);
                        } else if (choice == 2) {
                            System.out.println("Enter the course code to remove:");
                            int courseCode = sc.nextInt();
                            sc.nextLine();
                            ((Administrator) user).remove_Course(courseCode);
                        } else if (choice == 3) {
                            ((Administrator) user).view_courses();
                        } else if (choice == 4) {
                            ((Administrator) user).view_Student_Records();
                        } else if (choice == 5) {
                            System.out.println("Enter the title:");
                            String title = sc.nextLine();
                            System.out.println("Enter the student name:");
                            String studentName = sc.nextLine();
                            System.out.println("Enter the grade:");
                            int grade = sc.nextInt();
                            sc.nextLine();
                            ((Administrator) user).student_Marks(title, studentName, grade);
                        } else if (choice == 6) {
                            System.out.println("Enter the professor name:");
                            String professorName = sc.nextLine();
                            System.out.println("Enter the course code:");
                            int courseCode = sc.nextInt();
                            sc.nextLine();
                            ((Administrator) user).Assign_Proff_to_Course(professorName, courseCode);
                        } else if (choice == 7) {
                            ((Administrator) user).view_complaints();
                        } else if (choice == 8) {
                            System.out.println("Enter the student name who submitted the complaint:");
                            String studentName = sc.nextLine();

                            for (Complaint complaint : ComplaintInventory.complaints) {
                                if (complaint.getStudentName().equalsIgnoreCase(studentName)) {
                                    ((Administrator) user).update_complaint_status(complaint);
                                    break;
                                }
                            }

                        } else if (choice == 9) {
                            ((Administrator) user).filter_complaints();
                        } else if (choice == 10) {


                            System.out.println("Enter the student name:");
                            String studentName = sc.nextLine();
                            System.out.println("Enter the course code:");
                            int courseCode = sc.nextInt();
                            sc.nextLine();
                            for(Student student : User.students){
                                if(student.getName().equalsIgnoreCase(studentName)){
                                    for(Course course : student.enrollCourses){
                                        if(course.getCourseCode()==courseCode){
                                            student.completed_Courses.add(course);
                                            course.completed = true;
                                            student.enrollCourses.remove(course);
                                            System.out.println("Course added to student's completed courses");
                                            break;
                                        }
                                    }
                                }
                            }

                        }else if (choice == 11) {
                            FeedbackInventory.viewFeedback();
                        }else if (choice ==12){
                            System.out.println("Enter the course code:");
                            int courseCode = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the TA name:");
                            String taName = sc.nextLine();
                            ((Administrator) user).Assign_TA_to_Course(taName, courseCode);

                        } else if (choice==13) {
                            System.out.println("Enter the course code to update:");               // int courseCode, String title, int credits ,int semester , String professor, String timings, String OfficeHrs, String Syllabus, int EnrollenmentLimit , ArrayList<String> prerequisites, int deadline_Month
                            int courseCode = sc.nextInt();
                            sc.nextLine();
                            Course co = CourseInventory.courseMap.get(courseCode);
                            System.out.println("what do you want to update?");
                            System.out.println("1.Title");
                            System.out.println("2.Credits");
                            System.out.println("3.Semester");
                            System.out.println("4.Professor");
                            System.out.println("5.Timings");
                            System.out.println("6.Office Hours");
                            System.out.println("7.Syllabus");
                            System.out.println("8.Enrollment Limit");
                            System.out.println("9.Prerequisites");

                            int x = sc.nextInt();
                            sc.nextLine();
                            if (x == 1) {
                                System.out.println("Enter the new title:");
                                String title = sc.nextLine();
                                co.setTitle(title);
                            }else if (x == 2) {
                                System.out.println("Enter the new credits:");
                                int credits = sc.nextInt();
                                co.setCredits(credits);
                            } else if (x == 3) {
                                    System.out.println("Enter the new semester:");
                                    int semester = sc.nextInt();
                                    co.setSemester(semester);
                            } else if (x == 4) {
                                System.out.println("Enter the new professor:");
                                String professor = sc.nextLine();
                                co.setProfessor(professor);
                            } else if (x == 5) {
                                System.out.println("Enter the new timings:");
                                String timings = sc.nextLine();
                                co.setTimings(timings);
                            } else if (x == 6) {
                                System.out.println("Enter the new office hours:");
                                String officeHrs = sc.nextLine();
                                co.set_Office_Hrs(officeHrs);
                            } else if (x == 7) {
                                System.out.println("Enter the new syllabus:");
                                String syllabus = sc.nextLine();
                                co.setSyllabus(syllabus);
                            } else if (x == 8) {
                                System.out.println("Enter the new enrollment limit:");
                                int enrollmentLimit = sc.nextInt();
                                sc.nextLine();
                                co.setEnrollenmentLimit(enrollmentLimit);
                            } else if (x == 9) {
                                ArrayList<String> prerequisites = new ArrayList<String>();
                                System.out.println("Enter the number of prerequisites:");
                                int numPrerequisites = sc.nextInt();
                                sc.nextLine();
                                for (int i = 0; i < numPrerequisites; i++) {
                                    System.out.println("Enter prerequisite " + (i + 1) + ":");
                                    String prerequisite = sc.nextLine();
                                    prerequisites.add(prerequisite);
                                }
                                co.setPrerequisites(prerequisites);
                            }

                        } else if (choice==14) {
                            System.out.println("Enter the course drop Deadline (YYYY-MM-DD):");
                            String deadline = sc.nextLine();
                            LocalDate DropDeadline = LocalDate.parse(deadline);
                            ((Administrator) user).dropDeadline= DropDeadline;

                        } else if (choice == 15) {
                            user.logout();
                            loggedOut = true;
                            break;
                        }

                    } else if (role.equalsIgnoreCase("TA")) {

                        System.out.println("Enter 'login'(L) or 'sign up'(S):");
                        String action = sc.nextLine();

                        System.out.println("Enter your name, email, password , semester");
                        String name = sc.nextLine();
                        String email = sc.nextLine();
                        String password = sc.nextLine();
                        int semester = sc.nextInt();
                        sc.nextLine();


                        if (action.equalsIgnoreCase("S") ) {
                            ta = new TA(name, email, password, semester);
                            ta.signUp(email, password);
                        } else if (action.equalsIgnoreCase("L")) {
                            for (TA i : User.TA) {
                                if (i.getEmail().equalsIgnoreCase(email)) {
                                    ta = i;
                                    break;
                                }
                            }
                            try{
                                if (ta != null) {
                                    ta.login(email, password);
                                } else {
                                    throw new InvalidLoginException("InvalidLoginException");
                                }
                            }catch (InvalidLoginException e){
                                System.out.println(e.getMessage());
                                continue;
                            }

                        }

                        System.out.println("1. View Assigned Courses to TA");
                        System.out.println("2. View Enrolled Students in Course Assigned to TA");
                        System.out.println("3. Update Student Grades in Course Assigned to TA");
                        System.out.println("4. View Available Courses");
                        System.out.println("5. Register for Course");
                        System.out.println("6. View Your Marks");
                        System.out.println("7. View Schedule");
                        System.out.println("8. Submit Complaint");
                        System.out.println("9. Drop Course");
                        System.out.println("10. Submit Feedback");

                        System.out.println("11. Logout\n");
                        System.out.println("Enter your choice:");
                        int choice = sc.nextInt();
                        sc.nextLine();


                        if (choice == 1) {
                            ((TA) ta).view_Course(((TA)ta));
                        } else if (choice == 2) {
                            ((TA) ta).viewEnrolledStudents(((TA)ta));
                        } else if (choice == 3) {
                            System.out.println("Enter the course Title:");
                            String title = sc.nextLine();
                            System.out.println("Enter the student name:");
                            String studentname = sc.nextLine();
                            System.out.println("Enter the grade:");
                            int grade = sc.nextInt();
                            sc.nextLine();

                            ((TA) ta).student_Marks(title,studentname,grade,((TA)ta));                    //String title, String studentname, int grade, TA ta
                        } else if (choice==4) {
                            ((TA) ta).viewAvailableCourses();

                        } else if (choice==5) {
                            System.out.println("Enter the course code:");
                            int code = sc.nextInt();
                            sc.nextLine();
                            ((TA) ta).registerForCourse(code);

                        } else if (choice==6) {
                            ((TA) ta).trackProgress();

                        } else if (choice==7) {
                            ((TA) ta).viewSchedule();

                        } else if (choice==8) {
                            System.out.println("Enter your complaint:");
                            String complaint = sc.nextLine();
                            ((TA)ta).submitComplaint(complaint, ((TA)ta).getName());

                        }else if (choice ==9){
                            System.out.println("Enter the course code to drop:");
                            int courseCode = sc.nextInt();
                            sc.nextLine();

                            ((TA) ta).dropCourse(courseCode);

                        }else if (choice ==10){
                            System.out.println("Give course code to give feedback");
                            int courseCode = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Enter your feedback:");
                            System.out.println("1.Rating");
                            System.out.println("2.Description");
                            if(sc.nextInt() == 1) {
                                System.out.println("Enter your rating:");
                                int rating = sc.nextInt();
                                sc.nextLine();
                                ((TA)ta).submit_Feedback(rating, ((TA)ta).getName(), courseCode);
                            } else if (sc.nextInt() == 2) {
                                System.out.println("Enter your description:");
                                String description = sc.nextLine();
                                ((TA)ta).submit_Feedback(description, ((TA)ta).getName(), courseCode);
                            }



                        } else if (choice == 11) {
                            ((TA)ta).logout();
                            loggedOut = true;
                        }


                    } else {
                        System.out.println("Invalid role. Please try again.");
                        continue;
                    }

                    // After login or sign up, provide the option to log out
                    System.out.println("Do you want to log out? (yes/no)");
                    String logoutResponse = sc.nextLine();

                    if (logoutResponse.equalsIgnoreCase("yes")) {
                        user.logout();
                        loggedOut = true;
                    }
                }
            } else {
                System.out.println("Invalid input. Please enter 'Enter' or 'Exit'.");
            }
        }
    }
}
