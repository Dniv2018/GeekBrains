package Java_Level_02.Lesson_01;

public class Robot implements Action{
    private int nickName;
    private int runLong;
    private int jumpHeight;

    public Robot(int nickName, int runLong, int jumpHeight) {
        this.nickName = nickName;
        this.runLong = runLong;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void run() {
        System.out.println("Робот " + nickName + " побежал");
    }

    @Override
    public void jump() {
        System.out.println("Робот " + nickName + " прыгает");
    }
}
