package tutorlink.command.assignmentcommand;

import tutorlink.assignment.Assignment;

import java.util.ArrayList;

public class AddAssignmentCommand extends AssignmentCommand {
    public AddAssignmentCommand(Assignment assignment) {
        super(assignment);
    }

    @Override
    public void execute(ArrayList assignmentList) {
        assignmentList.add(assignment);
    }
}
