package tutorlink.commandpackage;

import tutorlink.listpackage.StudentList;
import tutorlink.resultpackage.CommandResult;

public class ListStudentCommand extends Command {

    private final String SUCCESS_MESSAGE = "Here are your students:";

    @Override
    public CommandResult execute() {
        return new CommandResult(SUCCESS_MESSAGE,students);
    }

}
