package Practice.OOP.Bai4;

enum ProductGroup {
    DIEN_TU,
    DIEN_LANH,
    MAY_TINH,
    THIET_BI_VAN_PHONG
}

public class Product {
    private int idProduct;
    private static int idIncrement = 1;
    private String nameProduct;
    private ProductGroup productGroup;
    private double price;
    private int quantity;

    public Product(String nameProduct, ProductGroup productGroup, double price, int quantity) {
        this.idProduct = idIncrement;
        this.nameProduct = nameProduct;
        this.productGroup = productGroup;
        this.price = price;
        this.quantity = quantity;
        idIncrement++;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", productGroup=" + productGroup +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
