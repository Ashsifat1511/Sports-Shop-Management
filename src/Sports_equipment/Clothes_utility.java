package Sports_equipment;

import Utility.Misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Clothes_utility
{
    ArrayList<Clothes> clothes_inventory;

    public Clothes_utility()
    {
        this.clothes_inventory=new ArrayList<>();

        //dummy clothes
        clothes_inventory.add(new Clothes("T-shirt", "Infinity", Misc.generate_id("cl"), 50, 420));
        clothes_inventory.add(new Clothes("Shorts", "Halo", Misc.generate_id("cl"), 70, 700));
        clothes_inventory.add(new Clothes("Shin Guard", "Nike", Misc.generate_id("cl"), 50, 300));
    }

    public void add_clothes()
    {
        String name, brand, eq_id;
        int quantity;
        double price;
        Scanner sc=new Scanner(System.in);

        System.out.print("Clothes Name: "); name=sc.nextLine();
        System.out.print("Clothes Brand: "); brand=sc.nextLine();
        System.out.print("Clothes Quantity: "); quantity=sc.nextInt();
        System.out.print("Clothes Price: "); price=sc.nextDouble();
        eq_id= Misc.generate_id("eq");
        clothes_inventory.add(new Clothes(name, brand, eq_id, quantity, price));
        System.out.println("Clothes successfully added.\n");
    }

    public boolean remove_Clothes(String id)
    {
        boolean found=false;

        for(Clothes eq:clothes_inventory)
        {
            if(eq.getid().equals(id))
            {
                found=true;
                clothes_inventory.remove(eq);
                break;
            }
        }

        return found;
    }

    public void edit_clothes()
    {
        int option, index=-1;
        String eq_id;
        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter clothes ID: "); eq_id=sc.nextLine();

        boolean found=false;
        for(Clothes e: clothes_inventory)
        {
            if(e.getid().equals(eq_id))
            {
                found=true;
                index=clothes_inventory.indexOf(e);
                break;
            }
        }

        if(!found)
        {
            System.out.println("Product ID not found\n");
            return;
        }

        System.out.println("1.  Edit Name ");
        System.out.println("2.  Edit Quantity ");
        System.out.println("3.  Edit Brand ");
        System.out.println("4.  Edit price \n");

        System.out.print("Choose edit option: "); option=sc.nextInt();

        switch (option)
        {
            case 1 -> {
                System.out.print("Enter new name: ");
                String name=sc.nextLine();
                clothes_inventory.get(index).setName(name);
            }

            case 2 -> {
                System.out.print("Enter quantity: ");
                int quantity=sc.nextInt();
                clothes_inventory.get(index).setQuantity(quantity);
            }

            case 3 -> {
                System.out.print("Enter Brand: ");
                String brand=sc.nextLine();
                clothes_inventory.get(index).setBrand(brand);
            }

            case 4 -> {
                System.out.print("Enter price: ");
                double price=sc.nextDouble();
                clothes_inventory.get(index).setPrice(price);
            }

            default -> System.out.println("Invalid Option");
        }

        System.out.println("Information updated successfully\n");
    }

    public Clothes get_clothes(String id)
    {
        Clothes temp=null;
        for (Clothes cl : clothes_inventory) {
            if(cl.getid().equals(id))
            {
                temp=cl;
                break;
            }
        }

        return temp;
    }

    public void decrease_quantity(String id, int amount)
    {
        for (Clothes cl : clothes_inventory) {
            if(cl.getid().equals(id))
            {
                cl.setQuantity(cl.getQuantity()-amount);
                break;
            }
        }
    }

    public void sort_by_name()
    {
        clothes_inventory.sort(Comparator.comparing(Clothes::getName));
    }

    public void sort_by_brand()
    {
        clothes_inventory.sort(Comparator.comparing(Clothes::getBrand));
    }

    public void sort_by_price()
    {
        clothes_inventory.sort(Comparator.comparing(Clothes::getPrice));
    }

    public void sort_by_quantity()
    {
        clothes_inventory.sort(Comparator.comparing(Clothes::getQuantity));
    }

    public void display()
    {
        System.out.println("----------------------------------------");
        for(Clothes eq:clothes_inventory)
        {
            eq.display(true);
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }
}
