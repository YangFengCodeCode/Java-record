import java.util.Scanner;

class Animal
{
    private String name;
    private String species;
    private int age;
    public Animal(String name, String species, int age)
    {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }
}

class Zoo
{
    //creat a Animal list
    private Animal[] animals_array;
    private int count;
    public Zoo()
    {
        animals_array = new Animal[10];
        count = 0;
    }

    public void addAnimal(Animal animal)
    {
        if(count <= 10)
        {
            animals_array[count] = animal;
            count++;
        }
        else
            System.out.println("Middle Earth has reached the maximum capacity!");
    }

    public void deleteAnimal(String animal)
    {
        int ret = findAnimal(animal);
        if(ret != -1)
        {
            animals_array[ret] = null;
            count--;
        }
    }

    public int findAnimal(String animal)
    {
        //skip null pointer
        for (int i = 0; i < 10; i++) {
            if (animals_array[i] != null && animals_array[i].getName().equals(animal))
                return i;
        }

        return -1;
    }

    public void moveAnimal(String animal_name, Zoo destination_zoo)
    {

        int ret = findAnimal(animal_name);// return animal index
        if(ret != -1) {
            Animal animal = animals_array[ret];
            deleteAnimal(animal_name);
            destination_zoo.addAnimal(animal);
        }
        else
        {
            System.out.println("The animal does not exit");
        }

    }

    public void displayAnimals(String zooName)
    {
        System.out.println("Animals in "+ zooName);
        System.out.println("--------------------------------------------");
        System.out.println("Name            Species             Age");
        System.out.println("--------------------------------------------");
        for(int i = 0; i < animals_array.length; i++)
        {
            // skip null pointer
            if(animals_array[i] != null) {
                String name = animals_array[i].getName();
                String species = animals_array[i].getSpecies();
                int age = animals_array[i].getAge();
                System.out.printf("%-16s%-16s\t%d\n", name, species,age);
            }
        }
        System.out.println("--------------------------------------------\n");
    }


}



public class Main {
    static public void main(String[] args)
    {
        //creat class objects
        Zoo Temperate_Zone_Zoo = new Zoo();
        Zoo Tropic_Zone_Zoo = new Zoo();

        //add class animal
        Temperate_Zone_Zoo.addAnimal(new Animal("Bear", "Grizzly Bear", 10));
        Temperate_Zone_Zoo.addAnimal(new Animal("Wolf", "Gray Wolf", 5));
        Temperate_Zone_Zoo.addAnimal(new Animal("Deer", "White-tailed Deer",3));

        Tropic_Zone_Zoo.addAnimal(new Animal("Tiger", "Bengal Tiger", 8));
        Tropic_Zone_Zoo.addAnimal(new Animal("Monkey", "Capuchin Monkey", 4));
        Tropic_Zone_Zoo.addAnimal(new Animal("Parrot", "Macaw Parrot",2));

        //display two zoo animals information
        System.out.println("Initial Animals in Temperate Zone Zoo");
        Temperate_Zone_Zoo.displayAnimals("Temperate Zone Zoo");
        System.out.println("Initial Animals in Tropic Zone Zoo");
        Tropic_Zone_Zoo.displayAnimals("Tropic Zone Zoo");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the zoo you want to move the animal from "
                + "(Temperate Zone Zoo or Tropical Zone zoo): ");
        String source_zoo = sc.nextLine();
        String destination_zoo = (source_zoo.equals("Temperate Zone Zoo"))? "Tropic Zone Zoo" : "Temperate Zone Zoo";
        System.out.println("Enter the name of the animal you want to move:");
        String animal_name = sc.nextLine();

        System.out.println(animal_name + " removed from the zoo.");
        System.out.println(animal_name + " moved from " + source_zoo + " to "+ destination_zoo+"\n");

        //judge who is source_zoo or destination_zoo
        if(source_zoo.equals("Temperate Zone Zoo"))
        {
            Temperate_Zone_Zoo.moveAnimal(animal_name, Tropic_Zone_Zoo);
            System.out.println("Animals in Temperate Zone Zoo after moving:");
            Temperate_Zone_Zoo.displayAnimals("Temperate Zone Zoo");
            System.out.println("Animals in Tropic Zone Zoo after moving:");
            Tropic_Zone_Zoo.displayAnimals("Tropic Zone Zoo");
        }
        else
        {
            Tropic_Zone_Zoo.moveAnimal(animal_name, Temperate_Zone_Zoo);
            System.out.println("Animals in Temperate Zone Zoo after moving:");
            Temperate_Zone_Zoo.displayAnimals("Temperate Zone Zoo");
            System.out.println("Animals in Tropic Zone Zoo after moving:");
            Tropic_Zone_Zoo.displayAnimals("Tropic Zone Zoo");
        }


    }

}
