public class Animal {
    public int age;
    public String gender;

    public boolean isMammal() {
        System.out.println("Called isMammal() from Animal class");
        return true; // assuming animals are mammals by default
    }

    public void mate() {
        System.out.println("Called mate() from Animal class");
    }

    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Fish myFish = new Fish();
        Zebra myZebra = new Zebra();

        System.out.println("=== Animal Methods ===");
        myAnimal.isMammal();
        myAnimal.mate();

        System.out.println("\n=== Zebra Methods ===");
        myZebra.isMammal();
        myZebra.mate();
        myZebra.run();

        // Note: cannot call private methods or access private fields from outside
        // myFish.canEat(); // This will cause an error
    }
}
public class Fish extends Animal {
    private double sizeInFeet;

    private void canEat() {
        System.out.println("This is a private method canEat() from class Fish");
    }
}
public class Zebra extends Animal {
    public boolean is_wild;

    public void run() {
        System.out.println("Called run() from Zebra class");
    }
}