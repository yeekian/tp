package TutorLink.commandpackage.AssignmentCommand;

import TutorLink.commandpackage.Command;
import tutorlink.assignment.Assignment;

public abstract class AssignmentCommand extends Command {
    private Assignment assignment;

    public AssignmentCommand(Assignment assignment) {
        this.assignment = assignment;
    }

    public boolean isExit() {
        return false;
    }
}
