package tutorlink.command;

import java.util.HashMap;

import tutorlink.appstate.AppState;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.result.CommandResult;

/**
 * Represents an interpreted Command from the user. A <code>Command</code> object corresponds to a
 * single user-issued command from the terminal.
 */
public abstract class Command {

    public static String[] ARGUMENT_PREFIXES = new String[]{};
    public static String COMMAND_WORD = "";

    /**
     * Executes the required operations to perform the command issued by the user.
     */
    public abstract CommandResult execute(
            AppState appState,
            HashMap<String, String> parameters
    ) throws TutorLinkException;

    /**
     * Checks if the command is an exit command.
     *
     * @return whether the current command is an ExitCommand
     */
    public boolean isExit() {
        return false;
    }
}

