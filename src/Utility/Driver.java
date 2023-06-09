package Utility;

import Accounts.Admin;
import Accounts.Employee;
import Purchase.Cart;
import Purchase.Invoice;
import Sports_equipment.Clothes;
import Sports_equipment.Clothes_utility;
import Sports_equipment.Equipment;
import Sports_equipment.Equipment_utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static Utility.Misc.*;

public class Driver
{
    Equipment_utility equipment_utility;
    Clothes_utility clothes_utility;
    Cart cart;
    HashMap<String,Admin> admins;
    HashMap<String,Employee>employees;
    ArrayList<Log_in_info>log_in_infos;
    ArrayList<Invoice>invoices;
    public static String current_user="none";
    public static int invoice_serial=1;
    boolean logged_in;

    public Driver()
    {
        equipment_utility=new Equipment_utility();
        clothes_utility=new Clothes_utility();
        admins=new HashMap<>();
        employees=new HashMap<>();
        log_in_infos=new ArrayList<>();
        this.cart=new Cart();
        invoices=new ArrayList<>();


        //dummy admins and employees
        admins.put("sifat@gmail.com", new Admin("Sifat", Misc.generate_id("ad"), "123", "01789636985", "sifat@gmail.com"));
        employees.put("rahul@gmail.com", new Employee("Ragul", Misc.generate_id("emp"), "123", "01447852369", "rahul@gmail.com", "Shop_1"));
        employees.put("atul@gmail.com", new Employee("Atul", Misc.generate_id("emp"), "123", "01447852369", "atul@gmail.com", "Shop_2"));
        employees.put("oshim@gmail.com", new Employee("Oshim", Misc.generate_id("emp"), "123", "01447852369", "oshim@gmail.com", "Shop_3"));
    }


    public void create_account(String type)
    {
        if(logged_in)
        {
            System.out.println("Please Sign out of "+current_user+" first\n");
            return;
        }

        Scanner cin=new Scanner(System.in);
        System.out.print("Email: ");
        String email=cin.nextLine();

        if(!email_validation(email))
        {
            System.out.println("Enter a valid email id\n");
            return;
        }

        if(type.equals("admin") && admins.get(email)==null)
        {
            System.out.print("Password (Suggested: "+generate_pass()+"): ");
            String password=cin.next();

            System.out.print("Username: ");
            cin.nextLine();
            String name=cin.nextLine();

            String id=generate_id("ad");

            System.out.print("Enter Phone Number: ");
            String phone=cin.nextLine();

            admins.put(email, new Admin(name, id, password, phone, email));

            System.out.println("Account Created Successfully\n");
        }
        else if(type.equals("emp") && employees.get(email)==null)
        {
            System.out.print("Password (Suggested: "+generate_pass()+"): ");
            String password=cin.next();

            System.out.print("Employee Name: ");
            cin.nextLine();
            String name=cin.nextLine();

            String id=generate_id("em");

            System.out.print("Enter Phone Number: ");
            String phone=cin.nextLine();

            System.out.print("Enter Affiliated Shop name: ");
            String af_shop=cin.nextLine();

            employees.put(email, new Employee(name, id, password, phone, email, af_shop));

            System.out.println("Account Created Successfully\n");
        }
        else
        {
            System.out.println("Account already exists with this email.\n");
        }
    }

    public boolean sign_in(String type)
    {
        if(logged_in)
        {
            System.out.println("Please Sign out of "+current_user+" first\n");
            return false;
        }

        Scanner cin=new Scanner(System.in);
        System.out.print("Email: ");
        String email=cin.nextLine();

        if(type.equals("admin")) return get_email_status(cin, email, admins.get(email) == null, admins.get(email).getPass());
        else return get_email_status(cin, email, employees.get(email) == null, employees.get(email).getPass());
    }

    private boolean get_email_status(Scanner cin, String email, boolean b, String pass)
    {
        if(b)
        {
            System.out.println("Email not found\n");
            return false;
        }


        System.out.print("Password: ");
        String password=cin.nextLine();

        if(!pass.equals(password))
        {
            System.out.println("Wrong Password\n");
            return false;
        }

        logged_in=true;
        current_user=email;

        String time=get_current_time();
        log_in_infos.add(new Log_in_info(time, current_user));

        System.out.println("Logged in successfully\n");
        return true;
    }


    public void sign_out()
    {
        if(!logged_in)
        {
            System.out.println("Not logged in\n");
            return;
        }

        logged_in=false;
        current_user="none";
        System.out.println("Logged out\n");
    }

    public void reset_pass(String type)
    {
        if(!logged_in)
        {
            System.out.println("Not logged in\n");
            return;
        }

        System.out.print("Enter new password: ");
        Scanner cin=new Scanner(System.in);
        String new_password=cin.nextLine();

        if(type.equals("admin")) {
            if (admins.get(current_user).getPass().equals(new_password))
            {
                System.out.println("New password cannot be the same as current password\n");
                return;
            }
            else admins.get(current_user).setPass(new_password);
        }
        else
        {
            if (employees.get(current_user).getPass().equals(new_password))
            {
                System.out.println("New password cannot be the same as current password\n");
                return;
            }
            else employees.get(current_user).setPass(new_password);
        }


        System.out.println("Password reset successfully\n");
    }

    public void view_log_ins()
    {
        System.out.println("----------------------------------------");
        for(Log_in_info log: log_in_infos)
        {
            log.display();
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }

    public void view_all_employees()
    {
        System.out.println("----------------------------------------");
        employees.forEach((key, value) -> value.display_info());
        System.out.println("----------------------------------------");
    }

    public void buy_product(String type)
    {
        String id;
        int quantity;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Product ID: "); id=sc.nextLine();

        if(type.equals("eq"))
        {
            Equipment eq=equipment_utility.get_equipment(id);
            if(eq==null)
            {
                System.out.println("Equipment not found\n");
                return;
            }

            if(eq.getQuantity()==0)
            {
                System.out.println("Out of stock");
                return;
            }

            System.out.println("Number of items to be purchased: "); quantity=sc.nextInt();

            if(eq.getQuantity() < quantity)
            {
                System.out.println("Not enough stock\n");
                return;
            }

            equipment_utility.decrease_quantity(id, quantity);
            cart.add_equipment(eq, quantity);

        }
        else
        {
            Clothes cl=clothes_utility.get_clothes(id);
            if(cl==null)
            {
                System.out.println("Clothes not found\n");
                return;
            }

            if(cl.getQuantity()==0)
            {
                System.out.println("Out of stock");
                return;
            }

            System.out.println("Number of items to be purchased: "); quantity=sc.nextInt();

            if(cl.getQuantity() < quantity)
            {
                System.out.println("Not enough stock\n");
                return;
            }

            clothes_utility.decrease_quantity(id, quantity);
            cart.add_clothes(cl, quantity);
        }
    }

    public void show_cart()
    {
        cart.display_cart();
    }

    public void make_invoice()
    {
        String bill_to;
        String shop_name;
        Scanner sc=new Scanner(System.in);
        System.out.print("Bill to: "); bill_to=sc.nextLine();
        System.out.print("Enter Shop name: "); shop_name=sc.nextLine();

        Invoice invoice=new Invoice(bill_to, shop_name, cart);
        invoice.show_invoice();

        invoices.add(invoice);
    }

    public void show_all_invoices()
    {
        System.out.println("----------------------------------------");
        for(Invoice invoice: invoices) invoice.show_invoice();
        System.out.println("----------------------------------------");
    }
}
