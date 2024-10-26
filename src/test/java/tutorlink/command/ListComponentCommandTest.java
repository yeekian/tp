package tutorlink.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tutorlink.appstate.AppState;
import tutorlink.component.Assignment;
import tutorlink.component.Exam;
import tutorlink.exceptions.DuplicateComponentException;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.result.CommandResult;

public class ListComponentCommandTest {

    private AppState appState;
    private ListComponentCommand command;

    @BeforeEach
    public void setUp() {
        appState = new AppState();
        command = new ListComponentCommand();
    }

    @Test
    void execute_emptyList_showsEmptyMessage() throws TutorLinkException {
        CommandResult result = command.execute(appState, new HashMap<>());
        assertEquals("No components found.", result.toString());
    }

    @Test
    void execute_nonEmptyList_showsAllComponents() throws TutorLinkException {
        appState.components.addComponent(new Assignment("Assignment 1", 50.0, 0.3));
        appState.components.addComponent(new Exam("Midterm", 100.0, 0.4));

        CommandResult result = command.execute(appState, new HashMap<>());

        String expected = """
                Here are your components:
                1: Assignment [name=assignment 1, maxScore=50.0, weight=0.3]
                \t2: Exam [name=midterm, maxScore=100.0, weight=0.4]""";
        assertEquals(expected, result.toString());
    }

    @Test
    void getArgumentPrefixes_returnsEmptyArray() {
        assertArrayEquals(new String[]{}, command.getArgumentPrefixes(),
                "ListComponentCommand should not take any arguments");
    }
}
