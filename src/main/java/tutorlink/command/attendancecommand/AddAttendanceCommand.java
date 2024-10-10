package tutorlink.command.attendancecommand;

import tutorlink.attendance.Attendance;

import java.util.ArrayList;

public class AddAttendanceCommand extends AttendanceCommand{

    public AddAttendanceCommand(Attendance attendance) {
        super(attendance);
    }

    @Override
    public void execute(ArrayList attendanceList) {

    }

}
