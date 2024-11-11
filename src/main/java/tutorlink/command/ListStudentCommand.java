package tutorlink.command;

import java.util.HashMap;
import tutorlink.appstate.AppState;
import tutorlink.result.CommandResult;

/**
 * Represents a command to list all students in the application.
 * When executed, this command retrieves the list of students from the application state
 * and returns it as a command result.
 */
public class ListStudentCommand extends Command {

    public static final String COMMAND_WORD = "list_student";

    /**
     * Executes the command to list all students, retrieving the student list from the application state.
     *
     * @param appState The current application state containing the student list.
     * @param hashMap  A map of argument prefixes to their values (unused in this command).
     * @return A {@code CommandResult} containing the list of students as a string.
     */
    @Override
    public CommandResult execute(AppState appState, HashMap<String, String> hashMap) {
        return new CommandResult(appState.students.toString());
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
