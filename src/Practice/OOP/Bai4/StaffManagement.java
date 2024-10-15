package Practice.OOP.Bai4;

import java.text.ParseException;
import java.util.ArrayList;

public class StaffManagement {
    private ArrayList<Staff> staffList;
    private ReadAndWriteFile readAndWriteFile;

    public StaffManagement(){
        readAndWriteFile = new ReadAndWriteFile();
        this.staffList = readAndWriteFile.readStaffFile();
    }

    public void showAll(){
        System.out.println("--------------- Danh sách nhân viên ---------------");
        for (Staff staff: staffList) {
            System.out.println(staff);
        }
        System.out.println("---------------------------------------------------");
    }

    public void addStaff(Staff newStaff){
        staffList.add(newStaff);
        readAndWriteFile.writeStaffFile(staffList);
    }
}
