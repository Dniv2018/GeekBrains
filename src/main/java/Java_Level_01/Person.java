package Java_Level_01;

public class Person {
    //    Урок 5. Введение в ООП
    //1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    private String fio;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;


    /*
            2. Конструктор класса должен заполнять эти поля при создании объекта.
            Так как нашему классу достаточна читаемость из текущего пакета, то модификатор доступа не ставим
        */
    Person(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }


    /*
    3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    */
    void printPerson() {
        System.out.printf("%-30s%-11s%-22s%-15s%-10d%-5d%n", fio, position, email, phone, salary, age);
//        System.out.println(this.fio + "\t" + this.position + "\t" + this.email + "\t" + this.phone + "\t" + this.salary + "\t" + this.age);

    }
//

}
