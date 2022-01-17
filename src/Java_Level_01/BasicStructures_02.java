package Java_Level_01;

public class BasicStructures_02 {
    public static void main(String[] args) {
        int firstNumber = 0;
        int secondNumber = -10;
        System.out.println("Результат проверки на нахождение суммы чисел " + firstNumber + " и " + secondNumber +
                " в пределах от 10 до 20 (включительно): " + sumValueInsideLimits(firstNumber, secondNumber));

        checkNumberIsPositive (firstNumber);

        System.out.println("Является ли число " + secondNumber + " отрицательным: " + checkIsPositive(secondNumber));

        printingSeries ("Строка для печати в цикле", 5);

        System.out.println("Год 4 - високосный? Ответ: " + isLeapYear(4));
        System.out.println("Год 100 - високосный? Ответ: " + isLeapYear(100));
        System.out.println("Год 400 - високосный? Ответ: " + isLeapYear(400));
        System.out.println("Год 800 - високосный? Ответ: " + isLeapYear(800));
        System.out.println("Год 200 - високосный? Ответ: " + isLeapYear(200));
        System.out.println("Год 2020 - високосный? Ответ: " + isLeapYear(2020));
        System.out.println("Год 2021 - високосный? Ответ: " + isLeapYear(2121));


    }

    static boolean sumValueInsideLimits(int first, int second){
        return 10 <= (first + second) & (first + second) <= 20;
    }

    static void checkNumberIsPositive(int num){
        System.out.println("Число " + num + " является " + (num >= 0 ? "положительным.": "отрицательным."));
    }

    static boolean checkIsPositive(int num){
        return num<0;
    }

    static void printingSeries(String str, int num){
        for (int i=0; i<num; i++) System.out.println(str);
    }

    static boolean isLeapYear(int year){
        return (year%4==0 & (year%100!=0 ^ year%400==0));
    }
}
