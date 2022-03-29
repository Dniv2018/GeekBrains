package Java_Level_02.Lesson_01;

public class Wall {
    private int wallHeight;

    void Wall(int a){
        wallHeight = a;
    }

    boolean mayMakeTrack(int a){
        if (a>wallHeight){
            return true;
        }
        return false;
    }
}
