package tutorlink.command;

import java.util.HashMap;

import tutorlink.appstate.AppState;
import tutorlink.result.CommandResult;

/**
 * Represents a command to list all components. The command retrieves the components
 * from the application state and returns them in a formatted list.
 */
public class ListComponentCommand extends Command {

    /** The command word used to trigger this command. */
    public static final String COMMAND_WORD = "list_component";

    /**
     * Executes the command to list all components.
     *
     * @param appState The current application state containing the component data.
     * @param parameters A map of argument prefixes to their values, not used for this command.
     * @return A {@code CommandResult} containing the formatted list of components.
     */
    @Override
    public CommandResult execute(AppState appState, HashMap<String, String> parameters) {
        return new CommandResult(appState.components.toString());
    }

    /**
     * Returns the argument prefixes required by this command.
     *
     * @return {@code null} as this command does not require any argument prefixes.
     */
    @Override
    public String[] getArgumentPrefixes() {
        return null;
    }
}
