package tutorlink.command;

import java.util.ArrayList;
import java.util.HashMap;

import tutorlink.appstate.AppState;
import tutorlink.commons.Commons;
import tutorlink.exceptions.IllegalValueException;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.result.CommandResult;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddStudentCommand extends Command {

    public static final String[] ARGUMENT_PREFIXES = {"i/", "n/"};
    public static final String COMMAND_WORD = "add_student";

    @Override
    public CommandResult execute(AppState appState, HashMap<String, String> hashmap) throws TutorLinkException {
        String matricNumber = hashmap.get(ARGUMENT_PREFIXES[0]);
        String name = hashmap.get(ARGUMENT_PREFIXES[1]);
        if (matricNumber == null || name == null) {
            List<String> nullParameters = new ArrayList<>();
            if (matricNumber == null) {
                nullParameters.add(ARGUMENT_PREFIXES[0]);
            }
            if (name == null) {
                nullParameters.add(ARGUMENT_PREFIXES[1]);
            }
            throw new IllegalValueException(String.format(Commons.ERROR_NULL,
                    String.join(", ", nullParameters)));
        }
        matricNumber = matricNumber.toUpperCase();
        Pattern pattern = Pattern.compile(Commons.MATRIC_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(matricNumber);
        if (!matcher.find()) {
            throw new IllegalValueException(Commons.ERROR_ILLEGAL_MATRIC_NUMBER);
        }
        appState.students.addStudent(matricNumber, name);
        return new CommandResult(String.format(Commons.ADD_STUDENT_SUCCESS, name, matricNumber));
    }

    @Override
    public String[] getArgumentPrefixes() {
        return ARGUMENT_PREFIXES;
    }
}
