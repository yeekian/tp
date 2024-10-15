package tutorlink.listpackage;

import org.junit.jupiter.api.Test;
import tutorlink.commandpackage.Command;
import tutorlink.parserpackage.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddDeleteStudentTest {

    @Test
    public void addStudentCommand_nonEmptyMatricNumberAndGPA_success() throws Exception {
        Parser parser = new Parser();
        assertEquals(0, Command.getStudentList().getNumberOfStudents());
        Command addStudentCommand = parser.addStudentCommand("add_student n/John i/A1234567X");

        addStudentCommand.execute();
        assertEquals(1, Command.getStudentList().getNumberOfStudents());
    }

    @Test
    public void deleteStudentCommand_onlyName_success() throws Exception {
        Parser parser = new Parser();
        assertEquals(0, Command.getStudentList().getNumberOfStudents());
        Command addStudentCommand = parser.addStudentCommand("add_student n/John i/A1234567X");

        addStudentCommand.execute();
        assertEquals(1, Command.getStudentList().getNumberOfStudents());

        //Test single name delete
        Command deleteStudentCommand = parser.deleteStudentCommand("delete_student n/John");

        deleteStudentCommand.execute();
        assertEquals(0, Command.getStudentList().getNumberOfStudents());

    }

    @Test
    public void deleteStudentCommand_onlyMatricNumber_success() throws Exception {
        Parser parser = new Parser();
        assertEquals(0, Command.getStudentList().getNumberOfStudents());
        Command addStudentCommand = parser.addStudentCommand("add_student n/John i/A1234567X");

        addStudentCommand.execute();
        assertEquals(1, Command.getStudentList().getNumberOfStudents());

        //Test single name delete
        Command deleteStudentCommand = parser.deleteStudentCommand("delete_student i/A1234567X");

        deleteStudentCommand.execute();
        assertEquals(0, Command.getStudentList().getNumberOfStudents());

    }

    @Test
    public void deleteStudentCommand_both_success() throws Exception {
        Parser parser = new Parser();
        assertEquals(0, Command.getStudentList().getNumberOfStudents());
        Command addStudentCommand = parser.addStudentCommand("add_student n/John i/A1234567X");

        addStudentCommand.execute();
        assertEquals(1, Command.getStudentList().getNumberOfStudents());

        //Test single name delete
        Command deleteStudentCommand = parser.deleteStudentCommand("delete_student n/John i/A1234567X");

        deleteStudentCommand.execute();
        assertEquals(0, Command.getStudentList().getNumberOfStudents());

    }

}
