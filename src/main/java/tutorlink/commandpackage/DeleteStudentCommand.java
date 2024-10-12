package tutorlink.commandpackage;

import tutorlink.exceptionspackage.IllegalValueException;
import tutorlink.exceptionspackage.ItemNotFoundException;
import tutorlink.resultpackage.CommandResult;
import tutorlink.studentpackage.StudentClass;

import java.util.regex.Pattern;

public class DeleteStudentCommand extends Command{

    private String matricNumber;

    private final String ERROR_MESSAGE = "Student %s not found";
    private final String SUCCESS_MESSAGE = "Student %s successfully deleted";

    public static final String COMMAND_WORD = "deletestudent";

    public DeleteStudentCommand(String matricNumber) {
        this.matricNumber = matricNumber;
    }

    public CommandResult execute() {
        try {
            deleteStudent(this.matricNumber);
            return new CommandResult(String.format(SUCCESS_MESSAGE, matricNumber));
        } catch (IllegalValueException | ItemNotFoundException e) {
            return new CommandResult(e.getMessage());
        }
    }
    private void deleteStudent(String matricNumber) throws IllegalValueException, ItemNotFoundException {
        String ErrMsg = "";
        if (matricNumber.trim().isEmpty()) {
            ErrMsg = "Empty Matric Number";
        } else {
            String regex = "^A\\d{7}[A-Z]$";
            Pattern pattern = Pattern.compile(regex);
            if (!pattern.matcher(matricNumber).matches()) {
                ErrMsg = "Invalid Matric Number. Matric Number should be of the form A[0-9]{7}[A-Z]";
            }
        }
        if (!ErrMsg.isEmpty()) {
            throw new IllegalValueException(ErrMsg);
        } else {
            StudentClass student = new StudentClass(matricNumber);
            if(!students.deleteStudent(student)) {
                throw new ItemNotFoundException(String.format(ERROR_MESSAGE, matricNumber));
            }
        }
    }
}
