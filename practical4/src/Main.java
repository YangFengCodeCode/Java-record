
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void menu()
    {
        System.out.println("1 Ask user for the name of a Hobbit and add it to the World with default health 100");
        System.out.println("2 Ask user for the name and age of a Wizard and add it to the World with wisdom 50");
        System.out.println("3 Display information about the name of the World and all entities stored in that World");
        System.out.println("4 Move all entities in the world twice continuously, the Hobbit health minus 5 and Wizard wisdom minus 1");
        System.out.println("0 Stop the program");

    }

 
    public static void main(String[] args) {
        menu();
        int option = 1;
        World world = new World("Middle Earth");
        Scanner sc = new Scanner(System.in);
        while(option != 0)
        {
            System.out.print("Enter one valid option (0 to 4): ");
            option = sc.nextInt();
            if(option >= 1 && option <= 4) {
                if(option == 1)
                {
                    System.out.print("Enter Hobbit name: ");
                    String hobbit_name = sc.next();
                    world.addEntity(new Hobbit(hobbit_name, 100));
                }

                else if(option == 2)
                {
                    System.out.print("Enter Wizard name and age: ");
                    String wizard_name  = sc.next();
                    int wizard_age = sc.nextInt();
                    world.addEntity(new Wizard(wizard_name, wizard_age));

                }

                else if(option == 3)
                {
                    System.out.println("*World name:" + world.getName());
                    System.out.println("*Number of the Hobbits and Wizards:" + world.getTeam().size());

                    for(Entity t: world.getTeam())
                    {
                        if(t.getSymbol() == "#")
                        {
                            System.out.println("*Hobbit:" + t.toString());
                        }
                    }

                    for(Entity t: world.getTeam())
                    {
                        if(t.getSymbol() == "@")
                        {
                            System.out.println("*Wizard:" + t.toString());
                        }
                    }

                }

                else
                {
                    for(Entity entity: world.getTeam())
                    {
                        entity.move();
                        entity.move();
                        if(entity.getSymbol() == "#")
                        {
                            int health = ((Hobbit)entity).getHealth();
                            ((Hobbit)entity).setHealth(health-5);
                        }

                        else
                        {
                            int wisdom = ((Wizard)entity).getWisdom();
                            ((Wizard)entity).setWisdom(wisdom-1);

                        }


                    }

                }

                menu();
            }


        }


 
    }
}
