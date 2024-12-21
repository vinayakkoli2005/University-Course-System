import java.util.*;
public class TA extends  Student {

    String course_Title = null;

    static Map<String, String> TA_Database = new HashMap<>();


    public TA(String name, String email, String password, int semester) {
        super(name, email, password, semester);
        User.TA.add(this);
    }

    @Override
    public void signUp(String email, String password) {

        System.out.println("Signing up as TA...");
        if (!TA_Database.containsKey(email)) {
            TA_Database.put(email, password);
            System.out.println(super.getName() + " has successfully signed up with email: " + email);

        } else {
            System.out.println("Email already exists");
            login(email, password);
        }
    }


    @Override
    public void login(String email, String password) {
        // Check if the email exists and password matches
        System.out.println("Logging in as TA...");
        System.out.println("finding your email and password in the database...");

        if (TA_Database.containsKey(email) && TA_Database.get(email).equals(password)) {
            System.out.println(super.getName() + " logged in successfully");
        } else {
            System.out.println("Invalid email or password");
            signUp(email, password);
        }
    }


    public String getCourseTitle() {
        return course_Title;
    }

    public void view_Student_Records() {
        System.out.println("Students:");
        for (Student student : User.students) {
            System.out.println("Name:" + student.getName() + " Email:" + student.getEmail());
        }
    }

    public void student_Marks(String title, String studentname, int grade, TA ta) {

        for (Course course : CourseInventory.courses) {
            if (course.getTitle().equalsIgnoreCase(title) && ta.getCourseTitle().equalsIgnoreCase(title)) {
                for (Student student : User.students) {
                    if (student.getName().equalsIgnoreCase(studentname)) {
                        student.marks.put(course.getTitle(), grade);
                        System.out.println("Grade updated for " + student.getName());
                        break;
                    }
                }
            }
        }
    }

    public void view_Course(TA ta) {
        System.out.println("Assigned Courses:");
        System.out.println(ta.getCourseTitle());
    }

    public void viewEnrolledStudents(TA ta) {


        System.out.println("Enrolled Students:");
        String title = ta.getCourseTitle();
        if(title == null){
            System.out.println("No courses assigned");
            return;
        }else{
            for (Course course : CourseInventory.courses) {
                if (course.getTitle().equalsIgnoreCase(title)) {
                    for(Student s: course.enrolledStudents) {
                        System.out.println("name : "+s.getName()+"  email : "+ s.getEmail());
                    }
                }
            }
        }
    }

    @Override
    public void viewAvailableCourses() {
        super.viewAvailableCourses();
    }

    @Override
    public void registerForCourse(int courseCode){
        super.registerForCourse(courseCode);
    }
    @Override
    public void trackProgress() {
        super.trackProgress();
    }
}
