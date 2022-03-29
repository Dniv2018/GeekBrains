package Java_Level_02.Lesson_01;

public class Robot implements Action{
    private int nickName;

    @Override
    public void run() {
        System.out.println("Робот " + nickName + " бежит");
    }

    @Override
    public void jump() {
        System.out.println("Робот " + nickName + " прыгает");
    }
}
