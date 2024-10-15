package Practice.OOP.Bai4;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class ReadAndWriteFile {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    File productFile = new File("dataLessons/Lesson4/Products.csv");
    File staffFile = new File("dataLessons/Lesson4/Staffs.csv");
    File sellProductFile = new File("dataLessons/Lesson4/SellProducts.csv");

    public void writeProductFile(ArrayList<Product> list){
        try{
            FileWriter fileWriter = new FileWriter(productFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Product product : list) {
                line += product.getIdProduct() + "," + product.getNameProduct() + "," + product.getProductGroup() + "," + product.getPrice() + "," + product.getQuantity() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Product> readProductFile() {
        ArrayList<Product> list = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(productFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] dataProduct = line.split(",");
                ProductGroup productGroup = Enum.valueOf(ProductGroup.class, dataProduct[2].trim().toUpperCase());
                Product product = new Product(dataProduct[1], productGroup ,Double.parseDouble(dataProduct[3]), Integer.parseInt(dataProduct[4]));
                list.add(product);
            }
            bufferedReader.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void writeStaffFile(ArrayList<Staff> list){
        try{
            FileWriter fileWriter = new FileWriter(staffFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Staff staff : list) {
                line += staff.getIdStaff() + "," + staff.getFullName() + "," + staff.getAddress() + "," + staff.getPhoneNumber() + "," + staff.getContactDate() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Staff> readStaffFile() {
        ArrayList<Staff> list = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(staffFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] dataStaff = line.split(",");
                Staff staff = new Staff(dataStaff[1], dataStaff[2] , dataStaff[3], dataStaff[4]);
                list.add(staff);
            }
            bufferedReader.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void writeSellProductFile(SellProduct sellProduct){
        try{
            FileWriter fileWriter = new FileWriter(sellProductFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String infoStaff = "";
            bufferedWriter.write("---------- Thông tin nhân viên ---------- \n");
            Staff staff = sellProduct.getStaff();
            infoStaff += "ID" + staff.getIdStaff() + "," + staff.getFullName() + "," + staff.getAddress() + "," + staff.getPhoneNumber() + "," + staff.getContactDate() + "\n";
            bufferedWriter.write(infoStaff);

            bufferedWriter.write("---------- Thông tin mặt hàng ---------- \n");
            for (Map.Entry<Product, Integer> entry : sellProduct.getSellProductList().entrySet()) {
                Product product = entry.getKey();
                Integer quantity = entry.getValue();
                String infoProduct = "ID:" + product.getIdProduct() + "," + product.getNameProduct() + "," + product.getProductGroup() + "," + product.getPrice() + "," + product.getQuantity() + "," +" được đăng ký bán " + "," + quantity +"\n";
                bufferedWriter.write(infoProduct);
            }
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
