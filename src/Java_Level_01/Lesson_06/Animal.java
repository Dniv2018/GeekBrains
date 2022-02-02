package Java_Level_01.Lesson_06;

public abstract class Animal {

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

    abstract boolean run(int a);

    abstract boolean swim(int a);

}
