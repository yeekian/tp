package tutorlink.command.studentcommand;

import tutorlink.student.Student;

import java.util.ArrayList;

public class DeleteStudentCommand extends StudentCommand{

    public DeleteStudentCommand(Student student) {
        super(student);
    }
    @Override
    public void execute(ArrayList list) {

    }
}
