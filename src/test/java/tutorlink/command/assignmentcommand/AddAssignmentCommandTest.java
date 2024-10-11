package tutorlink.command.assignmentcommand;

import org.junit.jupiter.api.Test;
import tutorlink.assignment.Assignment;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AddAssignmentCommandTest {
    @Test
    void execute_addOne_expectOne() {
        // setup
        ArrayList<Assignment> assignmentList = new ArrayList<>();
        Assignment assignment1 = new Assignment("Test_1",100,100,0.2);
        AddAssignmentCommand addAssignmentCommand = new AddAssignmentCommand(assignment1);
        // execute
        addAssignmentCommand.execute(assignmentList);
        assertFalse(assignmentList.isEmpty());
        assertEquals(1, assignmentList.size());
        assertEquals(assignment1, assignmentList.get(0));
    }
}
