package tutorlink.command.attendancecommand;

import tutorlink.attendance.Attendance;
import tutorlink.command.Command;

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
