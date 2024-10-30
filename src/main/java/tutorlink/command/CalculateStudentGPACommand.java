package tutorlink.command;

import tutorlink.appstate.AppState;
import tutorlink.commons.Commons;
import tutorlink.exceptions.IllegalValueException;
import tutorlink.result.CommandResult;
import tutorlink.exceptions.TutorLinkException;

import java.util.HashMap;

public class CalculateStudentGPACommand extends Command {
    public static final String[] ARGUMENT_PREFIXES = {"i/"};
    public static final String COMMAND_WORD = "calc_gpa";

    public CalculateStudentGPACommand() {}

    @Override
    public CommandResult execute(AppState state, HashMap<String, String> args) throws TutorLinkException {
        if(!args.containsKey(ARGUMENT_PREFIXES[0])){
            throw new IllegalValueException(Commons.ERROR_NULL);
        }

        String matricNo = args.get(ARGUMENT_PREFIXES[0]);

        double score = state.grades.calculateStudentGPA(matricNo, state.components);

        return new CommandResult(matricNo + " has the GPA of: " + score);
    }

    @Override
    public String[] getArgumentPrefixes() {
        return ARGUMENT_PREFIXES;
    }
}
