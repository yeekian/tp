package tutorlink.commandpackage;

import java.util.HashMap;
import tutorlink.appstatepackage.AppState;
import tutorlink.exceptionspackage.IllegalValueException;
import tutorlink.exceptionspackage.TutorLinkException;
import tutorlink.resultpackage.CommandResult;
import tutorlink.studentpackage.Student;

public class AddStudentCommand extends Command {

    public final String[] ARGUMENT_PREFIXES = {"i/", "n/"};
    public String COMMAND_WORD = "add_student";

    private static final String ERROR_EITHER_NULL = "Error! Either parameter passed is null!";
    private static final String SUCCESS_MESSAGE = "Student %s (%s) added successfully!";

//    public static final String FORMAT_ERROR_MESSAGE = "Error, expected format: " + COMMAND_WORD + " n/NAME " +
//            "i/MATRIC NUMBER";
//    public static final String REGEX = "^add_student\\s+n/(.+?)\\s+i/(A\\d{7}[a-zA-Z])$";
//
//    private static final String SUCCESSFUL_MESSAGE = "Student (%s) added successfully";
//    private String matricNumber;
//    private String name;

    @Override
    public CommandResult execute(AppState appstate, HashMap<String,String> hashmap) throws TutorLinkException {
        String matricNumber = hashmap.get(ARGUMENT_PREFIXES[0]);
        String name = hashmap.get(ARGUMENT_PREFIXES[1]);
        if(matricNumber == null || name == null) {
            throw new IllegalValueException(ERROR_EITHER_NULL);
        }
        appstate.students.addStudent(matricNumber, name);
        return new CommandResult(String.format(SUCCESS_MESSAGE, name, matricNumber));
    }
}
