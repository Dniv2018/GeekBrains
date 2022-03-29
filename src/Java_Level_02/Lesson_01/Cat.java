package Java_Level_02.Lesson_01;

public class Cat implements Action{
    private String nick;
    private int runLong;
    private int jumpHeight;

    public Cat(String nick, int runLong, int jumpHeight) {
        this.nick = nick;
        this.runLong = runLong;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void run() {
        System.out.println("Кот " + nick + " бежит");
    }

    @Override
    public void jump() {
        System.out.println("Кот " + nick + " прыгает");
    }
}
