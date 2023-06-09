package Accounts;

public class Employee extends Account
{
    String affiliated_shop;
    public Employee(String name, String id, String pass, String phone, String email, String affiliated_shop) {
        super(name, id, pass, phone, email);
        this.affiliated_shop=affiliated_shop;
    }

    public String getAffiliated_shop() {
        return affiliated_shop;
    }

    public void setAffiliated_shop(String affiliated_shop) {
        this.affiliated_shop = affiliated_shop;
    }

    public void display_info()
    {
        super.display_info();
        System.out.println("Affiliated Shop "+affiliated_shop);
        System.out.println();
    }
}
