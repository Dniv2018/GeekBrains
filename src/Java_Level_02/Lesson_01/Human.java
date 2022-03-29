package Java_Level_02.Lesson_01;

public class Human implements Action{
    private String name;

    @Override
    public void run() {
        System.out.println("Человек " + name + " бежит");
    }

    @Override
    public void jump() {
        System.out.println("Человек " + name + " бежит");
    }
}
