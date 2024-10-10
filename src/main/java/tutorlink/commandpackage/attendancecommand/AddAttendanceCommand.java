package tutorlink.commandpackage.attendancecommand;

import tutorlink.listpackage.ItemList;
import tutorlink.attendancepackage.Attendance;

public class AddAttendanceCommand extends AttendanceCommand{

    public AddAttendanceCommand(Attendance attendance) {
        super(attendance);
    }

    @Override
    public void execute(ItemList list) {

    }
}
