package Practice.OOP.Bai4;

import java.util.HashMap;
import java.util.Map;

public class SellProduct {
    private Staff staff;
    private Map<Product, Integer> sellProductList;
    private ReadAndWriteFile readAndWriteFile;

    public SellProduct(Staff staff) {
        readAndWriteFile = new ReadAndWriteFile();
        this.staff = staff;
        this.sellProductList = new HashMap<>();
    }

    public void addProduct(Map<Product, Integer> list) {
        if (list.size() <= 5) {
            if (sellProductList.size() + list.size() <= 5) {
                for (Map.Entry<Product, Integer> entry : list.entrySet()) {
                    Product product = entry.getKey();
                    Integer requestQuantity = entry.getValue();
                    if (!sellProductList.containsKey(product)) {
                        int quantityOfProduct = getQuantityOfProductById(product.getIdProduct());
                        int remainingStock;

                        if (requestQuantity < quantityOfProduct) {
                            remainingStock = quantityOfProduct - requestQuantity;
                            System.out.println("Mặt hàng " + product.getNameProduct() + " còn " + remainingStock + " sản phẩm.");
                            sellProductList.put(product, requestQuantity);
                        } else if (requestQuantity > quantityOfProduct) {
                            System.out.println("Số sản phẩm của mặt hàng " + product.getNameProduct() + "là " + quantityOfProduct + " sản phẩm " + "và bạn vừa đăng kí 1 mình bạn bán hết.");
                            sellProductList.put(product, requestQuantity);
                        }
                    } else {
                        System.out.println("Mặt hàng này bạn đã tham gia trước đó rồi.");
                    }
                }
            } else {
                System.out.println("Tổng số mặt hàng khác nhau bạn đã tham gia bán ko được nhiều hơn 5.");
            }
        } else {
            System.out.println("Mỗi nhân viên chỉ tham gia bán tối đa 5 mặt hàng khác nhau");
        }
    }

    public int getQuantityOfProductById(int id) {
        for (Map.Entry<Product, Integer> entry : sellProductList.entrySet()) {
            if (entry.getKey().getIdProduct() == id) {
                return entry.getKey().getQuantity();
            }
        }
        return -1;
    }

    public void saveFile() {
//        sellProductList = readAndWriteFile.w
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Map<Product, Integer> getSellProductList() {
        return sellProductList;
    }

    public void setSellProductList(Map<Product, Integer> sellProductList) {
        this.sellProductList = sellProductList;
    }

    public ReadAndWriteFile getReadAndWriteFile() {
        return readAndWriteFile;
    }

    public void setReadAndWriteFile(ReadAndWriteFile readAndWriteFile) {
        this.readAndWriteFile = readAndWriteFile;
    }
}
