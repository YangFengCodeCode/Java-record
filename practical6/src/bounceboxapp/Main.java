/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bounceboxapp;

import bouncebox.BounceBox;
import bouncebox.Circle;
import bouncebox.Square;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ashongtical
 */
public class Main {

    /**
     * @param args the command line arguments
     */

            
    public static void main(String[] args) throws FileNotFoundException {
        addShapes();

    }

    public static void addShapes() throws FileNotFoundException {
        FileInputStream fileIn = new FileInputStream("D:\\JavaFile\\practical6\\src\\practical6.txt");
        Scanner sc = new Scanner(fileIn);

        BounceBox box = new BounceBox(700, 500);
        int circle_count = 0;
        int square_count = 0;
        double totalArea = 0;

        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            String[] tokens = line.split("\\s+");

            if(tokens.length < 4) continue;

            String shapeType = tokens[0];
            int x = Integer.parseInt(tokens[1]);
            int y = Integer.parseInt(tokens[2]);
            int size = Integer.parseInt(tokens[3]);
            int velocity_x = 0;
            int velocity_y = 0;
            int red = 0;
            int green = 0;
            int blue = 0;


            if(shapeType.equals("Circle"))
            {

                Circle c = new Circle(x, y, size);
                if(tokens.length >= 5)
                {
                    velocity_x = Integer.parseInt(tokens[4]);
                    velocity_y = Integer.parseInt(tokens[5]);
                    if(tokens.length >= 8)
                    {
                        red = Integer.parseInt(tokens[6]);
                        green = Integer.parseInt(tokens[7]);
                        blue = Integer.parseInt(tokens[8]);

                    }
                }

                c.setColor(new Color(red, green, blue));
                c.setVelocity(velocity_x, velocity_y);
                box.addShape(c);
                circle_count++;
                totalArea += Math.PI*size*size;
            }

            else if(shapeType.equals("Square"))
            {
                Square s = new Square(x,y, size);
                if(tokens.length >= 5)
                {
                    velocity_x = Integer.parseInt(tokens[4]);
                    velocity_y = Integer.parseInt(tokens[5]);
                    if(tokens.length >= 8)
                    {
                        red = Integer.parseInt(tokens[6]);
                        green = Integer.parseInt(tokens[7]);
                        blue = Integer.parseInt(tokens[8]);

                    }
                }

                s.setColor(new Color(red, green, blue));
                s.setVelocity(velocity_x, velocity_y);
                box.addShape(s);
                square_count++;
                totalArea += size*size;
            }

            else
            {
                System.out.println("Ignore unkown shape: " + shapeType);
            }
        }

        box.start();
        sc.close();

        System.out.print("squareNumber: "+ square_count);
        System.out.println(" circleNumber: "+ circle_count);
        System.out.println("Total area of all shapes: " + totalArea);

    }


}
