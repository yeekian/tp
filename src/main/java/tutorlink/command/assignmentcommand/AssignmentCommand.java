package tutorlink.command.assignmentcommand;

import tutorlink.assignment.Assignment;
import tutorlink.command.Command;

import java.util.ArrayList;

public abstract class AssignmentCommand extends Command {
    protected Assignment assignment;

    public AssignmentCommand(Assignment assignment) {
        this.assignment = assignment;
    }

    public abstract void execute(ArrayList assignmentList);

    public boolean isExit() {
        return false;
    }
}
