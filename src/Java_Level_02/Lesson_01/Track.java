package Java_Level_02.Lesson_01;

public class Track extends Difficult{
    //private int trackLong;

    public Track(int i) {
        super(i);
    }

    boolean mayMake(int a){
        System.out.println("Попытка преодоления беговой дорожки");
        return super.mayMake(a);
    }
}
