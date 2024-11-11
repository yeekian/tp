package tutorlink.command;

import java.util.HashMap;

import tutorlink.appstate.AppState;
import tutorlink.result.CommandResult;

public class ListStudentCommand extends Command {

    public static final String COMMAND_WORD = "list_student";
    private static final String MESSAGE_NO_STUDENTS = "No students have been recorded yet.";

    @Override
    public CommandResult execute(AppState appState, HashMap<String, String> hashMap) {
        if(appState.students.size() <= 0) {
            return new CommandResult(MESSAGE_NO_STUDENTS);
        }
        return new CommandResult(appState.students.toString());
    }

    @Override
    public String[] getArgumentPrefixes() {
        return null;
    }
}
