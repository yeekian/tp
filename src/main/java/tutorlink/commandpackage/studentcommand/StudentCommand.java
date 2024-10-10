package tutorlink.commandpackage.studentcommand;

import tutorlink.commandpackage.Command;
import tutorlink.studentpackage.StudentClass;

public abstract class StudentCommand extends Command {
    protected StudentClass student;

    public StudentCommand(StudentClass student) {
        this.student = student;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
