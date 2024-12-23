import java.util.*;
public class Course {

    private int courseCode;
    private String title;
    private String professor;
    private int credits;
    private List<String> prerequisites;
    private String timings;
    private String OfficeHrs;
    public int semester;
    private String Syllabus ;
    private int EnrollenmentLimit;
    public static ArrayList<Student> enrolledStudents = new ArrayList<Student>();
    public static ArrayList<TA> TAs = new ArrayList<TA>();


    Boolean completed= false;


    public Course(int courseCode, String title, int credits ,int semester , String timings, String OfficeHrs, String Syllabus, int EnrollenmentLimit , ArrayList<String> prerequisites) {


        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.prerequisites = new ArrayList<>();
        this.semester=semester;
        this.timings = timings;
        this.OfficeHrs = OfficeHrs;
        this.Syllabus = Syllabus;
        this.EnrollenmentLimit = EnrollenmentLimit;

    }


    public int getCourseCode() {
        return this.courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getProfessor() {
        return professor;
    }

    public int getCredits() {
        return credits;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public String getTimings() {
        return timings;
    }

    public void getOfficeHrs() {
        this.OfficeHrs=OfficeHrs;
    }

    public void addPrerequisite(String prerequisite) {
        prerequisites.add(prerequisite);
    }

    public List<String> getPrerequisite() {
        return prerequisites;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public void setTitle(String Title) {
        this.title = title;
    }

    public void setProfessor(String professor) {
        this.professor= professor;
    }

    public void setCredits(int credits) {
        this.credits= credits;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }



    public void setTimings(String timings) {
        this.timings= timings;
    }



    public void setSyllabus(String Syllabus) {
        this.Syllabus = Syllabus;
    }

    public String getSyllabus() {
        return Syllabus;
    }

    public void setEnrollenmentLimit(int EnrollenmentLimit) {
        this.EnrollenmentLimit = EnrollenmentLimit;
    }

    public int getEnrollenmentLimit() {
        return EnrollenmentLimit;
    }



    public void setPrerequisites(ArrayList<String> prerequisites) {
        this.prerequisites = prerequisites;
    }


    public void set_Office_Hrs(String offering) {
        this.OfficeHrs = offering;
    }

    public void set_Course_Details(int courseCode,String timings, String OfficeHrs, String Syllabus, int EnrollenmentLimit , ArrayList<String> prerequisites) {
        this.courseCode = courseCode;

        this.timings = timings;
        this.OfficeHrs = OfficeHrs;
        this.Syllabus = Syllabus;
        this.EnrollenmentLimit = EnrollenmentLimit;
        this.prerequisites = prerequisites;

    }

    void set_complete_Statues() {
        this.completed = true;
    }
    void get_complete_Statues() {
        if(this.completed) {
            System.out.println("Course Completed");
        }
        else {
            System.out.println("Course Not Completed");
        }
    }
}
