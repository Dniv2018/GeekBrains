package Java_Level_01;

import java.util.Arrays;

public class Array_03 {
    public static void main(String[] args) {
        int[] firstArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("1. С помощью цикла и условия заменить 0 на 1, 1 на 0 в массиве:");
        printOneArray(firstArray);
        switchBetweenNullAndOne(firstArray);
        System.out.println("Рузультат:");
        printOneArray(firstArray);
        System.out.println(" ");

        int[] arrayHundred = new int[100];
        System.out.println("2. С помощью цикла заполнить массив длиной 100 значениями 1 2 3 4 5 6 7 8 … 100");
        printOneArray(arrayHundred);
        fillingUpArray(arrayHundred);
        System.out.println("Рузультат:");
        printOneArray(arrayHundred);
        System.out.println(" ");

        int[] arrayMult = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("3. В массиве числа меньшие 6 умножить на 2;");
        printOneArray(arrayMult);
        ifLessSixMultiplyTwo(arrayMult);
        System.out.println("Рузультат:");
        printOneArray(arrayMult);
        System.out.println(" ");

        int[][] squareArray = new int[5][5];
        System.out.println("4. Создать квадратный двумерный целочисленный массив, и с помощью циклов " +
                "заполнить его диагональные элементы единицами");
        for (int i=0;i<5;i++) printOneArray(squareArray[i]);
        fillingDiagonally(squareArray);
        System.out.println("Рузультат:");
        for (int i=0;i<5;i++) printOneArray(squareArray[i]);
        System.out.println(" ");
    }

    static void fillingDiagonally(int[][] array){
        for (int i=0; i<5;i++){
            for (int j=0; j<5;j++){
                if ((i==j)||(i+j==4)) array[i][j]=1;
            }
        }
    }

    static void ifLessSixMultiplyTwo (int[] a){
        for (int i =0; i< a.length; i++) {
            if (a[i]<6){
                a[i]=a[i]*2;
            }
        }
    }

    static void fillingUpArray (int[] a){
        for (int i =0; i< a.length; i++) {
                a[i]=i+1;
        }
    }

    private static void printOneArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    static void switchBetweenNullAndOne (int[] a){
        for (int i =0; i< a.length; i++) {
            if (a[i]==0) {
                a[i]=1;
            } else {
                a[i] =0;
            }
        }
    }
}
