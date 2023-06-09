package Sports_equipment;

abstract class Product
{
    String name;
    String brand;
    String id;
    int quantity;
    double price;

    public Product(String name, String brand, String id, int quantity, double price) {
        this.name = name;
        this.brand = brand;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public Product()
    {
        this.name = "";
        this.brand = "";
        this.id= "";
        this.quantity = 0;
        this.price=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display(boolean menu)
    {
        if(menu) System.out.println(" ID: "+this.id);
        System.out.println(" Name: "+this.name);;
        System.out.println(" Brand: "+this.brand);
        if(menu) System.out.println(" Quantity: "+this.quantity);
        System.out.println(" Price: "+this.price);
    }
}
