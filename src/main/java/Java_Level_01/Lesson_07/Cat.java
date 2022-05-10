package Java_Level_01.Lesson_07;

public class Cat {

    final private String name;
    final private int appetite;
    private boolean fullness = false;

    public boolean isFullness() {
        return fullness;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public boolean eat(Plate p) {
        if (!fullness) {
            fullness = p.decreaseFood(appetite);
        }
        return fullness;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", fullness=" + fullness +
                '}';
    }
}