package Java_Level_01.Lesson_06;

public class Cat extends Animal{
    final private static int RUN_MAX = 200;
    final private static int SWIM_MAX = 10;
    private static int countCat;
    //final private static int SWIM_MAX = 0;

    /*  1. Создать классы Собака и Кот с наследованием от класса Животное.
    2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается
    длина препятствия. Результатом выполнения действия будет печать в консоль.
    (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
    3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
    плавание: кот не умеет плавать, собака 10 м.).
    4. * Добавить подсчет созданных котов, собак и животных.*/

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
