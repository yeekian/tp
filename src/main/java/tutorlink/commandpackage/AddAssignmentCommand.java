package tutorlink.commandpackage;

import tutorlink.assignmentpackage.Assignment;
import tutorlink.coursepackage.Course;
import tutorlink.exceptionspackage.ItemNotFoundException;
import tutorlink.resultpackage.CommandResult;

public class AddAssignmentCommand extends Command{
    public static final String COMMAND_WORD = "add_assignment";
    public static final String FORMAT_ERROR_MESSAGE = "Error, expected format: "
            + COMMAND_WORD + " i/MATRIC NUMBER " + "c/COURSE_ID " + "n/ASSIGNMENT_DESCRIPTION "
            + "s/RECEIVED_SCORE " + "t/TOTAL_SCORE " + "w/WEIGHTING";
    public static final String REGEX = "add_assignment\\s+i/(A\\d{7}[A-Z])\\s+c/([A-Z]{2,3}\\d{4})\\s+n/([\\s\\S]+?)" +
            "\\s+s/(\\d+(\\.\\d+)?)\\s+t/(\\d+(\\.\\d+)?)\\s+w/(\\d+(\\.\\d+)?)";
    public static final String INVALID_WEIGHTING_MESSAGE = "Error! Weighting must be 0 < w < 1";

    private static final String SUCCESSFUL_MESSAGE = "Assignment (Description: %s, Score: %s/%s) added successfully "
            + "to Course %s for student (Matric Number: %s)";
    private String matricNumber;
    private String courseID;
    private String assignmentDescription;
    private double receivedScore;
    private double totalScore;
    private double weighting;

    public AddAssignmentCommand(String matricNumber, String courseID, String assignmentDescription,
                            double receivedScore, double totalScore, double weighting) {
        this.matricNumber = matricNumber;
        this.courseID = courseID;
        this.assignmentDescription = assignmentDescription;
        this.receivedScore = receivedScore;
        this.totalScore = totalScore;
        this.weighting = weighting;
    }

    @Override
    public CommandResult execute() {
        try{
            Assignment assignment = new Assignment(this.assignmentDescription,
                    this.receivedScore, this.totalScore, this.weighting);
            Course course = students.getStudent(this.matricNumber).courses.getCourseByID(this.courseID);
            course.addAssignment(assignment);
            return new CommandResult(String.format(SUCCESSFUL_MESSAGE, this.assignmentDescription,
                    this.receivedScore, this.totalScore, this.courseID, this.matricNumber));
        } catch (ItemNotFoundException e) {
            return new CommandResult(e.getMessage());
        }
    }
}
