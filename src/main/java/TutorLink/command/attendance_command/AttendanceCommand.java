package TutorLink.command.attendance_command;

import TutorLink.attendance.Attendance;
import TutorLink.command.Command;

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
