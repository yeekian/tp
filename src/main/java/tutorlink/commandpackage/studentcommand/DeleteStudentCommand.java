package TutorLink.commandpackage.StudentCommand;

import TutorLink.listpackage.ItemList;
import TutorLink.listpackage.StudentList;
import TutorLink.studentpackage.StudentClass;


public class DeleteStudentCommand extends StudentCommand {

    public DeleteStudentCommand(StudentClass student) {
        super(student);
    }

    // Implement the generic execute method to handle the List type
    @Override
    public void execute(ItemList list) {
        if (list instanceof StudentList) {
            ((StudentList) list).deleteStudent(student);
        } else {
            throw new IllegalArgumentException("Invalid list type. Expected StudentList.");
        }
    }
}
