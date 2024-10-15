package Practice.OOP.Bai3;

import java.util.HashMap;
import java.util.Map;

public class BuyItemList {
    private Customer customer;
    Map<Item, Integer> itemList;
    private ReadAndWriteFile readAndWriteFile;


    public BuyItemList(Customer customer) {
        this.customer = customer;
        readAndWriteFile = new ReadAndWriteFile();

        BuyItemList buyItemListSaved = readAndWriteFile.readBuyItemFile();
        if(buyItemListSaved != null) {
            this.itemList = buyItemListSaved.getItemList();
        }else {
            this.itemList = new HashMap<>();
        }
//        this.itemList = readAndWriteFile.readBuyItemFile().getItemList();
//        this.itemList = new HashMap<>();
    }

    public void addItem(Map<Item, Integer> buyItemList) {
        if (buyItemList.size() <= 10) {
            if (itemList.size() + buyItemList.size() <= 10) {
                for (Map.Entry<Item, Integer> entry : buyItemList.entrySet()) {
                    Item item = entry.getKey();
                    Integer quantity = entry.getValue();
                    if (!itemList.containsKey(item)) {
                        itemList.put(item, quantity);
                    } else {
                        System.out.println("Mặt hàng " + item + "đã được đặt trước đó rồi.");
                    }
                }
            } else {
                System.out.println("Tổng số lượng hàng bạn đã mua ko được quá 10 loại mặt hàng.");
            }
        } else {
            System.out.println("Mỗi khách hàng không mua quá 10 loại mặt hàng một lần !.");
        }
    }

    public void saveToFile() {
        readAndWriteFile.writeBuyItemFile(this);
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Item, Integer> getItemList() {
        return itemList;
    }

    public void setItemList(Map<Item, Integer> itemList) {
        this.itemList = itemList;
    }
}
