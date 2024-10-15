package Practice.OOP.Bai4;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class SellProductManagement {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        StaffManagement staffManagement = new StaffManagement();
        ProductManagement productManagement = new ProductManagement();

//        Product product1 = new Product("Tivi Samsung 55 inch", ProductGroup.DIEN_TU, 12000000, 10);
//        Product product2 = new Product("Tủ lạnh LG Inverter 400L", ProductGroup.DIEN_LANH, 18000000, 5);
//        Product product3 = new Product("Laptop Dell XPS 13", ProductGroup.MAY_TINH, 25000000, 7);
//        Product product4 = new Product("Máy in Canon LBP2900", ProductGroup.THIET_BI_VAN_PHONG, 3000000, 15);
//        Product product5 = new Product("Điều hòa Daikin 12000BTU", ProductGroup.DIEN_LANH, 15000000, 8);
//        Product product6 = new Product("Loa Sony Extra Bass", ProductGroup.DIEN_TU, 2000000, 20);
//        productManagement.addProduct(product1);
//        productManagement.addProduct(product2);
//        productManagement.addProduct(product3);
//        productManagement.addProduct(product4);
//        productManagement.addProduct(product5);
//        productManagement.addProduct(product6);
//
//        Staff staff1 = new Staff("Nguyễn Văn A", "123 Đường ABC, Quận 1, TP.HCM", "0901234567", "01/01/2021");
//        Staff staff2 = new Staff("Trần Thị B", "456 Đường XYZ, Quận 2, TP.HCM", "0907654321", "15/03/2021");
//        Staff staff3 = new Staff("Lê Văn C", "789 Đường DEF, Quận 3, TP.HCM", "0981122334", "20/05/2021");
//        Staff staff4 = new Staff("Phạm Thị D", "101 Đường GHI, Quận 4, TP.HCM", "0912345678", "10/07/2021");
//        Staff staff5 = new Staff("Hoàng Văn E", "202 Đường JKL, Quận 5, TP.HCM", "0933445566", "05/09/2021");
//        Staff staff6 = new Staff("Đỗ Thị F", "303 Đường MNO, Quận 6, TP.HCM", "0944556677", "30/11/2021");
//
//        staffManagement.addStaff(staff1);
//        staffManagement.addStaff(staff2);
//        staffManagement.addStaff(staff3);
//        staffManagement.addStaff(staff4);
//        staffManagement.addStaff(staff5);
//        staffManagement.addStaff(staff6);
        int chooseOption;
        do {
            System.out.println("1.Danh sách nhân viên.");
            System.out.println("2.Thêm nhân viên mới.");
            System.out.println("3.Danh sách mặt hàng.");
            System.out.println("4.Thêm mặt hàng mới.");
            System.out.println("0.Thoát.");
            chooseOption = scanner.nextInt();
            switch (chooseOption) {
                case 1:
                    staffManagement.showAll();
                    break;
                case 2:
                    addStaff(staffManagement);
                    break;
                case 3:
                    productManagement.showAll();
                    break;
                case 4:
                    addProduct(productManagement);
                    break;
            }
        }while (chooseOption != 0);
    }

    private static void addProduct(ProductManagement productManagement) {
        System.out.println("Nhập tên mặt hàng: ");
        scanner.nextLine();
        String nameProduct = scanner.nextLine();
        System.out.println("Nhập nhóm mặt hàng (0.DIEN_TU, 1.DIEN_LANH, 2.MAY_TINH, 3.THIET_BI_VAN_PHONG): ");
        int choiceProductGroup = scanner.nextInt();
        ProductGroup productGroup = ProductGroup.values()[choiceProductGroup];
        System.out.println("Nhập giá mặt hàng: ");
        double price = scanner.nextDouble();
        System.out.println("Nhập số lượng mặt hàng: ");
        int quantity = scanner.nextInt();
        Product product = new Product(nameProduct, productGroup, price, quantity);
        productManagement.addProduct(product);
        System.out.println("----------------- Thêm mặt hàng mới thành công! -----------------");
    }

    private static void addStaff(StaffManagement staffManagement) {
        System.out.println("Nhập tên nhân viên: ");
        scanner.nextLine();
        String nameStaff = scanner.nextLine();
        System.out.println("Nhập địa chỉ nhân viên: ");
        String address = scanner.nextLine();
        System.out.println("Nhập số điện thoại nhân viên: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Ngày kí hợp đồng (DD/MM/YYYY): ");
        String contactDate = scanner.nextLine();
        Staff staff = new Staff(nameStaff, address, phoneNumber, contactDate);
        staffManagement.addStaff(staff);
        System.out.println("--------------- Thêm nhân viên mới thành công! ---------------");
    }
}
