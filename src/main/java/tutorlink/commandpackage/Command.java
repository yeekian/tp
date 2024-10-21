package tutorlink.commandpackage;

import java.util.HashMap;
import tutorlink.appstatepackage.AppState;
import tutorlink.resultpackage.CommandResult;

/**
 * Represents an interpreted Command from the user. A <code>Command</code> object corresponds to a
 * single user-issued command from the terminal.
 */
public abstract class Command {
    /**
     * Executes the required operations to perform the command issued by the user.
     */
    public abstract CommandResult execute(AppState appState, HashMap<String,String> parameters);

    /**
     * Checks if the command is an exit command.
     *
     * @return whether the current command is an ExitCommand
     */
    public boolean isExit() {
        return false;
    }
}

