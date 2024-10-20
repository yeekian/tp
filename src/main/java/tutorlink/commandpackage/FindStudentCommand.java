package tutorlink.commandpackage;

import java.util.HashMap;
import tutorlink.exceptionspackage.DuplicateMatricNumberException;
import tutorlink.exceptionspackage.IllegalValueException;
import tutorlink.exceptionspackage.TutorLinkException;
import tutorlink.listpackage.StudentList;
import tutorlink.resultpackage.CommandResult;
import tutorlink.appstatepackage.AppState;

public class FindStudentCommand extends Command {

    public static final String[] ARGUMENT_PREFIXES = {"i/", "n/"};
    public static final String COMMAND_WORD = "find_student";

    private static final String ERROR_BOTH_NULL = "Error! Both parameters passed are null!";
    private static final String DUPLICATE_MATRIC_NUMBER = "Error! Duplicate Matric Numbers found!";

    @Override
    public CommandResult execute(AppState appstate, HashMap<String,String> hashmap) throws TutorLinkException {
        String matricNumber = hashmap.get(ARGUMENT_PREFIXES[0]);
        String name = hashmap.get(ARGUMENT_PREFIXES[1]);
        StudentList students;
        if(name == null && matricNumber == null) {
            throw new IllegalValueException(ERROR_BOTH_NULL);
        }
        if(hashmap.containsKey(ARGUMENT_PREFIXES[0])) {
            students = appstate.students.findStudentByMatricNumber(matricNumber);
            if(students.getStudentArrayList().size() > 1) {
                throw new DuplicateMatricNumberException(DUPLICATE_MATRIC_NUMBER);
            }
        } else {
            students = appstate.students.findStudentByName(name);
        }
        return new CommandResult(students.toString());
    }
}
