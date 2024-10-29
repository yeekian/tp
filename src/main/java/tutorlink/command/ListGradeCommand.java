package tutorlink.command;

import java.util.HashMap;

import tutorlink.appstate.AppState;
import tutorlink.result.CommandResult;

public class ListGradeCommand extends Command {

    public static final String COMMAND_WORD = "list_grade";

    @Override
    public CommandResult execute(AppState appState, HashMap<String, String> hashMap) {
        return new CommandResult(appState.grades.toString());
    }

    @Override
    public String[] getArgumentPrefixes() {
        return null;
    }
}
