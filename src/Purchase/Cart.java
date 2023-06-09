package Purchase;

import Sports_equipment.Clothes;
import Sports_equipment.Equipment;

import java.util.HashMap;
import java.util.Map;

public class Cart
{
    HashMap<Equipment, Integer> equipments;
    HashMap<Clothes, Integer>clothes;

    public Cart()
    {
        this.equipments=new HashMap<>();
        this.clothes=new HashMap<>();
    }

    public void add_equipment(Equipment eq, int quantity)
    {
        equipments.put(eq, quantity);
    }

    public void add_clothes(Clothes cl, int quantity)
    {
        clothes.put(cl, quantity);
    }

    public int calculate_total()
    {
        int total=0;

        for(Map.Entry<Equipment, Integer> element: equipments.entrySet()) total+=element.getKey().getPrice()*element.getValue();
        for(Map.Entry<Equipment, Integer> element: equipments.entrySet()) total+=element.getKey().getPrice()*element.getValue();

        return total;
    }

    public void display_cart()
    {
        int serial=1;
        for(Map.Entry<Equipment, Integer> element: equipments.entrySet())
        {
            System.out.println("Item-"+serial++);
            element.getKey().display(false);
            System.out.println("Quantity: "+element.getValue());
            System.out.println("Sub total: "+element.getValue()*element.getKey().getPrice());
        }

        for(Map.Entry<Clothes, Integer> element: clothes.entrySet())
        {
            System.out.println("Item-"+serial++);
            element.getKey().display(false);
            System.out.println("Quantity: "+element.getValue());
            System.out.println("Sub total: "+element.getValue()*element.getKey().getPrice());
        }
    }
}
