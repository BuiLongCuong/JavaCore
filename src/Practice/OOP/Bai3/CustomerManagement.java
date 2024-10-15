package Practice.OOP.Bai3;

import java.util.ArrayList;

public class CustomerManagement {
    private ArrayList<Customer> customerList;
    private ReadAndWriteFile readAndWriteFile;

    public CustomerManagement() {
        readAndWriteFile = new ReadAndWriteFile();
        this.customerList = readAndWriteFile.readCustomerFile();
    }

    public void addCustomer(Customer newCustomer) {
        customerList.add(newCustomer);
        readAndWriteFile.writeCustomerFile(customerList);
    }

    public void showAll() {
        System.out.println("---------------------- Danh sách khách hàng ----------------------");
        for (Customer customer: customerList) {
            System.out.println(customer);
        }
        System.out.println("-------------------------------------------------------------------");
    }

    public Customer findCustomerById(int id) {
        for (Customer customer : customerList) {
            if(customer.getIdCustomer() == id) {
                return customer;
            }
        }
        return null;
    }
}
