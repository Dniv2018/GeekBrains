package Java_Level_02.Lesson_01;

public class Wall extends Difficult{
//    private int wallHeight;

    public Wall(int a){
        super(a);
    }

    boolean mayMake(int a){
        System.out.println("Попытка преодоления стены");
        return super.mayMake(a);
    }
}
