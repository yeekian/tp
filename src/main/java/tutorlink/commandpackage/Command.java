package tutorlink.commandpackage;

import tutorlink.listpackage.StudentList;
import tutorlink.listpackage.StudentList;
import tutorlink.resultpackage.CommandResult;

/**
 * Represents an interpreted Command from the user. A <code>Command</code> object corresponds to a
 * single user-issued command from the terminal.
 */
public abstract class Command {

    protected static StudentList students = new StudentList();
    /** Executes the required operations to perform the command issued by the user. */
    public abstract CommandResult execute();

    /**
     * Checks if the command is an exit command.
     *
     * @return whether the current command is an ExitCommand
     */
    public boolean isExit(){
        return false;
    }

    public static StudentList getStudentList(){
        return students;
    }
}

