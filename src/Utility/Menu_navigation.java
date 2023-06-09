package Utility;

import Purchase.Invoice;

import java.util.Scanner;

import static Utility.Driver.current_user;

public class Menu_navigation
{
    Driver driver;
    int choice;

    public Menu_navigation()
    {
        driver=new Driver();
    }

    public void initial_menu_nav()
    {
        while(true)
        {
            initial_menu();
            Scanner sc=new Scanner(System.in);
            System.out.print("Choose Option: "); choice=sc.nextInt();

            if(choice==5) break;

            switch (choice)
            {
                case 1 -> {
                    boolean success=driver.sign_in("admin");
                    if(success) admin_menu_nav();
                }

                case 2 -> {
                    boolean success=driver.sign_in("emp");
                    if(success) employee_manu_nav();
                }
                case 3 -> driver.create_account("admin");
                case 4 -> customer_menu_nav();

                default -> System.out.println("Invalid option\n");
            }
        }
    }

    public void admin_menu_nav()
    {
        while(true)
        {
            admin_menu();
            Scanner sc=new Scanner(System.in);
            System.out.print("Choose Option: "); choice=sc.nextInt();

            if(choice==9) return;

            switch (choice)
            {
                case 1 -> driver.admins.get(current_user).display_info();
                case 2 -> driver.reset_pass("admin");
                case 3 -> driver.view_all_employees();
                case 4 -> product_menu_nav();
                case 5 -> driver.create_account("emp");
                case 7 -> driver.view_log_ins();
                case 8 -> {
                    driver.sign_out();
                    return;
                }

                default -> System.out.println("Invalid option\n");
            }
        }

    }

    private void employee_manu_nav()
    {
        while(true)
        {
            employee_menu();
            Scanner sc=new Scanner(System.in);
            System.out.print("Choose Option: "); choice=sc.nextInt();

            if(choice==7) return;

            switch (choice)
            {
                case 1 -> driver.employees.get(current_user).display_info();
                case 2 -> driver.reset_pass("emp");
                case 3 -> {
                    System.out.print("Enter invoice no: ");
                    int invoice_no=sc.nextInt();

                    for(Invoice invoice: driver.invoices)
                    {
                        if(invoice.getInvoice_no()==invoice_no)
                        {
                            invoice.show_invoice();
                            break;
                        }
                    }
                }
                case 4 -> driver.show_all_invoices();
                case 5 -> product_menu_nav();
                case 6 -> {
                    driver.sign_out();
                    return;
                }
                default -> System.out.println("Invalid option\n");
            }
        }
    }

    private void product_menu_nav()
    {
        while(true)
        {
            products_menu();
            Scanner sc=new Scanner(System.in);
            System.out.print("Choose Option: "); choice=sc.nextInt();

            if(choice==3) return;

            switch (choice)
            {
                case 1 -> view_equipment_nav();

                case 2 -> view_clothes_nav();

                default -> System.out.println("Invalid option\n");
            }
        }
    }

    private void view_equipment_nav()
    {
        while(true)
        {
            view_equipment_menu();
            Scanner sc=new Scanner(System.in);
            System.out.print("Choose Option: "); choice=sc.nextInt();

            if(choice==9) return;

            switch (choice)
            {
                case 1 -> driver.equipment_utility.edit_equipment();
                case 2 -> driver.equipment_utility.add_equipment();
                case 3 -> driver.equipment_utility.display();
                case 4 -> {
                    System.out.print("Enter the ID of equipment to be removed: ");
                    String eq_id=sc.next();
                    boolean success=driver.equipment_utility.remove_equipment(eq_id);
                    if(success) System.out.println("Removed Successfully\n");
                    else System.out.println("Could not remove\n");
                }
                case 5 -> driver.equipment_utility.sort_by_price();
                case 6 -> driver.equipment_utility.sort_by_name();
                case 7 -> driver.equipment_utility.sort_by_brand();
                case 8 -> driver.equipment_utility.sort_by_quantity();

                default -> System.out.println("Invalid option\n");
            }
        }
    }

    private void view_clothes_nav()
    {
        while(true)
        {
            view_clothes_menu();
            Scanner sc=new Scanner(System.in);
            System.out.print("Choose Option: "); choice=sc.nextInt();

            if(choice==9) return;

            switch (choice)
            {
                case 1 -> driver.clothes_utility.edit_clothes();
                case 2 -> driver.clothes_utility.add_clothes();
                case 3 -> driver.clothes_utility.display();
                case 4 -> {
                    System.out.print("Enter the ID of clothes to be removed: ");
                    String eq_id=sc.next();
                    boolean success=driver.clothes_utility.remove_Clothes(eq_id);
                    if(success) System.out.println("Removed Successfully\n");
                    else System.out.println("Could not remove\n");
                }
                case 5 -> driver.clothes_utility.sort_by_price();
                case 6 -> driver.clothes_utility.sort_by_name();
                case 7 -> driver.clothes_utility.sort_by_brand();
                case 8 -> driver.clothes_utility.sort_by_quantity();

                default -> System.out.println("Invalid option\n");
            }
        }
    }

