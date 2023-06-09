package Accounts;

abstract class Account
{
    String name;
    String id;
    String pass;
    String phone;
    String email;

    public Account(String name, String id, String pass, String phone, String email)
    {
        this.name = name;
        this.id = id;
        this.pass = pass;
        this.phone = phone;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void display_info()
    {
        System.out.println("Name: "+name);
        System.out.println("Id: "+id);
        System.out.println("Phone: "+phone);
        System.out.println("Email: "+email);
    }
}
