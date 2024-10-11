package tutorlink.command.attendancecommand;

import tutorlink.attendance.Attendance;

import java.util.ArrayList;

public class DeleteAttendanceCommand extends AttendanceCommand{

    public DeleteAttendanceCommand(Attendance attendance) {
        super(attendance);
    }

    @Override
    public void execute(ArrayList list) {

    }
}
