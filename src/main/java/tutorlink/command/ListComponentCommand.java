package tutorlink.command;

import java.util.HashMap;

import tutorlink.appstate.AppState;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.result.CommandResult;

public class ListComponentCommand extends Command {

    public static final String COMMAND_WORD = "list_component";
    private static final String SUCCESS_MESSAGE = "Here are your components:";
    private static final String EMPTY_MESSAGE = "No components found.";

    @Override
    public CommandResult execute(AppState appState, HashMap<String, String> parameters) throws TutorLinkException {
        if (appState.components.size() == 0) {
            return new CommandResult(EMPTY_MESSAGE);
        }
        return new CommandResult(SUCCESS_MESSAGE + "\n" + appState.components.toString());
    }

    @Override
    public String[] getArgumentPrefixes() {
        return new String[]{};
    }
}
