package Java_Level_02.Lesson_01;

public class Track extends Difficult{
    //private int trackLong;

    public Track(int i) {
        super(i);
    }

    boolean mayMakeTracK(int a){
        System.out.println("Попытка преодоления беговой дорожки");
        return mayMake(a);
    }
}
