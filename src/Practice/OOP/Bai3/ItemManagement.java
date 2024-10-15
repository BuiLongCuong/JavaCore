package Practice.OOP.Bai3;

import java.util.ArrayList;

public class ItemManagement {
    private ArrayList<Item> itemList;
    private ReadAndWriteFile readAndWriteFile;

    public ItemManagement(){
        readAndWriteFile = new ReadAndWriteFile();
        this.itemList = readAndWriteFile.readItemFile();
    }

    public void addItem(Item newItem){
        itemList.add(newItem);
        readAndWriteFile.writeItemFile(itemList);
    }

    public void showAll() {
        System.out.println("---------------------- Danh sách mặt hàng ----------------------");
        for (Item item: itemList) {
            System.out.println(item);
        }
        System.out.println("-------------------------------------------------------------------");
    }

    public Item findItemById(int id) {
        for (Item item : itemList) {
            if(item.getIdItem() == id) {
                return item;
            }
        }
        return null;
    }
}
