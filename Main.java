import java.awt.*;
import java.util.Scanner;

class Item
{
    private String Name;
    private double Price;
    private String Code;
    public Item(String name, String code)
    {
        Price = 0;// initial Price as 0
        Name = name;
        Code = code;
    }

    public double getPrice() {
        return Price;
    }

    public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setName(String name) {
        Name = name;
    }

    public void Display(){
        System.out.println("Name: " + Name + "; " + "code: "+ Code + "; " + "Price: " + Price + ";" );
    }

}

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //creat variables of five Item class space sizes
        Item[] bill = new Item[5];
        for(int i = 0; i < 5; i++)
        {
            System.out.print("Enter item "+ (i+1) + " (name, price, code) ");
            String name = sc.next();
            double price = sc.nextDouble();
            String code = sc.next();

            //creat a class called item and call constructor
            Item item = new Item(name, code);
            item.setPrice(price);
            bill[i] = item;
        }
        double totalPayment = 0;

        for(int i = 0; i < 5; i++)
        {
            System.out.println("Item "+ (i+1));
            //call the member function
            bill[i].Display();

            //call the member function
            totalPayment += bill[i].getPrice();
        }

        System.out.println("Total Payment: "+ totalPayment);
    }
}
