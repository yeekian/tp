package TutorLink.coursepackage;

import TutorLink.listpackage.AssignmentList;
import TutorLink.listpackage.AttendanceList;
import tutorlink.assignment.Assignment;
import tutorlink.course.LetterGrade;

public class Course {
    private String courseID;
    private int courseMCs;
    private LetterGrade grade;
    AssignmentList assignments;
    AttendanceList attendances;


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
