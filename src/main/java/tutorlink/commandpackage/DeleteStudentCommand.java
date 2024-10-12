package tutorlink.commandpackage;

import tutorlink.exceptionspackage.IllegalValueException;
import tutorlink.exceptionspackage.ItemNotFoundException;
import tutorlink.listpackage.StudentList;
import tutorlink.resultpackage.CommandResult;
import tutorlink.studentpackage.StudentClass;

import java.util.regex.Pattern;

public class DeleteStudentCommand extends FindStudentCommand{

    private final String ERROR_MESSAGE = "Student %s not found";
    private final String SUCCESS_MESSAGE = "Student %s successfully deleted";

    public static final String COMMAND_WORD = "deletestudent";

    public DeleteStudentCommand(String name, String matricNumber) {
        super(name, matricNumber);
    }

    public CommandResult execute() {
        StudentList filteredList = students.filterList(this.name, this.matricNumber);
        if(filteredList.getNumberOfStudents() > 0) {
            filteredList.getStudentArrayList().remove(0); //remove the first match
            return new CommandResult(SUCCESS_MESSAGE, filteredList);
        } else {
            String identifier = (this.name != null ? this.name : "") + ", "
                    + (this.name != null ? this.name : "");
            return new CommandResult(String.format(ERROR_MESSAGE, identifier), filteredList);
        }
    }
}
