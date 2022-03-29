package Java_Level_02.Lesson_01;

public class Human implements Action{
    private String name;
    private int runLong;
    private int jumpHeight;


    public Human(String name, int runLong, int jumpHeight) {
        this.name = name;
        this.runLong = runLong;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public int run() {
        System.out.println("Человек " + name + " побежал");
        return runLong;
    }

    @Override
    public int jump() {
        System.out.println("Человек " + name + " прыгает");
        return jumpHeight;
    }
}
