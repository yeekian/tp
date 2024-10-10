package tutorlink.commandpackage.attendancecommand;

import tutorlink.listpackage.ItemList;
import tutorlink.attendancepackage.Attendance;

public class DeleteAttendanceCommand extends AttendanceCommand{

    public DeleteAttendanceCommand(Attendance attendance) {
        super(attendance);
    }

    @Override
    public void execute(ItemList list) {

    }
}
