package TutorLink.command.student_command;

import TutorLink.list.List;
import tutorlink.student.Student;
import TutorLink.list.StudentList;

import java.util.ArrayList;

public class AddStudentCommand extends StudentCommand {

    public AddStudentCommand(Student student) {
        super(student);
    }

    // Implement the generic execute method to handle the List type
    @Override
    public void execute(List list) {
        if (list instanceof StudentList) {
            ((StudentList) list).addStudent(student);
        } else {
            throw new IllegalArgumentException("Invalid list type. Expected StudentList.");
        }
    }

    @Override
    public boolean isExit() {
        return super.isExit();
    }
}