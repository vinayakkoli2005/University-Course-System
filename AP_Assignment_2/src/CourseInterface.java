public interface CourseInterface {
    void viewAvailableCourses();
    void registerForCourse(int courseCode);
    void dropCourse(int courseCode);
    void viewSchedule();
    void trackProgress();


    Course getCourse(String courseCode);
}
