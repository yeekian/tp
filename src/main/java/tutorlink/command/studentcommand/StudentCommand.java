package tutorlink.command.studentcommand;

import tutorlink.command.Command;
import tutorlink.student.Student;

public abstract class StudentCommand extends Command {
    private Student student;
    public StudentCommand(Student student) {
        this.student = student;
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
