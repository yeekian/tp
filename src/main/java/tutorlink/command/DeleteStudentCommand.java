package tutorlink.command;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tutorlink.appstate.AppState;
import tutorlink.commons.Commons;
import tutorlink.exceptions.IllegalValueException;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.result.CommandResult;

public class DeleteStudentCommand extends Command {

    public static final String[] ARGUMENT_PREFIXES = {"i/"};
    public static final String COMMAND_WORD = "delete_student";

    @Override
    public CommandResult execute(AppState appState, HashMap<String, String> hashmap) throws TutorLinkException {
        String matricNumber = hashmap.get(ARGUMENT_PREFIXES[0]);
        if (matricNumber == null) {
            throw new IllegalValueException(Commons.ERROR_NULL);
        }
        matricNumber = matricNumber.toUpperCase();
        Pattern pattern = Pattern.compile(Commons.MATRIC_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(matricNumber);
        if (!matcher.find()) {
            throw new IllegalValueException(Commons.ERROR_ILLEGAL_MATRIC_NUMBER);
        }
        appState.students.deleteStudent(matricNumber);
        appState.grades.deleteGradesByMatric(matricNumber);
        return new CommandResult(String.format(Commons.DELETE_STUDENT_SUCCESS, matricNumber));
    }

    @Override
    public String[] getArgumentPrefixes() {
        return ARGUMENT_PREFIXES;
    }
}
