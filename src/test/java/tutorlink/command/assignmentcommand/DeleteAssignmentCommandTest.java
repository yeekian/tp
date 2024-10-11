package tutorlink.command.assignmentcommand;

import org.junit.jupiter.api.Test;
import tutorlink.assignment.Assignment;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DeleteAssignmentCommandTest {
    @Test
    void execute_deleteOne_expectZero() {
        // setup
        ArrayList<Assignment> assignmentList = new ArrayList<>();
        Assignment assignment1 = new Assignment("Test_1",100,100,0.2);
        assignmentList.add(assignment1);
        DeleteAssignmentCommand deleteAssignmentCommand = new DeleteAssignmentCommand(assignment1);
        // execute
        deleteAssignmentCommand.execute(assignmentList);
        assertTrue(assignmentList.isEmpty());
    }
}