    private void customer_menu_nav()
    {
        while(true)
        {
            customer_menu();
            Scanner sc=new Scanner(System.in);
            System.out.print("Choose Option: "); choice=sc.nextInt();

            if(choice==5) return;

            switch (choice)
            {
                case 1 -> customer_equipment_menu_nav();
                case 2 -> customer_clothes_menu_nav();
                case 3 -> driver.show_cart();
                case 4 -> driver.make_invoice();
            }
        }
    }

    private void customer_equipment_menu_nav()
    {
        while(true)
        {
            customer_equipment_menu();
            Scanner sc=new Scanner(System.in);
            System.out.print("Choose Option: "); choice=sc.nextInt();

            if(choice==7) return;

            switch (choice)
            {
                case 1 -> driver.equipment_utility.display();
                case 2 -> driver.buy_product("eq");
                case 3 -> driver.equipment_utility.sort_by_price();
                case 4 -> driver.equipment_utility.sort_by_name();
                case 5 -> driver.equipment_utility.sort_by_brand();
                case 6 -> driver.equipment_utility.sort_by_quantity();
            }
        }
    }

    private void customer_clothes_menu_nav()
    {
        while(true)
        {
            customer_clothes_menu();
            Scanner sc=new Scanner(System.in);
            System.out.print("Choose Option: "); choice=sc.nextInt();

            if(choice==7) return;

            switch (choice)
            {
                case 1 -> driver.clothes_utility.display();
                case 2 -> driver.buy_product("cl");
                case 3 -> driver.clothes_utility.sort_by_price();
                case 4 -> driver.clothes_utility.sort_by_name();
                case 5 -> driver.clothes_utility.sort_by_brand();
                case 6 -> driver.clothes_utility.sort_by_quantity();
            }
        }
    }

    public void initial_menu()
    {
        System.out.println("1.  Log in as Admin");
        System.out.println("2.  Log in as Employee");
        System.out.println("3.  Sign up as Admin");
        System.out.println("4.  Explore Products");
        System.out.println("5.  Exit\n");

        if(!current_user.equals("none")) System.out.println("Currently logged in as: "+current_user+"\n");
    }
    private void admin_menu()
    {
        System.out.println("1.  Show Account Information");
        System.out.println("2.  Reset Password");
        System.out.println("3.  View All Employees");
        System.out.println("4.  Filter Employees According to shop");
        System.out.println("4.  Manage Products");
        System.out.println("5.  Add an Employee");
        System.out.println("6.  Remove and Employee");
        System.out.println("7.  Show log in history");
        System.out.println("8.  Sign out");
        System.out.println("9.  Exit\n");

        if(!current_user.equals("none")) System.out.println("Currently logged in as: "+current_user+"\n");
    }
    private void employee_menu()
    {
        System.out.println("1.  Show Account Information");
        System.out.println("2.  Reset Password");
        System.out.println("3.  View Specific purchase info");
        System.out.println("4.  View All purchase info");
        System.out.println("5.  Manage products");
        System.out.println("6.  Sign out");
        System.out.println("7.  Exit\n");
    }
    private void products_menu()
    {
        System.out.println("1.  Equipments");
        System.out.println("2.  Clothes");
        System.out.println("3.  Exit\n");
    }
    private void view_equipment_menu()
    {
        System.out.println("1.  Edit Equipment info");
        System.out.println("2.  Add an Equipment");
        System.out.println("3.  View All Equipments");
        System.out.println("4.  Remove an Equipment");
        System.out.println("5.  Sort by price");
        System.out.println("6.  Sort by Name");
        System.out.println("7.  Sort by Brand");
        System.out.println("8.  Sort by Quantity");
        System.out.println("9.  Exit\n");
    }
    private void view_clothes_menu()
    {
        System.out.println("1.  Edit Clothes info");
        System.out.println("2.  Add an Clothes");
        System.out.println("3.  View All Clothes");
        System.out.println("4.  Remove an Clothes");
        System.out.println("5.  Sort by price");
        System.out.println("6.  Sort by Name");
        System.out.println("7.  Sort by Brand");
        System.out.println("8.  Sort by Quantity");
        System.out.println("9.  Exit\n");
    }
    private void customer_menu()
    {
        System.out.println("1.  Equipments");
        System.out.println("2.  Clothes");
        System.out.println("3.  View Cart");
        System.out.println("4.  Check Out");
        System.out.println("5.  Exit\n");
    }

    private void customer_equipment_menu()
    {
        System.out.println("1.  View All Equipments");
        System.out.println("2.  Buy an equipment");
        System.out.println("3.  Sort by price");
        System.out.println("4.  Sort by Name");
        System.out.println("5.  Sort by Brand");
        System.out.println("6.  Sort by Quantity");
        System.out.println("7.  Exit\n");
    }
    private void customer_clothes_menu()
    {
        System.out.println("1.  View All Clothes");
        System.out.println("2.  Buy Clothes");
        System.out.println("3.  Sort by price");
        System.out.println("4.  Sort by Name");
        System.out.println("5.  Sort by Brand");
        System.out.println("6.  Sort by Quantity");
        System.out.println("7.  Exit\n");
    }
}
