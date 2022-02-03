package Java_Level_01.Lesson_07;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food > 0 & food >= n) {
            food -= n;
            return true;
        }
        return false;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood(int addition) {
        food += addition;
    }
}
