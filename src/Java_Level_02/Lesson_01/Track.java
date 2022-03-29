package Java_Level_02.Lesson_01;

public class Track {
    private int trackLong;

    void Track(int a){
        trackLong = a;
    }

    boolean mayMakeTrack(int a){
        if (a>trackLong){
            return true;
        }
        return false;
    }
}
