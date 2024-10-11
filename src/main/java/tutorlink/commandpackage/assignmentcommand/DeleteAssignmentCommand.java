package tutorlink.commandpackage.assignmentcommand;

import tutorlink.listpackage.AssignmentList;
import tutorlink.listpackage.ItemList;
import tutorlink.assignmentpackage.Assignment;

public class DeleteAssignmentCommand extends AssignmentCommand{
    public DeleteAssignmentCommand(Assignment assignment) {
        super(assignment);
    }


    @Override
    public void execute(ItemList list) {
        if (list instanceof AssignmentList) {
            ((AssignmentList) list).deleteAssignment(assignment);
        } else {
            throw new IllegalArgumentException("Invalid list type. Expected AssignmentList.");
        }
    }
}
