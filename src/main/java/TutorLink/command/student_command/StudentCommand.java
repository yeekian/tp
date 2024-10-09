package tutorlink.command.student_command;

import tutorlink.command.Command;
import tutorlink.student.Student;

abstract public class StudentCommand extends Command {
    private Student student;
    public StudentCommand(Student student) {
        this.student = student;
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
