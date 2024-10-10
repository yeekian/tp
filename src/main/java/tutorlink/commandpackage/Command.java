package TutorLink.commandpackage;

import TutorLink.listpackage.ItemList;

/**
 * Represents an interpreted Command from the user. A <code>Command</code> object corresponds to a
 * single user-issued command from the terminal.
 */
public abstract class Command {
    /**
     * Executes the required operations to perform the command issued by the user.
     */
    public abstract void execute(ItemList list);

    /**
     * Checks if the command is an exit command.
     *
     * @return whether the current command is an ExitCommand
     */
    public abstract boolean isExit();
}
