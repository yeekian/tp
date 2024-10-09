package tutorlink.command.attendance_command;

import tutorlink.attendance.Attendance;
import tutorlink.command.Command;

abstract public class AttendanceCommand extends Command {
    private Attendance attendance;

    public AttendanceCommand(Attendance attendance) {
        this.attendance = attendance;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
