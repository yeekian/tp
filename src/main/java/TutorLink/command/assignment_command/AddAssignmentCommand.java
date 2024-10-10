package TutorLink.command.assignment_command;

import TutorLink.list.List;
import tutorlink.assignment.Assignment;

import java.util.ArrayList;

public class AddAssignmentCommand extends AssignmentCommand {
    public AddAssignmentCommand(Assignment assignment) {
        super(assignment);
    }

    @Override
    public void execute(List list) {

    }

    @Override
    public boolean isExit() {
        return false;
    }
}
