package Java_Level_01.Lesson_07;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Random rnd = new Random();

        // Create array's cat (10-20)
        int n = rnd.nextInt(11) + 10;
        Cat[] arrayCat = new Cat[n];
        System.out.println("Here is " + n + " cats");
        for (int i=0; i<arrayCat.length; i++){
            n = rnd.nextInt(11);//Create cat appetite
            arrayCat[i] = new Cat("Cat N" + (i+1), n);
            System.out.println(arrayCat[i].toString());
        }

        Plate plate = new Plate(0);
        System.out.println();
        System.out.println("Put the plate.");
        System.out.println(plate.info());
        boolean foodSufficiency;

        do {
            plate.addFood(50);
            System.out.println();
            System.out.println("Add food to the plate");
            System.out.println(plate.info());

            foodSufficiency = tryToFeedTheCats(arrayCat, plate);

        }while (!foodSufficiency);

        System.out.println();
        System.out.println("All cats fullness.");
        System.out.println(plate.info());

        for (Cat cat:
                arrayCat) {
            System.out.println(cat.toString());
        }
    }

    private static boolean tryToFeedTheCats(Cat[] arrayCat, Plate plate) {
        boolean foodSufficiency = true;
        for (Cat cat:
                arrayCat) {
            if (!cat.isFullness()){
                System.out.println();
                System.out.println(cat.getName() + " go to plate");
                System.out.println(cat);
                System.out.println(cat.getName() + " try to eats");

                if (!cat.eat(plate)) {
                    System.out.println(cat.getName() + " do not fullness");
                    foodSufficiency = false;
                    System.out.println(plate.info());
                }else{
                    System.out.println(plate.info());
                    System.out.println(cat.getName() + " is fullness");
                }
            }
        }
        return foodSufficiency;
    }
}
