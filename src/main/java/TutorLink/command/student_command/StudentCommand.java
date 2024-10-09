package TutorLink.command.student_command;

import TutorLink.command.Command;
import TutorLink.student.Student;

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
