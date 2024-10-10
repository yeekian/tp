package TutorLink.command.assignment_command;

import TutorLink.command.Command;
import tutorlink.assignment.Assignment;

import java.util.ArrayList;

public abstract class AssignmentCommand extends Command {
    private Assignment assignment;

    public AssignmentCommand(Assignment assignment) {
        this.assignment = assignment;
    }

    public boolean isExit() {
        return false;
    }
}
