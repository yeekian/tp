//@@author yeekian
package tutorlink.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tutorlink.appstate.AppState;
import tutorlink.commons.Commons;
import tutorlink.exceptions.IllegalValueException;
import tutorlink.result.CommandResult;


import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddComponentCommandTest {
    private AppState appState;
    private HashMap<String, String> arguments;
    private AddComponentCommand command;

    @BeforeEach
    void setup() {
        appState = new AppState();
        arguments = new HashMap<>();
        command = new AddComponentCommand();
    }

    @Test
    void execute_validArguments_componentAddedSuccessfully() {
        arguments.put("c/", "Quiz 1");
        arguments.put("w/", "30");
        arguments.put("m/", "100");
        CommandResult result = command.execute(appState, arguments);
        assertNotNull(result);
        assertEquals("Component Quiz 1 of weight 30%, with max score 100 added successfully!", result.toString());
        assertEquals(1, appState.components.getComponentArrayList().size());
    }

    @Test
    void execute_nullArguments_throwsIllegalValueException() {
        IllegalValueException exception = assertThrows(IllegalValueException.class, () -> {
            command.execute(appState, arguments);
        });
        assertEquals("Error! Null parameter passed!", exception.getMessage());
    }

    @Test
    void execute_missingWeightageArgument_throwsIllegalValueException() {
        arguments.put("c/", "Quiz 1");
        arguments.put("m/", "100");

        IllegalValueException exception = assertThrows(IllegalValueException.class, () -> {
            command.execute(appState, arguments);
        });
        assertEquals("Error! Null parameter passed!", exception.getMessage());
    }

    @Test
    void execute_extraArgument_componentAddedSuccessfully() {
        arguments.put("c/", "Quiz 1");
        arguments.put("w/", "50");
        arguments.put("m/", "100");
        arguments.put("extra/", "extra value");

        CommandResult result = command.execute(appState, arguments);
        assertNotNull(result);
        assertEquals("Component Quiz 1 of weight 50%, with max score 100 added successfully!", result.toString());
        assertEquals(1, appState.components.getComponentArrayList().size());
    }

    @Test
    void execute_weightageOutOfRange_throwsIllegalValueException() {
        arguments.put("c/", "Quiz 1");
        arguments.put("w/", "1.5");
        arguments.put("m/", "100");

        IllegalValueException exception = assertThrows(IllegalValueException.class, () -> {
            command.execute(appState, arguments);
        });
        assertEquals(Commons.ERROR_INVALID_WEIGHTAGE, exception.getMessage());
    }

    @Test
    void execute_negativeMaxScore_throwsIllegalValueException() {
        arguments.put("c/", "Quiz 1");
        arguments.put("w/", "0.4");
        arguments.put("m/", "-10");

        IllegalValueException exception = assertThrows(IllegalValueException.class, () -> {
            command.execute(appState, arguments);
        });
        assertEquals(Commons.ERROR_INVALID_WEIGHTAGE, exception.getMessage());
    }

    @Test
    void execute_weightageNotDouble_throwsIllegalValueException() {
        arguments.put("c/", "Quiz 1");
        arguments.put("w/", "one");
        arguments.put("m/", "100");

        IllegalValueException exception = assertThrows(IllegalValueException.class, () -> {
            command.execute(appState, arguments);
        });
        assertEquals(Commons.ERROR_INVALID_WEIGHTAGE, exception.getMessage());
    }

    @Test
    void execute_maxScoreNotDouble_throwsIllegalValueException() {
        arguments.put("c/", "Quiz 1");
        arguments.put("w/", "0.4");
        arguments.put("m/", "hundred");

        IllegalValueException exception = assertThrows(IllegalValueException.class, () -> {
            command.execute(appState, arguments);
        });
        assertEquals(Commons.ERROR_INVALID_WEIGHTAGE, exception.getMessage());
    }
}
//@@author
