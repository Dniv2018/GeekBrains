package Java_Level_01;

public class BasicStructures_02 {
    public static void main(String[] args) {
        int firstNumber = 100;
        int secondNumber = 10;
        System.out.println("Результат проверки на нахождение суммы чисел " + firstNumber + " и " + secondNumber +
                " в пределах от 10 до 20 (включительно): " + sumValueInsideLimits(firstNumber, secondNumber));


    }

    static boolean sumValueInsideLimits(int first, int second){
        return 10 <= (first + second) &  (first + second) <= 20;
    }
}
