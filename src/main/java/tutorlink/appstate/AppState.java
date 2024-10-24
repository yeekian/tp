package tutorlink.appstate;

import tutorlink.lists.ComponentList;
import tutorlink.lists.GradeList;
import tutorlink.lists.StudentList;

public class AppState {
    public StudentList students = new StudentList();
    public GradeList grades = new GradeList();
    public ComponentList components = new ComponentList();
    public AppState() {
    }
}
