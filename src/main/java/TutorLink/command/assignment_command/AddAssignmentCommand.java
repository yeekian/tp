package TutorLink.command.assignment_command;

import TutorLink.assignment.Assignment;

import java.util.ArrayList;

public class AddAssignmentCommand extends AssignmentCommand {
    public AddAssignmentCommand(Assignment assignment) {
        super(assignment);
    }

    @Override
    public void execute(ArrayList assignmentList) {

    }

    @Override
    public boolean isExit() {
        return false;
    }
}
