package TutorLink.command;

import TutorLink.list.List;

/**
 * Represents an interpreted Command from the user. A <code>Command</code> object corresponds to a
 * single user-issued command from the terminal.
 */
public abstract class Command {
    /**
     * Executes the required operations to perform the command issued by the user.
     */
    abstract public void execute(List list);

    /**
     * Checks if the command is an exit command.
     *
     * @return whether the current command is an ExitCommand
     */
    abstract public boolean isExit();
}
