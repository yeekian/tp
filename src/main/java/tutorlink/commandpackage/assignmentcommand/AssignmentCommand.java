package tutorlink.commandpackage.assignmentcommand;

import tutorlink.commandpackage.Command;
import tutorlink.assignmentpackage.Assignment;

public abstract class AssignmentCommand extends Command {
    private Assignment assignment;

    public AssignmentCommand(Assignment assignment) {
        this.assignment = assignment;
    }

    public boolean isExit() {
        return false;
    }
}
