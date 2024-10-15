package Practice.OOP.Bai3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BuyItemManagement {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        CustomerManagement customerManagement = new CustomerManagement();
        ItemManagement itemManagement = new ItemManagement();

//        Customer customer1 = new Customer("Phạm Nhật Minh", "Ân Mỹ", "0121", CustomerType.MUA_LE);
//        Customer customer2 = new Customer("Nguyễn Văn Chánh", "Ân Tín", "0122", CustomerType.MUA_BUON);
//        Customer customer3 = new Customer("Đặng Minh Chiến", "Ân Hảo Đông", "0123", CustomerType.MUA_LE);
//        Customer customer4 = new Customer("Dương Văn Hoàng", "Ân Hảo Đông", "0124", CustomerType.MUA_BUON);
//        Customer customer5 = new Customer("Nguyễn Thị Mai", "Ân Đức", "0125", CustomerType.MUA_BUON);
//        Customer customer6 = new Customer("Phạm Quang Hải", "Bồng Sơn", "0126", CustomerType.MUA_BUON);
//
//        customerManagement.addCustomer(customer1);
//        customerManagement.addCustomer(customer2);
//        customerManagement.addCustomer(customer3);
//        customerManagement.addCustomer(customer4);
//        customerManagement.addCustomer(customer5);
//        customerManagement.addCustomer(customer6);
//
//        Item item1 = new Item("Áo thun", ItemGroup.HANG_THOI_TRANG, 150000);
//        Item item2 = new Item("Nước giặt", ItemGroup.HANG_TIEU_DUNG, 50000);
//        Item item3 = new Item("TV SamSung", ItemGroup.HANG_DIEN_MAY, 12000000);
//        Item item4 = new Item("Nồi Cơm điện", ItemGroup.HANG_GIA_DUNG, 60000);
//        Item item5 = new Item("Máy giặt LG", ItemGroup.HANG_DIEN_MAY, 800000);
//        Item item6 = new Item("Sữa tắm Dove", ItemGroup.HANG_TIEU_DUNG, 75000);
//
//        itemManagement.addItem(item1);
//        itemManagement.addItem(item2);
//        itemManagement.addItem(item3);
//        itemManagement.addItem(item4);
//        itemManagement.addItem(item5);
//        itemManagement.addItem(item6);
//        BuyItemList buyItemList1 = new BuyItemList(customer1);
//        Map<Item, Integer> list1 = new HashMap<>();
//        list1.put(item1, 200);
//        list1.put(item3, 100);
//        list1.put(item5, 100);
//        buyItemList1.addItem(list1);
//        buyItemList1.saveToFile();
//
//        BuyItemList buyItemList2 = new BuyItemList(customer6);
//        Map<Item, Integer> list2 = new HashMap<>();
//        list2.put(item2, 300);
//        list2.put(item4, 200);
//        list2.put(item6, 300);
//        list2.put(item1, 150);
//        buyItemList2.addItem(list2);
//        buyItemList2.saveToFile();

        int chooseOption;
        do {
            System.out.println("1.Danh sách khách hàng.");
            System.out.println("2.Thêm khách hàng mới.");
            System.out.println("3.Danh sách mặt hàng.");
            System.out.println("4.Thêm mặt hàng mới.");
            System.out.println("5.Khách hàng đăng ký mua hàng.");
            System.out.println("0.Thoát.");
            chooseOption = scanner.nextInt();
            switch (chooseOption) {
                case 1 :
                    customerManagement.showAll();
                    break;
                case 2:
                    addCustomer(customerManagement);
                    break;
                case 3:
                    itemManagement.showAll();
                    break;
                case 4:
                    addItem(itemManagement);
                    break;
                case 5:
                    System.out.println("Nhập id của khách hàng: ");
                    int idCustomer = scanner.nextInt();
                    Customer customer = customerManagement.findCustomerById(idCustomer);
                    if(customer == null) {
                        System.out.println("------------------------- Không tồn tại khách hàng đó! -------------------------");
                        return;
                    }
                    System.out.println("Khách hàng có id bạn vừa nhập là: " + customer);

                    BuyItemList buyItemList = new BuyItemList(customer);
                    Map<Item, Integer> listBuyItem = new HashMap<>();


                    while (true) {
                        System.out.println("Nhập id của mặt hàng bạn muốn mua (nhập 0 để dừng lại): ");
                        int idItem = scanner.nextInt();
                        if(idItem == 0) {
                            break;
                        }
                        Item item = itemManagement.findItemById(idItem);
                        if(item != null) {
                            while (true){
                                System.out.println("Nhập số luợng bạn muốn mua (lớn hơn 0 hoặc nhập -1 để dừng lại): ");
                                int quantity = scanner.nextInt();
                                if(quantity <= 0 && quantity != -1) {
                                    System.out.println("----------------- Hãy nhập số lượng lớn hơn 0!! -----------------");
                                }else if(quantity == -1){
                                    break;
                                } else {
                                    listBuyItem.put(item, quantity);
                                    System.out.println("------------> Bạn vừa đăng ký mua mặt hàng: " + item);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("------------------- Mặt hàng đó không tồn tại!. -------------------");
                        }
                    }
                    if(listBuyItem.isEmpty()) {
                        System.out.println("Bạn đã hủy yêu cầu 5.");
                    } else {
                        buyItemList.addItem(listBuyItem);
                        buyItemList.saveToFile();
                    }
                    break;
            }
        }while (chooseOption != 0);
    }

    private static void addItem(ItemManagement itemManagement) {
        System.out.println("Nhập tên mặt hàng: ");
        scanner.nextLine();
        String nameItem = scanner.nextLine();
        System.out.println("Nhập nhóm hàng (0.HANG_THOI_TRANG, 1.HANG_TIEU_DUNG, 2.HANG_DIEN_MAY, 3.HANG_GIA_DUNG):");
        int choiceItemGroup = scanner.nextInt();
        ItemGroup itemGroup = ItemGroup.values()[choiceItemGroup];
        System.out.println("Nhập giá mặt hàng: ");
        double price = scanner.nextDouble();
        Item newItem = new Item(nameItem, itemGroup, price);
        itemManagement.addItem(newItem);
        System.out.println("------------------------ Thêm mặt hàng mới thành công! ------------------------");
    }

    private static void addCustomer(CustomerManagement customerManagement) {
        System.out.println("Nhập tên khách hàng: ");
        scanner.nextLine();
        String nameCustomer = scanner.nextLine();
        System.out.println("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();
        System.out.println("Nhập số điện thoại khách hàng: ");
        String phone = scanner.nextLine();
        System.out.println("Nhập loại khách hàng (0.MUA_LE, 1.MUA_BUON):");
        int choiceCustomerType = scanner.nextInt();
        CustomerType customerType = CustomerType.values()[choiceCustomerType];
        Customer newCustomer = new Customer(nameCustomer, address, phone, customerType);
        customerManagement.addCustomer(newCustomer);
        System.out.println("------------------------ Thêm khách hàng mới thành công! ------------------------");
    }
}
