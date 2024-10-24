package tutorlink.command;

import tutorlink.appstate.AppState;
import tutorlink.exceptions.InvalidCommandException;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.result.CommandResult;

import java.util.HashMap;

public class InvalidCommand extends Command {

    public static final String INVALID_COMMAND_MESSAGE = "Error! Invalid command given!";

    @Override
    public CommandResult execute(AppState appState, HashMap<String, String> hashMap)  throws TutorLinkException {
        throw new InvalidCommandException(INVALID_COMMAND_MESSAGE);
    }

    @Override
    public String[] getArgumentPrefixes() {
        return null;
    }
}
