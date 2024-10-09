package TutorLink.command.attendance_command;

import TutorLink.attendance.Attendance;
import TutorLink.command.assignment_command.AddAssignmentCommand;

import java.util.ArrayList;

public class AddAttendanceCommand extends AttendanceCommand{

    public AddAttendanceCommand(Attendance attendance) {
        super(attendance);
    }

    @Override
    public void execute(ArrayList attendanceList) {

    }

}
