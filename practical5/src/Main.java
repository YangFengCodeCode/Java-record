//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.Scanner;

class Ingredient implements IPrice
{
    private final String name;
    private final double price;

    public Ingredient(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public double getPrice()
    {
        return price;
    }
}

class Meal implements Ingredients, IPrice
{
    private String name;
    private double price;
    ArrayList<Ingredient> ingredients;

    public Meal()
    {
        this.ingredients = new ArrayList<>();
    }


    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        price += ingredient.getPrice();

    }

    @Override
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
}




public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Meal meal = new Meal();

        String option = "yes";
        while(option.equals("yes"))
        {
            System.out.print("Add an ingredient to the meal: ");
            String name = sc.next();
            System.out.print("Enter the price: ");
            double price = sc.nextDouble();
            meal.addIngredient(new Ingredient(name, price));

            System.out.print("Do you want to add more ingredients? (Enter stop to stop): ");
            option = sc.next();

        }

        System.out.print("Dinner with ingredient: ");
        for(Ingredient ingredient : meal.getIngredients())
        {
            System.out.print(ingredient.getName() + " - " + ingredient.getPrice() + "; ");
        }
        System.out.println("Total bill: " + meal.getPrice());

    }
}
