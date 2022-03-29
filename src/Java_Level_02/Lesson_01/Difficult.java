package Java_Level_02.Lesson_01;

public abstract class Difficult {
    private int value;

    public Difficult(int i){
        value = i;
    }

    boolean mayMake(int a){
        if (a>value){
            System.out.println("Препятствие преодолено");
            return true;
        }
        return false;
    }

}
