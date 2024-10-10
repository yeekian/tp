package TutorLink.commandpackage.StudentCommand;

import TutorLink.commandpackage.Command;
import TutorLink.studentpackage.StudentClass;

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
