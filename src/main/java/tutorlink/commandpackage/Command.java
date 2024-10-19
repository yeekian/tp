package tutorlink.commandpackage;

import java.util.ArrayList;
import java.util.HashMap;
import tutorlink.appstatepackage.AppState;
import tutorlink.listpackage.AssignmentList;
import tutorlink.listpackage.StudentList;
import tutorlink.resultpackage.CommandResult;

/**
 * Represents an interpreted Command from the user. A <code>Command</code> object corresponds to a
 * single user-issued command from the terminal.
 */
public abstract class Command {
    public ArrayList<String> ARGUMENT_PREFIXES;
    public String COMMAND_WORD;
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

