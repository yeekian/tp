package tutorlink.command.assignmentcommand;

import org.junit.jupiter.api.Test;
import tutorlink.assignmentpackage.Assignment;
import tutorlink.commandpackage.assignmentcommand.AddAssignmentCommand;
import tutorlink.commandpackage.assignmentcommand.DeleteAssignmentCommand;
import tutorlink.listpackage.AssignmentList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DeleteAssignmentCommandTest {
    @Test
    void execute_deleteOne_expectZero() {
        // setup
        AssignmentList assignmentList = new AssignmentList();
        Assignment assignment1 = new Assignment("Test 1",100,100,0.2);
        AddAssignmentCommand addAssignmentCommand = new AddAssignmentCommand(assignment1);
        addAssignmentCommand.execute(assignmentList);

        DeleteAssignmentCommand deleteAssignmentCommand = new DeleteAssignmentCommand(assignment1);
        // execute
        deleteAssignmentCommand.execute(assignmentList);
        assertTrue(assignmentList.getAssignmentArrayList().isEmpty());
    }
}
