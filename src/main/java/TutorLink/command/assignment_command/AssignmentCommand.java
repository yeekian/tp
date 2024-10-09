package TutorLink.command.assignment_command;

import TutorLink.assignment.Assignment;
import TutorLink.command.Command;

import java.util.ArrayList;

abstract public class AssignmentCommand extends Command {
    private Assignment assignment;

    public AssignmentCommand(Assignment assignment) {
        this.assignment = assignment;
    }

    public abstract void execute(ArrayList assignmentList);

    public boolean isExit() {
        return false;
    }
}
