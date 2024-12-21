
import java.time.LocalDate;
import java.util.*;


public class Student extends User implements CourseInterface {

    private int semester;
    private static Map<String, String> StudentDatabase = new HashMap<>();  // mail , password
    private int totalCredits = 0;

    public Student(String name, String email, String password, int semester) {
        super(name, email, password);
        this.semester = semester;
        User.students.add(this);
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    @Override
    public void display() {
        System.out.println("Student: " + getName() + " " + getEmail() + " " + getPassword());
    }

    @Override
    public void login(String email, String password)  {
        // Check if the email exists and password matches
        System.out.println("Logging in as Student...");
        System.out.println("finding your email and password in the database...");

        for (Student student : User.students) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password) && student.getName().equals(this.getName())) {
                System.out.println(student.getName() + " logged in successfully");
                return;
            }
        }

            System.out.println("Invalid email or password");




    }
    @Override
    public void signUp(String email, String password) {

        System.out.println("Signing up as Student...");
        if (!StudentDatabase.containsKey(email)) {
            StudentDatabase.put(email, password);
            System.out.println(super.getName() + " has successfully signed up with email: " + email);


        } else {
            System.out.println("Email already exists");
            login(email, password);
        }
    }

    @Override
    public void logout() {
        System.out.println(super.getName() + " logged out.");
    }

    public void add_database(String email,String password){
        StudentDatabase.put(email, password);
    }


    @Override
    public void viewAvailableCourses(){
        System.out.println("Available Courses:");
        if(CourseInventory.courses == null || CourseInventory.courses.isEmpty()){
            System.out.println("No courses available");
        }else {
            for (Course course : CourseInventory.courses) {
                System.out.println(course.getTitle()+" "+ course.getCourseCode());
            }
        }
    }
                                         static ArrayList<Course> enrollCourses = new ArrayList<>();
                                      Map<String, Integer> marks = new HashMap<>();
                                      static ArrayList<Course>completed_Courses =new ArrayList<>();

    void marksAllocation() {
        for (Course course : enrollCourses) {
            System.out.println("Enter marks for course: " + course.getTitle());
            Scanner sc = new Scanner(System.in);
            int mark = sc.nextInt();
            marks.put(course.getTitle(), mark);
        }
    }


    @Override
    public void registerForCourse(int courseCode) {
        Course course = CourseInventory.courseMap.get(courseCode);
        boolean courseFull = false;

        if (course != null) {
            try {
                int cnt = 0;
                for (Student student : course.enrolledStudents) {
                    cnt++;
                }
                if (cnt >= course.getEnrollenmentLimit()) {
                    throw new CourseFullException("CourseFullException");
                }
            } catch (CourseFullException e) {
                System.out.println(e.getMessage());
                courseFull = true;
            }

            if (!courseFull) {
                if (this.semester == course.semester && (totalCredits + course.getCredits()) <= 20) {
                    System.out.println("Registered for course: " + course.getTitle());
                    enrollCourses.add(course);
                    marks.put(course.getTitle(), 0);
                    course.enrolledStudents.add(this);
                    totalCredits += course.getCredits();
                } else if ((totalCredits + course.getCredits()) > 20) {
                    System.out.println("Cannot register. Course Credits Limit of 20 exceeded");
                } else {
                    System.out.println("Cannot register. Course is for semester " + course.semester + " but user is in semester " + this.semester);
                }
            }
        } else {
            System.out.println("Course not found");
        }
    }
    @Override

    public void dropCourse(int courseCode) {
        boolean found = false;
        Course course = CourseInventory.courseMap.get(courseCode);

        if (course == null) {
            System.out.println("Course not found");
            return;
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate dropDeadline = Administrator.dropDeadline;
        try{
            if (currentDate.isAfter(dropDeadline)) {
                if (currentDate.isAfter(dropDeadline)) {
                    throw new DropDeadlinePassedException("DropDeadlinePassedException");
                }
            }
        }catch(DropDeadlinePassedException e){
            System.out.println(e.getMessage());
            return;
        }


        for (Course c : enrollCourses) {
            if (c.getCourseCode() == courseCode) {
                System.out.println("Course dropped: " + c.getTitle());
                found = true;
                enrollCourses.remove(c);
                break;
            }
        }

        if (!found) {
            System.out.println("Course not found");
        }
    }

    @Override
    public void viewSchedule(){
        System.out.println("Enrolled Courses Timings :");
        for (Course course : enrollCourses) {
            System.out.println(course.getTitle()+"->"+course.getTimings());
        }
    }


    @Override
    public void trackProgress() {
        ArrayList<Integer> sgpa = new ArrayList<>();
        int totalCredits = 0;
        int totalGradePoints = 0;

        for (int sem = 1; sem <= this.semester; sem++) {
            for (Course course : enrollCourses) {
                if (course.semester == sem) {
                    Integer grade = marks.get(course.getTitle());
                    if (grade != null) {
                        totalCredits += course.getCredits();
                        totalGradePoints += grade * course.getCredits();
                    }
                }
            }
            if (totalCredits > 0) {
                int SGPA = totalGradePoints / totalCredits;
                sgpa.add(SGPA);
                totalCredits = 0;
                totalGradePoints = 0;
            }
        }
        for (int i = 0; i < sgpa.size(); i++) {
            System.out.println("Semester " + (i + 1) + " SGPA: " + sgpa.get(i));
        }
        double CGPA = 0;
        for (int i = 0; i < sgpa.size(); i++) {
            CGPA += sgpa.get(i);
        }
        if (!sgpa.isEmpty()) {
            CGPA /= sgpa.size();
        }
        System.out.println("CGPA: " + CGPA);
    }

    @Override
    public Course getCourse(String courseCode) {
        return CourseInventory.courseMap.get(courseCode);
    }
    @Override
    public void submitComplaint(String description,String student_name) {
        System.out.println("user submitted complaint: " + description);
        ComplaintInventory.complaints.add(new Complaint(description, this.getName()));
    }

    @Override
    public void viewComplaintStatus() {
        System.out.println("Complaint Status:");
        for (Complaint complaint : ComplaintInventory.complaints){
            System.out.println("Student Name: "+complaint.Student_name+"->"+complaint.getStatus());
        }
    }

    @Override
    public void submit_Feedback(String description, String name, int course_Code) {
        Boolean student_available = false;
        Boolean course_completed_by_Student = false;
        Boolean course_enrolled = false;
        for (Course course : enrollCourses) {
            if (course.getCourseCode() == course_Code) {
                course_enrolled = true;
                break;
            }
        }


        for (Student student : User.students) {
            if (student.getName().equals(name)) {
                student_available = true;
                for (Course course : student.completed_Courses) {
                    if (course.getCourseCode() == course_Code) {
                        course_completed_by_Student = true;
                        break;
                    }
                }
            }
        }

        if (student_available && course_completed_by_Student) {
            Feedback<String> feedback = new Feedback<>(description , name, course_Code);
            FeedbackInventory.feedbacks.add(feedback);
            System.out.println("Feedback submitted successfully.");
        } else if (!student_available) {
            System.out.println("user not found.");

        }else if (!course_enrolled) {
            System.out.println("Course not enrolled");

        }
        else if (!course_completed_by_Student) {
            System.out.println("user has not completed the course.");
        }
    }

    @Override
    public void submit_Feedback(int rating, String name, int course_code) {
        Boolean student_available = false;
        Boolean course_completed_by_Student = false;
        Boolean course_enrolled = false;
        for (Course course : enrollCourses) {
            if (course.getCourseCode() == course_code) {
                course_enrolled = true;
                break;
            }
        }

        for (Student student : User.students) {
            if (student.getName().equals(name)) {
                student_available = true;
                for (Course course : student.completed_Courses) {
                    if (course.getCourseCode() == course_code) {
                        course_completed_by_Student = true;
                        break;
                    }
                }
            }
        }

        if (student_available && course_completed_by_Student) {
            Feedback<Integer> feedback = new Feedback<>(rating, name, course_code);
            FeedbackInventory.feedbacks.add(feedback);
            System.out.println("Feedback submitted successfully.");
        } else if (!student_available) {
            System.out.println("user not found.");

        }else if (!course_enrolled) {
            System.out.println("Course not enrolled");

        }
        else if (!course_completed_by_Student) {
            System.out.println("user has not completed the course.");
        }
    }
}







