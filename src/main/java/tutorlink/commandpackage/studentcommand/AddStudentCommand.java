package tutorlink.commandpackage.studentcommand;

import tutorlink.listpackage.ItemList;
import tutorlink.listpackage.StudentList;
import tutorlink.studentpackage.StudentClass;

public class AddStudentCommand extends StudentCommand {

    public AddStudentCommand(StudentClass student) {
        super(student);
    }

    // Implement the generic execute method to handle the List type
    @Override
    public void execute(ItemList list) {
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
