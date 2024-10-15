package tutorlink.commandpackage;

import tutorlink.coursepackage.Course;
import tutorlink.exceptionspackage.ItemNotFoundException;
import tutorlink.listpackage.CourseList;
import tutorlink.resultpackage.CommandResult;

public class AddAssignmentCommand {
    /*
    public static final String COMMAND_WORD = "add_assignment";
    public static final String FORMAT_ERROR_MESSAGE = "Error, expected format: "
            + COMMAND_WORD + " i/MATRIC NUMBER " + "c/COURSE_ID " + "n/ASSIGNMENT_DESCRIPTION "
            + "s/RECEIVED_SCORE " + "t/TOTAL_SCORE";
    public static final String REGEX = "^add_course i/(A\\d{7}[A-Z]) " +
            "m/(\\d*[2468])$";

    private static final String SUCCESSFUL_MESSAGE = "Course (%s) added successfully to student " +
            "(Matric Number: %s)";
    private String matricNumber;
    private String courseID;
    private int courseMCs;

    public AddCourseCommand(String matricNumber, String courseID, int courseMCs) {
        this.matricNumber = matricNumber;
        this.courseID = courseID;
        this.courseMCs = courseMCs;
    }

    @Override
    public CommandResult execute() {
        try{
            Course course = new Course(this.courseID, this.courseMCs);
            CourseList courseList = students.getStudent(this.matricNumber).courses;
            courseList.addCourse(course);
            return new CommandResult(String.format(SUCCESSFUL_MESSAGE,course,this.matricNumber));
        } catch (ItemNotFoundException e) {
            return new CommandResult(e.getMessage());
        }
    }

     */
}
