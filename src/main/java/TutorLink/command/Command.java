package TutorLink.command;

import java.util.ArrayList;

/**
 * Represents an interpreted Command from the user. A <code>Command</code> object corresponds to a
 * single user-issued command from the terminal.
 */

abstract public class Command {
    /**
     * Executes the required operations to perform the command issued by the user.
     */
    abstract public void execute(ArrayList list);
    /**
     * Checks if the command is an exit command.
     *
     * @return whether the current command is an ExitCommand
     */
    abstract public boolean isExit();
}
