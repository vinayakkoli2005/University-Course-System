import java.util.*;
import java.time.LocalDate;


public class Administrator extends User {
    private static Map<String, String> AdminDatabase = new HashMap<>();



    public static LocalDate dropDeadline = LocalDate.now().plusDays(10);



    public Administrator(String name,String email,String password) {
        super(name, email, password);
        User.administrators.add(this);
    }

    @Override
    public void display() {
        System.out.println("Administrator: " + getName() + " " + getEmail() + " " + getPassword());
    }

    @Override
    public void login(String email, String password)  {
        if (password.equals("password")){
            System.out.println("Logging in as Administrator...");
            System.out.println(super.getName() + " logged in successfully");
        } else {
            System.out.println("Invalid email or password");
        }
    }

    @Override
    public void signUp(String email, String password) {
        AdminDatabase.put(email, password);
    }

    @Override
    public void logout() {

    }

    public void add_Course(int courseCode, String title, int credits ,int semester , String timings, String OfficeHrs, String Syllabus, int EnrollenmentLimit , ArrayList<String> prerequisites)  {
        Course course = new Course(courseCode, title, credits, semester, timings, OfficeHrs, Syllabus, EnrollenmentLimit, prerequisites);
        CourseInventory.courses.add(course);
        CourseInventory.courseMap.put(course.getCourseCode(), course);
    }

    public void remove_Course(int courseCode) {
        Course course = CourseInventory.courseMap.get(courseCode);
        CourseInventory.courses.remove(course);
        CourseInventory.courseMap.remove(courseCode);
    }
    public void view_courses(){
        System.out.println("Courses:");
        for (Course course : CourseInventory.courses) {
            System.out.println(course.getTitle()+"->"+ course.getCourseCode());
        }
    }
    public void view_Student_Records(){
        System.out.println("Students:");
        for(Student student : User.students){
            System.out.println("Name:"+student.getName()+" Email:"+ student.getEmail());
        }
    }
    public void student_Marks(String title, String studentname, int grade){

        for(Student student : User.students) {
            if (student.getName().equalsIgnoreCase(studentname)) {
                student.marks.put(title, grade);
            } else{
                System.out.println("Student not found");
            }
        }
    }
    public void Assign_Proff_to_Course(String proff_name, int courseCode){
        boolean flag = false;
        for (Course course : CourseInventory.courses) {
            if (course.getCourseCode()==courseCode) {
                course.setProfessor(proff_name);
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Course not found or Proff not found");
        }
    }

    public void view_complaints(){
        System.out.println("Complaints:");
        for (Complaint complaint : ComplaintInventory.complaints){
            complaint.student_Name();
            System.out.println("->"+complaint.getDescription());
        }
    }
    public void update_complaint_status(Complaint complaint){
        complaint.setStatus("Resolved");

    }
    public void filter_complaints(){
        System.out.println("Resolved Complaints:");
        for (Complaint complaint : ComplaintInventory.complaints){
            if(complaint.getStatus().equals("Resolved")){
                complaint.student_Name();
                System.out.println("->"+complaint.getDescription());
            }
        }
        System.out.println("Pending Complaints:");
        for (Complaint complaint : ComplaintInventory.complaints){
            if(complaint.getStatus().equals("Pending")){
                complaint.student_Name();
                System.out.println("->"+complaint.getDescription());
            }
        }
    }

    public void Assign_TA_to_Course(String TA_name, int courseCode){
        boolean flag = false;
        for (Course course : CourseInventory.courses) {
            if (course.getCourseCode()==courseCode) {
                for(TA ta : User.TA) {
                    if (ta.getName().equalsIgnoreCase(TA_name)) {
                        course.TAs.add(ta);
                        ta.course_Title = course.getTitle();
                        flag = true;
                        System.out.println(TA_name+"->  assigned to course "+ course.getTitle());
                        break;
                    }
                }
            }
        }
        if (!flag){
            System.out.println("Course not found or TA not found");
        }
    }

}