package tutorlink.command.assignmentcommand;

import org.junit.jupiter.api.Test;
import tutorlink.assignmentpackage.Assignment;
import tutorlink.commandpackage.assignmentcommand.AddAssignmentCommand;
import tutorlink.listpackage.AssignmentList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AddAssignmentCommandTest {
    @Test
    void execute_addOne_expectOne() {
        // setup
        AssignmentList assignmentList = new AssignmentList();
        Assignment assignment1 = new Assignment("Test_1",100,100,0.2);
        AddAssignmentCommand addAssignmentCommand = new AddAssignmentCommand(assignment1);
        // execute
        addAssignmentCommand.execute(assignmentList);
        assertFalse(assignmentList.getAssignmentArrayList().isEmpty());
        assertEquals(1, assignmentList.getAssignmentArrayList().size());
        assertEquals(assignment1, assignmentList.getAssignmentArrayList().get(0));
    }
}
