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
    public int run() {
        System.out.println("Кот " + nick + " бежит");
        return runLong;
    }

    @Override
    public int jump() {
        System.out.println("Кот " + nick + " прыгает");
        return jumpHeight;
    }
}
