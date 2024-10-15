package Practice.OOP.Bai4;

public class Staff {
    private int idStaff;
    private static int idIncrement = 1;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String contactDate;


    public Staff(String fullName, String address, String phoneNumber, String contactDate) {
        this.idStaff = idIncrement;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.contactDate = contactDate;
        idIncrement++;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactDate() {
        return contactDate;
    }

    public void setContactDate(String contactDate) {
        this.contactDate = contactDate;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "idStaff=" + idStaff +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contactDate='" + contactDate + '\'' +
                '}';
    }
}
