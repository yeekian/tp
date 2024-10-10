package TutorLink.command.student_command;

import TutorLink.command.Command;
import tutorlink.student.Student;

public abstract class StudentCommand extends Command {
    protected Student student;

    public StudentCommand(Student student) {
        this.student = student;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
