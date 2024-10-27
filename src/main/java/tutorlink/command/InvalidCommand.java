package tutorlink.command;

import tutorlink.appstate.AppState;
import tutorlink.commons.Commons;
import tutorlink.exceptions.InvalidCommandException;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.result.CommandResult;

import java.util.HashMap;

public class InvalidCommand extends Command {

    @Override
    public CommandResult execute(AppState appState, HashMap<String, String> hashMap)  throws TutorLinkException {
        throw new InvalidCommandException(Commons.ERROR_INVALID_COMMAND);
    }

    @Override
    public String[] getArgumentPrefixes() {
        return null;
    }
}
