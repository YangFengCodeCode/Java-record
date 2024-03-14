import java.util.Scanner;

public class Rectangle {
    public int lenth;
    public int width;
    public Rectangle(int l, int w) {
        lenth = l;
        width = w;
    }

    public Rectangle()
    {
        lenth = 5;
        width = 4;
    }

    public void showInformation()
    {
        System.out.println("lenth:" + lenth + ' ' + "width:" + width);
    }

    public void setLenth(int l)
    {
        lenth = l;
    }

    public void setWidth(int w)
    {
        width = w;
    }

    public int getWidth() {
        return width;
    }

    public int getLenth() {
        return lenth;
    }

    public long calRectangle()
    {
        return (long)width*lenth;
    }

    public int calPerimeter()
    {
        return (width+lenth)*2;
    }



    static public void main(String[] args)
    {
        Rectangle box = new Rectangle(10, 20);
        box.showInformation();
        box.setLenth(20);
        box.showInformation();

        long rectangle = box.calRectangle();
        System.out.println(rectangle);

        int perimeter = box.calPerimeter();
        System.out.println(perimeter);

        Rectangle newbox = new Rectangle();
        newbox.showInformation();
        newbox.calRectangle();
        newbox.calPerimeter();

        long []house = new long[5];
        Scanner sc = new Scanner(System.in);
        int lenth, width;
        for(int i = 0; i < house.length; i++)
        {
            System.out.println("Please enter the your house lenth: ");
            lenth = sc.nextInt();

            System.out.println("Please enter the your house width: ");
            width = sc.nextInt();

            Rectangle houseBox = new Rectangle(lenth, width);
            houseBox.showInformation();
            house[i] = houseBox.calRectangle();
        }

        int sum = 0;

        for(int i = 0; i < 5; i++)
        {
            sum += house[i];
            System.out.print(house[i] + " ");
        }

        System.out.println('\n' + "The sum of the house:" + sum);

    }
}


