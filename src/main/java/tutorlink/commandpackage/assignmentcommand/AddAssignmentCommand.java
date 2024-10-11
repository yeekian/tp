package tutorlink.commandpackage.assignmentcommand;

import tutorlink.assignmentpackage.Assignment;
import tutorlink.listpackage.AssignmentList;
import tutorlink.listpackage.ItemList;

public class AddAssignmentCommand extends AssignmentCommand {
    public AddAssignmentCommand(Assignment assignment) {
        super(assignment);
    }

    public void execute(ItemList list) {
        if (list instanceof AssignmentList) {
            ((AssignmentList) list).addAssignment(assignment);
        } else {
            throw new IllegalArgumentException("Invalid list type. Expected AssignmentList.");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
