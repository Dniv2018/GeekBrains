package Java_Level_01.Lesson_06;

public class Dog extends Animal {
    final private static int RUN_MAX = 500;
    final private static int SWIM_MAX = 10;
    private static int countDog;

    Dog(String str) {
        super(str);
        countDog++;
        System.out.println("Это собака №"+ Dog.getCountDog());
    }

    public static int getCountDog() {
        return countDog;
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
            System.out.println(getName() + " пробежала " + length + "м. Объект потерян.");
        }
        if (length >= RUN_MAX) {
            System.out.println(getName() + " пробежала всю дистанцию.");
            rsl = true;
        }
        return rsl;
    }

    @Override
    boolean swim(int length) {
        boolean rsl = false;
        if (length > 0 & length < SWIM_MAX) {
            System.out.println(getName() + " проплыла " + length + "м. Объект потерян.");
        }
        if (length >= SWIM_MAX) {
            System.out.println(getName() + " проплыла всю дистанцию.");
            rsl = true;
        }
        return rsl;
    }
}
