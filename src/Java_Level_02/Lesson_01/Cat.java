package Java_Level_02.Lesson_01;

public class Cat implements Action{
    private String nick;

    @Override
    public void run() {
        System.out.println("Кот " + nick + " бежит");
    }

    @Override
    public void jump() {
        System.out.println("Кот " + nick + " прыгает");
    }
}
