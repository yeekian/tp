//@@author RCPilot1604
package tutorlink.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tutorlink.appstate.AppState;
import tutorlink.exceptions.IllegalValueException;
import tutorlink.exceptions.StudentNotFoundException;
import tutorlink.result.CommandResult;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class DeleteStudentCommandTest {
    private DeleteStudentCommand deleteCommand = new DeleteStudentCommand();
    private AddStudentCommand addCommand = new AddStudentCommand();
    private AppState appState;
    private HashMap<String, String> arguments = new HashMap<>();
    private CommandResult result;

    @BeforeEach
    void setup() {
        appState = new AppState();
        arguments.put("i/","A1234567X");
        arguments.put("n/","John Doe");
        result = addCommand.execute(appState, arguments);
        assertNotNull(result);
        arguments.clear();
        arguments.put("i/","A7654321B");
        arguments.put("n/","Jane Smith");
        result = addCommand.execute(appState, arguments);
        assertNotNull(result);
        arguments.put("i/","A2468102C");
        arguments.put("n/","Arthur Mueller");
        result = addCommand.execute(appState, arguments);
        assertNotNull(result);
    }

    @Test
    void execute_delete_success() {
        arguments.clear();
        arguments.put("i/","A1234567X");
        result = deleteCommand.execute(appState, arguments);
        assertNotNull(result);
        assertEquals(result.message, "Student A1234567X successfully deleted");
        assertEquals(appState.students.getStudentArrayList().size(), 2);
        arguments.clear();
        arguments.put("i/","A7654321B");
        result = deleteCommand.execute(appState, arguments);
        assertNotNull(result);
        assertEquals(result.message, "Student A7654321B successfully deleted");
        assertEquals(appState.students.getStudentArrayList().size(), 1);
    }

    @Test
    void execute_delete_matricNull() {
        arguments.clear();
        arguments.put("n/","John Doe");
        try {
            result = deleteCommand.execute(appState, arguments);
        } catch (IllegalValueException e) {
            assertEquals(e.getMessage(), DeleteStudentCommand.ERROR_MATRIC_NUMBER_NULL);
        } catch (Exception e) {
            fail("Expected: IllegalValueException, Actual: " + e.getMessage());
        }
    }

    @Test
    void execute_delete_studentNotFound() {
        arguments.clear();
        arguments.put("i/","A9999999X");
        try {
            result = deleteCommand.execute(appState, arguments);
        } catch (StudentNotFoundException e) {
            assertEquals(e.getMessage(), String.format(DeleteStudentCommand.STUDENT_NOT_FOUND, "A9999999X"));
        }
    }
}
//@@author