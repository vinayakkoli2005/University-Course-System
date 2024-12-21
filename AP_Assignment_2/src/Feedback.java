public class Feedback<T> {
    private T feedback;
    private String studentName;
    public static int course_Code;



    public Feedback(T feedback, String studentName, int course_Code) {
        this.feedback = feedback;
        this.studentName = studentName;
        this.course_Code = course_Code;
    }

    public T getFeedback() {
        return feedback;
    }



    public String getStudentName() {
        return studentName;
    }


}