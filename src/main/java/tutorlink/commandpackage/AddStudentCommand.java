package tutorlink.commandpackage;

import tutorlink.exceptionspackage.IllegalValueException;
import tutorlink.resultpackage.CommandResult;
import tutorlink.studentpackage.StudentClass;

import java.util.regex.Pattern;

public class AddStudentCommand extends Command {

    private String matricNumber;
    private String name;

    private final String SUCCESSFUL_MESSAGE = "Student added successfully";
    private final String ERROR_MESSAGE = "Error! "

    public static final String FORMAT_ERROR_MESSAGE = "Error, expected format: " + COMMAND_WORD + " n/NAME " +
            "i/MATRIC NUMBER";
    public static final String REGEX = "^add_student\\s+n/(.+?)\\s+i/(\\d{7}[a-zA-Z]?)$";
    public static final String COMMAND_WORD = "addstudent";

    public AddStudentCommand(String name, String matricNumber) {
        this.name = name;
        this.matricNumber = matricNumber;
    }

    @Override
    public CommandResult execute() {
        try{
            addStudent(this.name, this.matricNumber);
            return new CommandResult(SUCCESSFUL_MESSAGE);
        } catch (IllegalValueException e) {
            return new CommandResult(e.getMessage());
        }
    }

    private void addStudent(String name, String matricNumber) throws IllegalValueException {
        String ErrMsg = "";
        if (name.trim().isEmpty()) {
            throw new IllegalValueException("Name cannot be empty");
        }
        if (matricNumber.trim().isEmpty()) {
            throw new IllegalValueException("Matric number cannot be empty");
        }
        String regex = "^A\\d{7}[A-Z]$";
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(matricNumber).matches()) {
            ErrMsg = "Invalid Matric Number. Matric Number should be of the form A[0-9]{7}[A-Z]";
            throw new IllegalValueException(ErrMsg);
        }
        students.addStudent(new StudentClass(matricNumber));
    }
}
