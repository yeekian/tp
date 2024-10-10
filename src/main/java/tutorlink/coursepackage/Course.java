package tutorlink.coursepackage;

import tutorlink.listpackage.AssignmentList;
import tutorlink.listpackage.AttendanceList;
import tutorlink.assignmentpackage.Assignment;

public class Course {
    private String courseID;
    private int courseMCs;
    private LetterGrade grade;
    private AssignmentList assignments;
    private AttendanceList attendances;


    public Course(String courseID, int courseMCs) {
        this.courseID = courseID;
        this.courseMCs = courseMCs;
        assignments = new AssignmentList();
        attendances = new AttendanceList();
    }

    public void addAssignment(Assignment assignment) {
        assignments.addAssignment(assignment);
    }

    public void deleteAssignment(Assignment assignment) {
        assignments.deleteAssignment(assignment);
    }
}
