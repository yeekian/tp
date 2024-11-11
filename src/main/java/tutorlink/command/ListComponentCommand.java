package tutorlink.command;

import java.util.HashMap;

import tutorlink.appstate.AppState;
import tutorlink.result.CommandResult;

public class ListComponentCommand extends Command {

    public static final String COMMAND_WORD = "list_component";
    private static final String MESSAGE_NO_COMPONENTS = "No components have been recorded yet.";

    @Override
    public CommandResult execute(AppState appState, HashMap<String, String> parameters) {
        if(appState.components.size() <= 0) {
            return new CommandResult(MESSAGE_NO_COMPONENTS);
        }
        return new CommandResult(appState.components.toString());
    }

    @Override
    public String[] getArgumentPrefixes() {
        return null;
    }
}
