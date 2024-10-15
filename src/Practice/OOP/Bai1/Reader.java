package Practice.OOP.Bai1;

enum ReaderType {
    SINH_VIEN,
    HOC_VIEN_CAO_HOC,
    GIAO_VIEN;
}

public class Reader {
    private int idReader;
    private static int idIncrements = 1;
    private String fullName;
    private String address;
    private String phone;
    private ReaderType readerType;

    public Reader(String FullName, String Address, String Phone, ReaderType ReaderType) {
        this.idReader = idIncrements;
        this.fullName = FullName;
        this.address = Address;
        this.phone = Phone;
        this.readerType = ReaderType;
        idIncrements++;
    }

    public int getIdReader() {
        return idReader;
    }

    public void setIdReader(int idReader) {
        this.idReader = idReader;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ReaderType getReaderType() {
        return readerType;
    }

    public void setReaderType(ReaderType readerType) {
        this.readerType = readerType;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "idReader=" + idReader +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", readerType=" + readerType +
                '}';
    }
}
