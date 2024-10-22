package tutorlink.command;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tutorlink.appstate.AppState;
import tutorlink.exceptions.IllegalValueException;
import tutorlink.lists.StudentList;
import tutorlink.result.CommandResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindStudentCommandTest {
    private FindStudentCommand findCommand;
    private AddStudentCommand addCommand;
    private AppState appState;
    private StudentList mockStudentList;

    @BeforeEach
    void setUp() {
        findCommand = new FindStudentCommand();
        addCommand = new AddStudentCommand();
        appState = new AppState();
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("i/","A1234567X");
        arguments.put("n/", "John");
        addCommand.execute(appState, arguments);
        arguments.put("i/","A2234567X");
        arguments.put("n/", "Jon");
    }

    @Test
    void execute_find_by_matric_expect_one() {
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("i/","A1234567X");
        CommandResult result = findCommand.execute(appState,arguments);
        assertEquals(result.toString(), "1: John, matric no: A1234567X");
    }

    @Test
    void execute_find_by_matric_expect_none() {
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("i/","A1111111X");
        CommandResult result = findCommand.execute(appState,arguments);
        assertEquals(result.toString(), "");
    }

    @Test
    void execute_find_by_name_expect_two() {
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("n/","Jo");
        CommandResult result = findCommand.execute(appState,arguments);
        assertEquals(result.toString(), "1: John, matric no: A1234567X\n2: Jon, matric no: A2234567X");
    }

    @Test
    void execute_find_throw_error_both_void() {
        HashMap<String, String> arguments = new HashMap<>();
        try {
            CommandResult result = findCommand.execute(appState, arguments);
        } catch (IllegalValueException e) {
            assertEquals(e.getMessage(), "Error! Both parameters passed are null!");
        }

    }
}
