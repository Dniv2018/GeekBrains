package Java_Level_02.Lesson_01;

public class Track implements Difficult{
    private int trackLong;

    public Track(int i) {
        trackLong = i;
    }

    public boolean mayMake(ActionN a){
        System.out.println("Попытка преодоления беговой дорожки");
        if (a.run()>trackLong){
            System.out.println("Препятствие преодолено");
            return true;
        }
        System.out.println("Препятствие не преодолено.");
        return false;
    }



//    public boolean mayMake(int a){
//        System.out.println("Попытка преодоления беговой дорожки");
//        if (a>trackLong){
//            System.out.println("Препятствие преодолено");
//            return true;
//        }
//        System.out.println("Препятствие не преодолено.");
//        return false;
//    }
}
