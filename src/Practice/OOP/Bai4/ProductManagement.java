package Practice.OOP.Bai4;

import java.util.ArrayList;

public class ProductManagement {
    private ArrayList<Product> productList;
    private ReadAndWriteFile readAndWriteFile;

    public ProductManagement(){
        readAndWriteFile = new ReadAndWriteFile();
        this.productList = readAndWriteFile.readProductFile();
    }

    public void showAll(){
        System.out.println("--------------- Danh sách sản phẩm ---------------");
        for (Product product: productList) {
            System.out.println(product);
        }
        System.out.println("---------------------------------------------------");
    }

    public void addProduct(Product newProduct){
        productList.add(newProduct);
        readAndWriteFile.writeProductFile(productList);
    }
}
