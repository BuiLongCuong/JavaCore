package Practice.OOP.Bai3;

enum ItemGroup {
    HANG_THOI_TRANG,
    HANG_TIEU_DUNG,
    HANG_DIEN_MAY,
    HANG_GIA_DUNG
}
public class Item {
    private int idItem;
    private static int idIncrement = 1;
    private String nameItem;
    private ItemGroup itemGroup;
    private double price;

    public Item(String nameItem, ItemGroup itemGroup, double price) {
        this.idItem = idIncrement;
        this.nameItem = nameItem;
        this.itemGroup = itemGroup;
        this.price = price;
        idIncrement++;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", nameItem='" + nameItem + '\'' +
                ", itemGroup=" + itemGroup +
                ", price=" + price +
                '}';
    }
}
