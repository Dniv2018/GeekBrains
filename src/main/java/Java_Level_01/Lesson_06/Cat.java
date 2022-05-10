package Java_Level_01.Lesson_06;

public class Cat extends Animal{

    final private static int RUN_MAX = 200;
    final private static int SWIM_MAX = 10;
    private static int countCat;

    Cat(String str) {
        super(str);
        countCat++;
        System.out.println("Это кот №"+ Cat.getCountCat());
    }

    public static int getCountCat() {
        return countCat;
    }

    public static int getRunMax() {
        return RUN_MAX;
    }

    public static int getSwimMax() {
        return SWIM_MAX;
    }


    @Override
    boolean run(int length) {
        boolean rsl = false;
        if (length < RUN_MAX) {
            System.out.println(getName() + " пробежал " + length + "м. Объект потерян.");
        }
        if (length >= RUN_MAX) {
            System.out.println(getName() + " пробежал всю дистанцию.");
            rsl = true;
        }
        return rsl;
    }

    @Override
    boolean swim(int length) {
        System.out.println("Коты не могут плавать. Объект потерян.");
        return false;
    }
}
