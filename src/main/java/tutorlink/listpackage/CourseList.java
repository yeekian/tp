package tutorlink.listpackage;


import tutorlink.coursepackage.Course;

import java.util.ArrayList;

public class CourseList extends ItemList {
    private ArrayList<Course> courseArrayList;

    public CourseList() {
        this.courseArrayList = new ArrayList<>();
    }

    public void dropCourse(Course course) {
        this.courseArrayList.remove(course);
    }

    public void addCourse(Course course) {
        this.courseArrayList.add(course);
    }
}
