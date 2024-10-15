package tutorlink.commandpackage;

import tutorlink.exceptionspackage.ItemNotFoundException;
import tutorlink.listpackage.AssignmentList;
import tutorlink.listpackage.CourseList;
import tutorlink.resultpackage.CommandResult;

public class DeleteAssignmentCommand extends Command {
    public static final String COMMAND_WORD = "delete_assignment";
    public static final String REGEX =
            "^delete_assignment\\s+i/(A\\d{7}[A-Z])\\s+c/([A-Z]{2,3}\\d{4})\\s+n/([^s]+)";

    private static final String SUCCESS_MESSAGE = "Assignment %s successfully deleted from student "
            + "(Matric Number: %s), course: %s";

    private String matricNumber;
    private String courseID;
    private String assignmentDesc;

    public DeleteAssignmentCommand(String matricNumner, String courseID, String assignmentDesc) {
        this.matricNumber = matricNumner;
        this.courseID = courseID;
        this.assignmentDesc = assignmentDesc;
    }

    @Override
    public CommandResult execute() {
        try {
            CourseList courseList = students.getStudent(this.matricNumber).courses;
            AssignmentList assignmentList = courseList.getCourseByID(this.courseID).getAssignmentList();
            assignmentList.dropAssignmentByDesc(this.assignmentDesc);
            return new CommandResult(String.format(
                    SUCCESS_MESSAGE, this.assignmentDesc, this.matricNumber, this.courseID));
        } catch (ItemNotFoundException e) {
            return new CommandResult(e.getMessage());
        }
    }
}
