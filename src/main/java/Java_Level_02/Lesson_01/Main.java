package Java_Level_02.Lesson_01;

public class Main {
    public static void main(String[] args) {
//        Track track = new Track(100);
//        Wall wall = new Wall(2);

        ActionN[] members = new ActionN[6];
        members[0] = new Human("Alex", 50, 1);
        members[1] = new Human("Bob",101,3);
        members[2] = new Robot(101, 10, 4);
        members[3] = new Robot(110,101,0);
        members[4] = new Cat("Kitty",103,1);
        members[5] = new Cat("Max",200,3);

        Difficult[] difficults = new Difficult[2];
        difficults[0] = new Track(100);
        difficults[1] = new Wall(2);

        for (ActionN m: members) {
            for (Difficult d: difficults) {
                if (!d.mayMake(m)) {
                    System.out.println("Участник не прошел испытание");
                    break;
                }else
                    if (d instanceof Wall){
                        System.out.println("Участник прошел испытание\n");
                    }
            }
            System.out.println(" ");
        }
    }
}
