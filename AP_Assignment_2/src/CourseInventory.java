import java.util.*;
public class CourseInventory {
    static List<Course> courses = new ArrayList<>();
    public static  Map<Integer, Course> courseMap=new HashMap<>();
    public CourseInventory() {
        courses = new ArrayList<>();
        courseMap = new HashMap<>();
    }

    public void viewAvailableCourses(Student student) {
        student.viewAvailableCourses();
    }
    public void registerForCourse(int courseCode,Student student){
        student.registerForCourse(courseCode);
    }

    public void dropCourse(int courseCode,Student student) {
        student.dropCourse(courseCode);
    }

    public void viewSchedule(Student student) {
        student.viewSchedule();
    }

    public void trackProgress(Student student) {
        student.trackProgress();
    }
}
