package tutorlink.commandpackage.assignmentcommand;

import tutorlink.assignmentpackage.Assignment;
import tutorlink.listpackage.ItemList;

public class AddAssignmentCommand extends AssignmentCommand {
    public AddAssignmentCommand(Assignment assignment) {
        super(assignment);
    }

    public void execute(ItemList list) {

    }

    @Override
    public boolean isExit() {
        return false;
    }
}
