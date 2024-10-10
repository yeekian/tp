package tutorlink.commandpackage.attendancecommand;

import tutorlink.commandpackage.Command;
import tutorlink.attendancepackage.Attendance;

public abstract class AttendanceCommand extends Command {
    private Attendance attendance;

    public AttendanceCommand(Attendance attendance) {
        this.attendance = attendance;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
