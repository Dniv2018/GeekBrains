package Java_Level_02.Lesson_02;

public class Solid {
    private String[][] mass;
    private String name;

    Solid(String name, String[][] mass){
        this.mass=mass;
        this.name=name;
    }

    public String[][] getMass (){
        return this.mass;
    }

    public String getName() {
        return name;
    }
}
