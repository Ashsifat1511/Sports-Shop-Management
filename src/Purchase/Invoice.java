package Purchase;

import Utility.Driver;
import Utility.Misc;

public class Invoice
{
    Cart cart;
    String time;
    String bill_to;
    String shop_name;
    int invoice_no;

    public Invoice(String bill_to, String shop_name, Cart cart)
    {
        this.cart=cart;
        this.invoice_no= Driver.invoice_serial++;
        this.time= Misc.get_current_time();
        this.shop_name=shop_name;
        this.bill_to=bill_to;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBill_to() {
        return bill_to;
    }

    public void setBill_to(String bill_to) {
        this.bill_to = bill_to;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public int getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(int invoice_no) {
        this.invoice_no = invoice_no;
    }

    public void show_invoice()
    {
        System.out.println("---------------------------------------");
        System.out.println(time);
        System.out.println("Invoice no: "+invoice_no);
        System.out.println("Bill to: "+bill_to);
        System.out.println("Shop: "+shop_name);
        cart.display_cart();
        System.out.println("\nGrand total: "+cart.calculate_total());
        System.out.println("----------------------------------------");
    }
}
