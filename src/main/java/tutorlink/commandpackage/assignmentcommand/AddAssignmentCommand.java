package TutorLink.commandpackage.AssignmentCommand;

import tutorlink.assignment.Assignment;
import TutorLink.listpackage.ItemList;

public class AddAssignmentCommand extends AssignmentCommand {
    public AddAssignmentCommand(Assignment assignment) {
        super(assignment);
    }

    @Override
    public void execute(ItemList list) {

    }

    @Override
    public boolean isExit() {
        return false;
    }
}
