package tutorlink.commandpackage;

import java.util.HashMap;
import tutorlink.appstatepackage.AppState;
import tutorlink.resultpackage.CommandResult;

public class ListStudentCommand extends Command {

    public static final String COMMAND_WORD = "list_student";
    private static final String SUCCESS_MESSAGE = "Here are your students:";

    @Override
    public CommandResult execute(AppState appState, HashMap<String,String> hashMap) {
        return new CommandResult(appState.students.toString());
    }

}
