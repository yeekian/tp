package tutorlink.commandpackage;

import java.util.HashMap;
import tutorlink.appstatepackage.AppState;
import tutorlink.exceptionspackage.IllegalValueException;
import tutorlink.exceptionspackage.StudentNotFoundException;
import tutorlink.exceptionspackage.TutorLinkException;
import tutorlink.resultpackage.CommandResult;

public class DeleteStudentCommand extends Command {

    public static final String[] ARGUMENT_PREFIXES = {"i/"};
    public static final String COMMAND_WORD = "delete_student";

    private static final String ERROR_MATRIC_NUMBER_NULL = "Error! Matric number is null";
    private static final String STUDENT_NOT_FOUND = "Error! Student (Matric Number %s) not found";
    private static final String SUCCESS_MESSAGE = "Student %s successfully deleted";

    @Override
    public CommandResult execute(AppState appState, HashMap<String,String> hashmap) throws TutorLinkException {
        String matricNumber = hashmap.get(ARGUMENT_PREFIXES[0]);
        if(matricNumber == null) {
            throw new IllegalValueException(ERROR_MATRIC_NUMBER_NULL);
        }
        boolean result = appState.students.deleteStudent(matricNumber);
        if(result) {
            return new CommandResult(String.format(SUCCESS_MESSAGE, matricNumber));
        } else {
            throw new StudentNotFoundException(String.format(STUDENT_NOT_FOUND, matricNumber));
        }
    }
}
