public class Complaint {

    private String description;
    private String status;
    String Student_name;

    public Complaint(String description,String Student_name) {
        this.description = description;
        this.status = "Pending";
        this.Student_name = Student_name;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
    public void student_Name(){
        System.out.println(  Student_name);

    }
    public String getStudentName() {
        return Student_name;
    }
}
