package Practice.OOP.Bai2;

public class Student {
    private int idStudent;
    private static int idIncrement = 1;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String classroom;

    public Student(String fullName, String address, String phoneNumber, String classroom) {
        this.idStudent = idIncrement;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classroom = classroom;
        idIncrement++;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
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

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}
