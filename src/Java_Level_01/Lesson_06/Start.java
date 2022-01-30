package Java_Level_01.Lesson_06;

import java.util.Random;

public class Start {
    public static void main(String[] args) {
        Random rnd = new Random();
        int rsl;
        int len;
        boolean runned;
        int runMax;
        int swimMax;
        Animal obj;
        System.out.println("Отчет о проведении практического опыта №6");


        do {
            System.out.println();

/*
            выбор между собакой и котом
*/
            rsl = rnd.nextInt(2);//
            if (rsl == 0) {
                obj = new Dog("Собака");//выбрали собаку
                runMax = Dog.getRunMax();//потому что к статическим полям
                swimMax = Dog.getSwimMax();//надо обращаться из статичного контекста
            } else {
                obj = new Cat("Кот");//выбрали кота
                runMax = Cat.getRunMax();//потому что к статическим полям
                swimMax = Cat.getSwimMax();//надо обращаться из статичного контекста
            }
/*
            выбираем препятствие: 0-бежать, 1-плыть, 2-бежать и плыть
*/
            rsl = rnd.nextInt(3);
            /*
            бежим
            */
            if (rsl == 0 || rsl == 2) {
                if (rsl == 0) System.out.println("Надо пробежать " + runMax + "м.");
                if (rsl == 2) System.out.println("Надо пробежать " + runMax + "м и проплыть " + swimMax + "м.");

                len = rnd.nextInt(runMax + 150);//+150 - чтобы чаще было - пробежала
                runned = obj.run(len);
                if (runned & rsl == 0) break;//выход если только пробежали и надо только пробежать
                if (!runned) continue;//переходим к следующему животному, если не пробежали, а надо только пробежать
            }

            /*
            плывем
            */
            System.out.println("Надо проплыть " + swimMax + "м");
            len = rnd.nextInt(swimMax + 3);//+3 - чтобы чаще было - проплыла
            if (obj.swim(len)) break;

        } while (true);

        System.out.println("----------------------------------------");
        System.out.println("Всего было создано " + Animal.getCountAnimal() + " животных");
        System.out.println("Из них: собаки - " + Dog.getCountDog() + ", коты - " + Cat.getCountCat());

    }
}
