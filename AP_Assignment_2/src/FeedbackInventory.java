import java.util.*;
public class FeedbackInventory {
    static List<Feedback> feedbacks = new ArrayList<>();

    public FeedbackInventory() {}



    public static void viewFeedback() {
        System.out.println("Feedback:");
        for (Feedback<?> feedback : feedbacks) {
            System.out.println("Student Name: " + feedback.getStudentName() + "Course code : "+ feedback.course_Code +" -> "+ feedback.getFeedback());
        }
    }

    public void HandleFeedback(String feedbackId, Student student) {

    }
}