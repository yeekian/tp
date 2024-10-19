package tutorlink.commandpackage;

import java.util.HashMap;
import tutorlink.exceptionspackage.DuplicateMatricNumberException;
import tutorlink.exceptionspackage.IllegalValueException;
import tutorlink.exceptionspackage.StudentNotFoundException;
import tutorlink.exceptionspackage.TutorLinkException;
import tutorlink.listpackage.StudentList;
import tutorlink.resultpackage.CommandResult;
import tutorlink.appstatepackage.AppState;
import java.util.ArrayList;

public class FindStudentCommand extends Command {

    public final String[] ARGUMENT_PREFIXES = {"i/", "n/"};
    public final String COMMAND_WORD = "find_student";

    private static final String ERROR_BOTH_NULL = "Error! Both parameters passed are null!";
    private static final String DUPLICATE_MATRIC_NUMBER = "Error! Duplicate Matric Numbers found!";

//    public final String FORMAT_ERROR_MESSAGE = "Error, expected format: " + COMMAND_WORD
//            + " n/NAME {AND/OR} " + "i/MATRIC NUMBER";
//    public static final int PREFIX_INDEX = 2;
//    public static final String REGEX = "^find_student (i/(A\\d{7}[A-Z])?( n/[\\w\\d]+)?|n/[\\w\\d]" +
//            "+( i/(A\\d{7}[A-Z])?)?)( )?$";

//    protected static final String ERROR_MESSAGE = "Student (%s) not found in Student List";
//
//    private static final String SUCCESS_MESSAGE = "Found the following students:";

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
