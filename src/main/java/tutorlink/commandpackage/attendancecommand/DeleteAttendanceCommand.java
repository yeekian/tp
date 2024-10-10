package TutorLink.commandpackage.AttendanceCommand;

import tutorlink.listpackage.ItemList;
import tutorlink.attendance.Attendance;

public class DeleteAttendanceCommand extends AttendanceCommand{

    public DeleteAttendanceCommand(Attendance attendance) {
        super(attendance);
    }

    @Override
    public void execute(ItemList list) {

    }
}
