package tutorlink.parser;

import org.junit.jupiter.api.Test;
import tutorlink.appstate.AppState;
import tutorlink.command.AddStudentCommand;
import tutorlink.command.Command;
import tutorlink.command.DeleteStudentCommand;
import tutorlink.command.ExitCommand;
import tutorlink.command.FindStudentCommand;
import tutorlink.command.InvalidCommand;
import tutorlink.command.ListStudentCommand;
import tutorlink.exceptions.IllegalValueException;
import tutorlink.result.CommandResult;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

import tutorlink.parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;


public class ParserTest {



    @Test
    void  getCommand_addStudentCommand_addStudentCommandReturned() {

        Parser parser = new Parser();
        String input = "add_student i/A1234567X n/John";
        Command actualCommand = parser.getCommand(input);

        assertEquals(new AddStudentCommand() ,actualCommand);
    }

    @Test
    void  getCommand_deleteStudentCommand_deleteStudentCommandReturned() {
        Parser parser = new Parser();
        String input = "delete_student i/A1234567X";
        Command actualCommand = parser.getCommand(input);

        assertEquals(new DeleteStudentCommand() ,actualCommand);
    }

    @Test
    void  getCommand_exitCommand_exitCommandReturned() {
        Parser parser = new Parser();
        String input = "bye";
        Command actualCommand = parser.getCommand(input);

        assertEquals(new ExitCommand() ,actualCommand);
    }

    @Test
    void  getCommand_listStudentCommand_listStudentCommandReturned() {
        Parser parser = new Parser();
        String input = "list_student";
        Command actualCommand = parser.getCommand(input);

        assertEquals(new ListStudentCommand() ,actualCommand);
    }

    @Test
    void  getCommand_findStudentCommand_findStudentCommandReturned() {
        Parser parser = new Parser();
        String input = "find_student i/A1234567X n/John";
        Command actualCommand = parser.getCommand(input);

        assertEquals(new FindStudentCommand() ,actualCommand);
    }

    @Test
    void  getCommand_invalidCommand_invalidCommandReturned() {
        Parser parser = new Parser();
        String input = "test_input";
        Command actualCommand = parser.getCommand(input);

        assertEquals(new InvalidCommand() ,actualCommand);
    }
}