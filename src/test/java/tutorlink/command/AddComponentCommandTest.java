//@@author yeekian
package tutorlink.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tutorlink.appstate.AppState;
import tutorlink.result.CommandResult;


import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void execute_addOne_expectOne() {
        arguments.put("c/","Quiz 1");
        arguments.put("w/","0.3");
        arguments.put("m/","100");
        CommandResult result = command.execute(appState, arguments);
        assertNotNull(result);
        assertEquals("Component Quiz 1 of weight 0.3, with max score 100 added successfully!", result.toString());
        assertEquals(1, appState.components.getComponentArrayList().size());
    }
}
//@@author
