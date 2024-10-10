package TutorLink.command.student_command;

import TutorLink.list.List;
import TutorLink.list.StudentList;
import tutorlink.student.Student;

public class DeleteStudentCommand extends StudentCommand {

    public DeleteStudentCommand(Student student) {
        super(student);
    }

    // Implement the generic execute method to handle the List type
    @Override
    public void execute(List list) {
        if (list instanceof StudentList) {
            ((StudentList) list).deleteStudent(student);
        } else {
            throw new IllegalArgumentException("Invalid list type. Expected StudentList.");
        }
    }
}
