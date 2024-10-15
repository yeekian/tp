package tutorlink.commandpackage;

import tutorlink.exceptionspackage.ItemNotFoundException;
import tutorlink.listpackage.CourseList;
import tutorlink.resultpackage.CommandResult;

public class DeleteCourseCommand extends Command {
    public static final String COMMAND_WORD = "delete_course";
    public static final String REGEX = "^delete_course i/(A\\d{7}[A-Z]) " +
            "c/([A-Z]{2,3}\\d{4})";

    private static final String SUCCESS_MESSAGE = "Course %s successfully deleted from student " +
            "(Matric Number: %s)";
    private String matricNumber;
    private String courseID;
    private String courseMCs;
    public DeleteCourseCommand(String matricNumber, String courseID) {
        this.courseID = courseID;
        this.matricNumber = matricNumber;
    }

    @Override
    public CommandResult execute() {
        try{
            CourseList courseList = students.getStudent(this.matricNumber).courses;
            courseList.dropCourse(this.courseID);
            return new CommandResult(String.format(SUCCESS_MESSAGE,this.courseID,this.matricNumber));
        } catch (ItemNotFoundException e) {
            return new CommandResult(e.getMessage());
        }
    }
}
