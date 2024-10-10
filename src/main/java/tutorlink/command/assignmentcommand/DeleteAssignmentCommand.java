package tutorlink.command.assignmentcommand;

import tutorlink.assignment.Assignment;

import java.util.ArrayList;

public class DeleteAssignmentCommand extends AssignmentCommand{
    public DeleteAssignmentCommand(Assignment assignment) {
        super(assignment);
    }

    public void execute(ArrayList assignmentList) {
        assignmentList.remove(assignment);
    }
}
