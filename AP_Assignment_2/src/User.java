import java.util.ArrayList;

public abstract class User implements ComplaintInterface {
    public String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public abstract void display();
    public abstract void login(String email, String password);
    public abstract void signUp(String email, String password);

    public abstract void logout();

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void add_database(String email, String password){
    }
    public void submitComplaint(String Student_name,String description) {}
    public void viewComplaintStatus(){}
    public void HandleComplaint(){}


    static ArrayList<Student> students = new ArrayList<Student>();
    static ArrayList<Professor> professors = new ArrayList<Professor>();
    static ArrayList<Administrator> administrators = new ArrayList<Administrator>();
    static ArrayList<TA> TA = new ArrayList<TA>();

    public void submit_Feedback(String description,String name,int courese_Code) {}

    public void submit_Feedback(int rating, String name,int course_code) {
    }

    public void viewFeedback(String name) {}
}
