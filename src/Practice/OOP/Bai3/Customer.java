package Practice.OOP.Bai3;


enum CustomerType {
    MUA_LE,
    MUA_BUON
}
public class Customer {
    private int idCustomer;
    private static int idIncrement = 1;
    private String fullName;
    private String address;
    private String phoneNumber;
    private CustomerType customerType;

    public Customer(String fullName, String address, String phoneNumber, CustomerType customerType) {
        this.idCustomer = idIncrement;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.customerType = customerType;
        idIncrement++;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerType=" + customerType +
                '}';
    }
}


