package tutorlink.command;

import tutorlink.appstate.AppState;
import tutorlink.exceptions.IllegalValueException;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.result.CommandResult;

import java.util.HashMap;

public class AddGradeCommand extends Command {
    public static final String[] ARGUMENT_PREFIXES = {"i/", "c/", "s/"};
    public static final String COMMAND_WORD = "add_grade";

    private static final String ERROR_EITHER_NULL = "Error! At least one parameter passed is null!";
    private static final String SUCCESS_MESSAGE = "%s grade added successfully to %s for %s!";

    @Override
    public CommandResult execute(AppState appstate, HashMap<String, String> hashmap) throws TutorLinkException {
        String matricNumber = hashmap.get(ARGUMENT_PREFIXES[0]);
        String componentDescription = hashmap.get(ARGUMENT_PREFIXES[1]);
        String scoreNumber = hashmap.get(ARGUMENT_PREFIXES[1]);
        if (matricNumber == null || componentDescription == null || scoreNumber == null) {
            throw new IllegalValueException(ERROR_EITHER_NULL);
        }

        appstate.grades.addGrade(appstate, matricNumber, componentDescription, scoreNumber);
        return new CommandResult(String.format(SUCCESS_MESSAGE, scoreNumber, componentDescription, matricNumber));
    }

    @Override
    public String[] getArgumentPrefixes() {
        return ARGUMENT_PREFIXES;
    }
}
