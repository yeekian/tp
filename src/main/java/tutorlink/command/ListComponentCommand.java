package tutorlink.command;

import java.util.HashMap;

import tutorlink.appstate.AppState;
import tutorlink.result.CommandResult;

public class ListComponentCommand extends Command {

    public static final String COMMAND_WORD = "list_component";

    @Override
    public CommandResult execute(AppState appState, HashMap<String, String> parameters) {
        return new CommandResult(appState.components.toString());
    }

    @Override
    public String[] getArgumentPrefixes() {
        return null;
    }
}
