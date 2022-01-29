package Java_Level_01;

import java.util.Random;

public class IntroductionToOOP_05 {
    public static void main(String[] args) {
        // 4. Создать массив из 5 сотрудников.
        Person[] persArray = new Person[5];
        Random rnd = new Random();
        persArray[0] = new Person("Ivanov Ivan Ivanovich", "Enginer", "ivivan@mailbox.com", "892312312", 60000, rnd.nextInt(47) + 18);
        persArray[1] = new Person("Ivanov Petr Ivanovich", "Cook", "ivpetr@mailbox.com", "892312315", 40000, rnd.nextInt(47) + 18);
        persArray[2] = new Person("Petrov Sidor Petrovich", "Mechanik", "pesidor@mailbox.com", "892312314", 40000, rnd.nextInt(47) + 18);
        persArray[3] = new Person("Sidorova Evdokiya Ivanovna", "Manager", "sidev@mailbox.com", "892312313", 50000, rnd.nextInt(42) + 18);
        persArray[4] = new Person("Sidorov Ivan Sidorovich", "Director", "siivan@mailbox.com", "892312311", 100000, rnd.nextInt(47) + 18);

        System.out.println("Все сотрудники:");
        System.out.printf("%-30s%-11s%-22s%-15s%-10s%-5s%n", "FNP", "Pisition", "Email", "Phone number", "Salary", "Age");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (Person pers : persArray) {
            pers.printPerson();
        }

//      5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        System.out.println("\nСотрудники старше 40 лет:");
        System.out.printf("%-30s%-11s%-22s%-15s%-10s%-5s%n", "FNP", "Pisition", "Email", "Phone number", "Salary", "Age");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (Person pers : persArray) {
            if (pers.getAge() > 40) pers.printPerson();
        }
    }
}
