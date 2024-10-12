package tutorlink.commandpackage;

import tutorlink.listpackage.StudentList;
import tutorlink.resultpackage.CommandResult;

public class FindStudentCommand extends Command{

    private String name;
    private String matricNumber;

    public static final String COMMAND_WORD = "findstudent";
    public static final String FORMAT_ERROR_MESSAGE = "Error, expected format: " + COMMAND_WORD
            + " n/NAME AND/OR" + "i/MATRIC NUMBER";
    public final static String REGEX = "^findstudent(?:\\s+n/([^\\\\s]+))?(?:\\s+i/(\\d{7}[a-zA-Z]?))?$";
    private final String SUCCESS_MESSAGE = "Found the following students:";
    private final String ERROR_MESSAGE = "No students found";
    public FindStudentCommand(String name, String matricNumber) {
        this.name = name;
        this.matricNumber = matricNumber;
    }

    @Override
    public CommandResult execute(){
        StudentList filteredList = students.filterList(this.name, this.matricNumber);
        if(filteredList.getNumberOfStudents() > 0) {
            return new CommandResult(SUCCESS_MESSAGE, filteredList);
        } else {
            return new CommandResult(ERROR_MESSAGE);
        }
    }
}
