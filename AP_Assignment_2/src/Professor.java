import java.util.*;

public class Professor extends User{

    private static Map<String, String> ProffDatabase = new HashMap<>();

    public Professor(String name,String email,String password) {
        super(name, email, password);
        User.professors.add(this);
    }

    @Override
    public void display() {
        System.out.println("Professor: " + getName() + " " + getEmail() + " " + getPassword());
    }


    @Override
    public void login(String email, String password) {
        // Check if the email exists and password matches
        System.out.println("Logging in as professor...");
        System.out.println("finding your email and password in the database...");

        if (ProffDatabase.containsKey(email) && ProffDatabase.get(email).equals(password)) {
            System.out.println(super.getName() + " logged in successfully");
        } else {
            System.out.println("Invalid email or password");

        }
    }

    @Override
    public void signUp(String email, String password) {
        // Check if the email already exists in the database
        System.out.println("Signing up as professor...");
        if (!ProffDatabase.containsKey(email)) {
            ProffDatabase.put(email, password);  // Add new user to the database
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
        ProffDatabase.put(email, password);
    }
    void viewCourses(){
        System.out.println("Courses:");
        for (Course course : CourseInventory.courses) {
            if(course.getProfessor().equals(this.name)){
                System.out.println(course.getTitle()+" "+ course.getCourseCode());
            }
        }
    }
    public void viewEnrolledStudents(int course_code){
        System.out.println("Enrolled Students:");
        for (Course course : Student.enrollCourses){
            if(course.getCourseCode()==course_code){
                for(Student student : course.enrolledStudents){
                    System.out.println(student.getName()+" -> "+ student.getEmail());
                }
            }

        }
    }

                                       ArrayList<String> proffCourses = new ArrayList<>();
    void getcourses(){
        System.out.println("Courses:");
        for (Course course : CourseInventory.courses){
            if(course.getProfessor().equals(this.name)){
                proffCourses.add(course.getTitle());
                System.out.println(course.getTitle());
            }
        }
    }
    public void Assign_Student_Grades(String title, String studentEmail, int grade) {
        boolean studentFound = false;
        for (Student student : User.students) {
            if (student.getEmail().equalsIgnoreCase(studentEmail)) {
                student.marks.put(title, grade);
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("Student not found");
        }
    }
    public void updateSyllabus(int courseCode, String syllabus) {
        for (Course course : CourseInventory.courses) {
            if (course.getCourseCode()==courseCode) {
                course.setSyllabus(syllabus);
            }
        }
    }
    public void view_Syllabus(int corseCode) {
        for (Course course : CourseInventory.courses) {
            if (course.getCourseCode()==corseCode) {
                System.out.println("Syllabus: " + course.getSyllabus());
            }
        }
    }
    public void update_Credits(int Corsecode, int credits) {
        for (Course course : CourseInventory.courses) {
            if (course.getCourseCode()==Corsecode) {
                course.setCredits(credits);
            }
        }
    }
    public void update_Prerequisites(int corseCode, ArrayList<String>  prerequisites) {
        for (Course course : CourseInventory.courses) {
            if (course.getCourseCode()==corseCode) {
                course.setPrerequisites(prerequisites);
            }
        }
    }
    public void setEnrollenmentLimit(Course course, int enrollmentCapacity) {
        course.setEnrollenmentLimit(enrollmentCapacity);
    }
    public void update_Office_Hrs(Course course, String offering) {
        course.set_Office_Hrs(offering);
    }
    void update_Course_Details(int courseCode,String timings, String OfficeHrs, String Syllabus, int EnrollenmentLimit , ArrayList<String> prerequisites) {
        for (Course course : CourseInventory.courses){
            if(course.getCourseCode()==courseCode) {
                course.set_Course_Details(courseCode, timings, OfficeHrs, Syllabus, EnrollenmentLimit, prerequisites);

            }
        }

    }


}