package tutorlink.parserpackage;

import tutorlink.commandpackage.*;
import tutorlink.listpackage.StudentList;
import tutorlink.studentpackage.StudentClass;
import exception.StudentNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final String EMPTY_INPUT_ERROR_MESSAGE = "Error: Input cannot be empty";

    public Command parse(String line) {
        if(line.trim().isEmpty()){
            return new InvalidCommand(EMPTY_INPUT_ERROR_MESSAGE);
        }
        String commandWord = extractCommandWord(line);
        switch(commandWord){
        case AddStudentCommand.COMMAND_WORD:
            return addStudentCommand(line);
            break;
        case DeleteStudentCommand.COMMAND_WORD:
            return addStudentCommand(line);
            break;
        case ListStudentCommand.COMMAND_WORD:
            break;
//        case FindStudentCommand.COMMAND_WORD:
//            break;
        case AddCourseCommand.COMMAND_WORD:
            break;
        case DeleteCourseCommand.COMMAND_WORD:
            break;
        case ListCourseCommand.COMMAND_WORD:
            break;
        case AddAssignmentCommand.COMMAND_WORD:
            break;
        case DeleteAssignmentCommand.COMMAND_WORD:
            break;
        case ListAssignmentCommand.COMMAND_WORD:
            break;

        }
    }

    private String extractCommandWord(String input) {
        String words[] = input.split("\\s+");
        return words[0]; //return the first word
    }

    public Command findStudentCommand(String line) {
        Pattern pattern = Pattern.compile(FindStudentCommand.REGEX);
        Matcher matcher = pattern.matcher(line);
        if(!matcher.matches()) {
            return new InvalidCommand(FindStudentCommand.FORMAT_ERROR_MESSAGE);
        }
        String name = matcher.group(1);
        String matricNumber = matcher.group(2);
        return new FindStudentCommand(name, matricNumber);
    }

    /**
     * Creates an AddStudentCommand for adding a new student.
     *
     * @param line input line from the user
     * @return an AddStudentCommand object to add the new student
     */
    public Command addStudentCommand(String line) {
        Pattern pattern = Pattern.compile(AddStudentCommand.REGEX);
        Matcher matcher = pattern.matcher(line);
        if(!matcher.find()) {
            return new InvalidCommand(AddStudentCommand.FORMAT_ERROR_MESSAGE);
        }
        String name = matcher.group(1);
        String matricNumber = matcher.group(2);
        return new AddStudentCommand(name, matricNumber);
    }

    /**
     * Creates a DeleteStudentCommand for deleting a student with the given matriculation number.
     *
     * @param matricNumber the matriculation number of the student to delete
     * @param studentList the list of students to search for the student
     * @return a DeleteStudentCommand object to delete the student
     */
    public DeleteStudentCommand deleteStudentCommand(String matricNumber, StudentList studentList) {
        DeleteStudentCommand deleteStudentCommand = new DeleteStudentCommand(matricNumber);
        return deleteStudentCommand;
    }

}
