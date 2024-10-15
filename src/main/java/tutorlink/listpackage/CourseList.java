package tutorlink.listpackage;

import tutorlink.coursepackage.Course;
import java.util.ArrayList;

public class CourseList extends ItemList {
    private ArrayList<Course> courseArrayList;

    public CourseList() {
        this.courseArrayList = new ArrayList<>();
    }

    public void dropCourse(String courseID) {
        Course courseToRemove = null;
        for (Course course : this.courseArrayList) {
            if (course.getCourseID().equals(courseID)) {
                courseToRemove = course;
            }
        }
        if(courseToRemove != null) {
            courseArrayList.remove(courseToRemove);
        }
    }

    public void addCourse(Course course) {
        this.courseArrayList.add(course);
    }

    public ArrayList<Course> getCourseArrayList() {
        return courseArrayList;
    }
}
