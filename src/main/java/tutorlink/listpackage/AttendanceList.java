package tutorlink.listpackage;

import tutorlink.attendancepackage.Attendance;

import java.util.ArrayList;

public class AttendanceList extends ItemList {
    private ArrayList<Attendance> attendanceArrayList;
    private int numberOfAttendance;

    public AttendanceList() {
        this.numberOfAttendance = 0;
        this.attendanceArrayList = new ArrayList<>();
    }

    public void markAttendance(Attendance attendance){
        this.attendanceArrayList.add(attendance);
    }

    public void unmarkAttendance(Attendance attendance){
        this.attendanceArrayList.remove(attendance);
    }
}
