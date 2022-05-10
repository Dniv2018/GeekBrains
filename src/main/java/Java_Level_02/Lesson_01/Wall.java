package Java_Level_02.Lesson_01;

public class Wall implements Difficult{
    private int wallHeight;

    public Wall(int a){
        wallHeight = a;
    }

    public boolean mayMake(ActionN a){
        System.out.println("Попытка преодоления стены");
        if (a.jump()>wallHeight){
            System.out.println("Препятствие преодолено");
            return true;
        }
        System.out.println("Препятствие не преодолено.");
        return false;
    }
}
