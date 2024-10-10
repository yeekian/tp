package tutorlink.list;
import tutorlink.listpackage.StudentList;
import tutorlink.parser.Parser;
import tutorlink.commandpackage.studentcommand.AddStudentCommand;
import tutorlink.commandpackage.studentcommand.DeleteStudentCommand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;



public class StudentListTest {

    @Test
    public void addStudentCommand_nonEmptyMatricNumberAndGPA_success() throws Exception {
        Parser parser = new Parser();
        StudentList studentList = new StudentList();
        assertEquals(0, studentList.getNumberOfStudents());
        AddStudentCommand addStudentCommand = parser.addStudentCommand("A0123456X", 5.0);

        addStudentCommand.execute(studentList);
        assertEquals(1, studentList.getNumberOfStudents());
    }

    @Test
    public void deleteStudentCommand_nonEmptyMatricNumberAndGPA_success() throws Exception {
        Parser parser = new Parser();
        StudentList studentList = new StudentList();

        assertEquals(0, studentList.getNumberOfStudents());
        AddStudentCommand addStudentCommand = parser.addStudentCommand("A0123456X", 5.0);
        addStudentCommand.execute(studentList);

        assertEquals(1, studentList.getNumberOfStudents());

        DeleteStudentCommand deleteStudentCommand = parser.deleteStudentCommand("A0123456X", studentList);

        deleteStudentCommand.execute(studentList);
        assertEquals(0, studentList.getNumberOfStudents());
    }

}
