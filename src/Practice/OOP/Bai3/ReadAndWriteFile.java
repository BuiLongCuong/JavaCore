package Practice.OOP.Bai3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReadAndWriteFile {
    File customerFile = new File("dataLessons/Lesson3/Customers.csv");
    File itemFile = new File("dataLessons/Lesson3/Items.csv");
    File buyItemFile = new File("dataLessons/Lesson3/BuyItems.csv");


    public void writeCustomerFile(ArrayList<Customer> list) {
        try {
            FileWriter fileWriter = new FileWriter(customerFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Customer customer : list) {
                line += customer.getIdCustomer() + "," + customer.getFullName() + "," + customer.getAddress() + "," + customer.getPhoneNumber() + "," + customer.getCustomerType() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Customer> readCustomerFile() {
        ArrayList<Customer> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(customerFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] dataCustomer = line.split(",");
                CustomerType customerType = Enum.valueOf(CustomerType.class, dataCustomer[4].trim().toUpperCase());
                Customer customer = new Customer(dataCustomer[1], dataCustomer[2], dataCustomer[3], customerType);
                list.add(customer);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void writeItemFile(ArrayList<Item> list) {
        try {
            FileWriter fileWriter = new FileWriter(itemFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Item item : list) {
                line += item.getIdItem() + "," + item.getNameItem() + "," + item.getItemGroup() + "," + item.getPrice() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Item> readItemFile() {
        ArrayList<Item> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(itemFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] dataItem = line.split(",");
                ItemGroup itemGroup = Enum.valueOf(ItemGroup.class, dataItem[2].trim().toUpperCase());
                Item item = new Item(dataItem[1], itemGroup, Double.parseDouble(dataItem[3]));
                list.add(item);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public void writeBuyItemFile(BuyItemList buyItemList) {
        try{
            FileWriter fileWriter = new FileWriter(buyItemFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String infoCustomer = "";
            bufferedWriter.write("------------- Thông tin khách hàng ------------- \n");
            Customer customer = buyItemList.getCustomer();
            infoCustomer += "ID: " + customer.getIdCustomer() + "," + customer.getFullName() + "," + customer.getAddress() + "," + customer.getPhoneNumber() + "," + customer.getCustomerType() + "\n";
            bufferedWriter.write(infoCustomer);

            bufferedWriter.write("------------- Danh sách các mặt hàng ------------- \n");
            for (Map.Entry<Item, Integer> entry : buyItemList.getItemList().entrySet()) {
                Item item = entry.getKey();
                Integer quantity = entry.getValue();
                String infoItem = "ID: " + item.getIdItem() + "," + item.getNameItem() + "," + item.getItemGroup() + "," + item.getPrice() + "," + "với số lượng là " + "," + quantity + "\n";
                bufferedWriter.write(infoItem);
            }
            bufferedWriter.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public BuyItemList readBuyItemFile() {
        BuyItemList buyItemList = null;
        Map<Item, Integer> list = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(buyItemFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            if((line = bufferedReader.readLine()) != null && !line.equals("------------- Thông tin khách hàng ------------- ")){
                String[] dataCustomer = line.split(",");
                CustomerType customerType = Enum.valueOf(CustomerType.class, dataCustomer[4].trim().toUpperCase());
                Customer customer = new Customer(dataCustomer[1],  dataCustomer[2], dataCustomer[3],  customerType);
                buyItemList = new BuyItemList(customer);
            }

            while ((line = bufferedReader.readLine()) != null && line.equals("------------- Danh sách các mặt hàng ------------- ")) {
                if(line.equals("Danh sách các mặt hàng: ")) {
                    continue;
                }
                String[] dataItem = line.split(",");
                ItemGroup itemGroup = Enum.valueOf(ItemGroup.class, dataItem[2].trim().toUpperCase());
                Item item = new Item(dataItem[1],  itemGroup, Double.parseDouble(dataItem[3]));
                list.put(item, Integer.parseInt(dataItem[5]));
            }

            if(buyItemList != null) {
                buyItemList.addItem(list);
            }
            bufferedReader.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return buyItemList;
    }
}
