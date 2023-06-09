package Sports_equipment;

import Utility.Misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Equipment_utility
{
    ArrayList<Equipment> equipment_inventory;

    public Equipment_utility() {
        this.equipment_inventory = new ArrayList<>();

        //dummy eq
        equipment_inventory.add(new Equipment("Football", "Nike", Misc.generate_id("eq"), 23, 890));
        equipment_inventory.add(new Equipment("Badminton Racket", "Yonex", Misc.generate_id("eq"), 13, 600));
        equipment_inventory.add(new Equipment("Shuttle Cock", "Yonex", Misc.generate_id("eq"), 100, 120));
    }

    public void add_equipment() {
        String name, brand, eq_id;
        int quantity;
        double price;
        Scanner sc = new Scanner(System.in);

        System.out.print("Equipment Name: ");
        name = sc.nextLine();
        System.out.print("Equipment Brand: ");
        brand = sc.nextLine();
        System.out.print("Equipment Quantity: ");
        quantity = sc.nextInt();
        System.out.print("Equipment Price: ");
        price = sc.nextDouble();
        eq_id = Misc.generate_id("eq");
        equipment_inventory.add(new Equipment(name, brand, eq_id, quantity, price));
        System.out.println("Equipment successfully added.\n");
    }

    public boolean remove_equipment(String id) {
        boolean found = false;

        for (Equipment eq : equipment_inventory) {
            if (eq.getid().equals(id)) {
                found = true;
                equipment_inventory.remove(eq);
                break;
            }
        }

        return found;
    }

    public void edit_equipment()
    {
        int option, index=-1;
        String eq_id;
        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter Equipment ID: "); eq_id=sc.nextLine();

        boolean found=false;
        for(Equipment e: equipment_inventory)
        {
            if(e.getid().equals(eq_id))
            {
                found=true;
                index=equipment_inventory.indexOf(e);
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
                equipment_inventory.get(index).setName(name);
            }

            case 2 -> {
                System.out.print("Enter quantity: ");
                int quantity=sc.nextInt();
                equipment_inventory.get(index).setQuantity(quantity);
            }

            case 3 -> {
                System.out.print("Enter Brand: ");
                String brand=sc.nextLine();
                equipment_inventory.get(index).setBrand(brand);
            }

            case 4 -> {
                System.out.print("Enter price: ");
                double price=sc.nextDouble();
                equipment_inventory.get(index).setPrice(price);
            }

            default -> System.out.println("Invalid Option");
        }

        System.out.println("Information updated successfully\n");
    }

    public Equipment get_equipment(String id)
    {
        Equipment temp=null;
        for (Equipment equipment : equipment_inventory) {
            if(equipment.getid().equals(id))
            {
                temp=equipment;
                break;
            }
        }

        return temp;
    }

    public void decrease_quantity(String id, int amount)
    {
        for (Equipment eq : equipment_inventory) {
            if(eq.getid().equals(id))
            {
                eq.setQuantity(eq.getQuantity()-amount);
                break;
            }
        }
    }

    public void sort_by_name()
    {
        equipment_inventory.sort(Comparator.comparing(Equipment::getName));
    }

    public void sort_by_brand()
    {
        equipment_inventory.sort(Comparator.comparing(Equipment::getBrand));
    }

    public void sort_by_price()
    {
        equipment_inventory.sort(Comparator.comparing(Equipment::getPrice));
    }

    public void sort_by_quantity()
    {
        equipment_inventory.sort(Comparator.comparing(Equipment::getQuantity));
    }

    public void display()
    {
        System.out.println("----------------------------------------");
        for(Equipment eq:equipment_inventory)
        {
            eq.display(true);
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }
}
