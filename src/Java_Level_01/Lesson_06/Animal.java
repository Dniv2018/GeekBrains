package Java_Level_01.Lesson_06;

public class Animal {

    private String name;
    private static int countAnimal;



    Animal(String str) {
        name = str;
        countAnimal++;
        System.out.println("Выпускаем животное №"+countAnimal+" на площадку.");
    }
    Animal() {
    }


    protected String getName() {
        return name;
    }
    protected static int getCountAnimal() {
        return countAnimal;
    }

    boolean run(int a){
        return false;
    }

    boolean swim(int a){
        return false;
    }

}
