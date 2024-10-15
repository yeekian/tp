package tutorlink.commandpackage;

import tutorlink.coursepackage.Course;
import tutorlink.resultpackage.CommandResult;

public class ListAssignmentCommand extends Command{

    public static final String COMMAND_WORD = "list_assignment";
    public static final String FORMAT_ERROR_MESSAGE = "Error, expected format: " + COMMAND_WORD
            + " i/MATRIC_NUMBER" + " c/COURSE_ID";
    public static final String REGEX = "list_assignment\\s+i/(A\\d{7}[A-Z])\\s+c/([A-Z]{2,3}\\d{4})";
    private static final String SUCCESS_MESSAGE = "Here are your assignments:";
    private String matricNumber;
    private String courseID;

    public ListAssignmentCommand(String matricNumber, String courseID) {
        this.matricNumber = matricNumber;
        this.courseID = courseID;
    }

    @Override
    public CommandResult execute() {
        assert matricNumber != null;
        assert courseID != null;
        Course course = students.getStudent(this.matricNumber).courses.getCourse(this.courseID);
        return new CommandResult(SUCCESS_MESSAGE,course.getAssignments());
    }
}
