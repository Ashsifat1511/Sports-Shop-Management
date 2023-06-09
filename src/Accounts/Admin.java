package Accounts;

import Utility.Driver;
import Utility.Misc;

public class Admin extends Account
{
    String pin;

    public Admin(String name, String id, String pass, String phone, String email)
    {
        super(name, id, pass, phone, email);
        this.pin= Misc.generate_pin();
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void display_info()
    {
        super.display_info();
        if(Driver.current_user.equals(email)) System.out.println("PIN: "+pin);
        System.out.println();
    }
}
