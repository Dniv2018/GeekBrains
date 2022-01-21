package Java_Level_01;

import java.util.Arrays;
import java.util.Random;

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

        System.out.println("5. Написать метод, принимающий на вход два аргумента: len и initialValue, " +
                "и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;");
        System.out.println("Рузультат:");
        printOneArray(makeArrayByLengthAndValue(10, 2));
        System.out.println(" ");

        System.out.println("6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы;");
        int[] result = minAndMaxValueArray();
        System.out.println("Рузультат:");
        System.out.println("min: "+ result[0] + " max: " + result[1]);
        System.out.println(" ");
    }

    static int[] minAndMaxValueArray(){
        Random rnd = new Random();
        int len = rnd.nextInt(30);
        int [] elemental = new int[len];
        for (int i=0; i<len; i++){
            elemental[i]=rnd.nextInt(20);
        }
        System.out.println("Случайный исходный массив:");
        printOneArray(elemental);
        int[] rsl = new int[2];
        for (int cell:elemental) {
            if(rsl[0]>cell) rsl[0]=cell;
            if(rsl[1]<cell) rsl[1]=cell;
        }
        return rsl;
    }

    static int[] makeArrayByLengthAndValue(int len, int val){
        int[] makeArray = new int[len];
        for (int i=0; i<len;i++){
            makeArray[i]=val;
        }
        return makeArray;
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
