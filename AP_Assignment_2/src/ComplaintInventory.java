import java.util.*;
public class ComplaintInventory {
    static List<Complaint> complaints = new ArrayList<>();

    public ComplaintInventory(){

    }

    public void submitComplaint(String student_Name,String description) {
        Complaint complaint = new Complaint(description, student_Name);
        complaints.add(complaint);
        System.out.println("Complaint submitted successfully.");
    }

    public void viewComplaintStatus(Student student) {
        student.viewComplaintStatus();
    }

    public void HandleComplaint(String complaintId, Student student) {

    }
}
