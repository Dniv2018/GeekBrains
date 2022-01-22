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

        int[] arrayHundred = new int[100];
        System.out.println("\n2. С помощью цикла заполнить массив длиной 100 значениями 1 2 3 4 5 6 7 8 … 100");
        printOneArray(arrayHundred);
        fillingUpArray(arrayHundred);
        System.out.println("Рузультат:");
        printOneArray(arrayHundred);

        int[] arrayMult = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("\n3. В массиве числа меньшие 6 умножить на 2;");
        printOneArray(arrayMult);
        ifLessSixMultiplyTwo(arrayMult);
        System.out.println("Рузультат:");
        printOneArray(arrayMult);

        int[][] squareArray = new int[5][5];
        System.out.println("\n4. Создать квадратный двумерный целочисленный массив, и с помощью циклов " +
                "заполнить его диагональные элементы единицами");
        for (int i=0;i<5;i++) printOneArray(squareArray[i]);
        fillingDiagonally(squareArray);
        System.out.println("Рузультат:");
        for (int i=0;i<5;i++) printOneArray(squareArray[i]);

        System.out.println("\n5. Написать метод, принимающий на вход два аргумента: len и initialValue, " +
                "и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;");
        System.out.println("Рузультат:");
        printOneArray(makeArrayByLengthAndValue(10, 2));

        System.out.println("\n6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы;");
        int[] result = minAndMaxValueArray();
        System.out.println("Рузультат:");
        System.out.println("min: "+ result[0] + " max: " + result[1]);

        System.out.println("\n7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, " +
                "метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.");
        int[] firstCheckBalance = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] checkArrayBalance = {21,1,2,3,4,5,6};
        Random rnd = new Random();
        int len = rnd.nextInt(30);
        int [] secondCheckBalance = new int[len];
        for (int i=0; i<len; i++){
            secondCheckBalance[i]=rnd.nextInt(20);
        }
        printOneArray(firstCheckBalance);
        printBalanceArray(firstCheckBalance);
        System.out.println(" ");
        printOneArray(checkArrayBalance);
        printBalanceArray(checkArrayBalance);
        System.out.println(" ");
        printOneArray(secondCheckBalance);
        printBalanceArray(secondCheckBalance);

        System.out.println("\n8. *** Написать метод, которому на вход подается одномерный массив " +
                "и число n (может быть положительным, или отрицательным), при этом метод должен сместить " +
                "все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя " +
                "пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) " +
                "-> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую " +
                "сторону сдвиг можете выбирать сами.");
        int lenEight = rnd.nextInt(9)+3;
        int[] arrayChange = new int[lenEight];
//        int[] arrayChange = {1,2,3,4,5,6,7,8};
//        int displacement = 3;
        int displacement = rnd.nextInt(10)+1-5;
        for(int i=0;i<lenEight;i++) arrayChange[i] = rnd.nextInt(10);
        printOneArray(arrayChange);
        System.out.println("Сдвиг: "+displacement);
        changeChain(arrayChange,displacement);
        printOneArray(arrayChange);
    }

    static void changeChain(int[]inputArray, int dsp){
        int maxIndexArray = inputArray.length-1;
        if (dsp<0){
            while (dsp<0) dsp += inputArray.length;
        }
        while (dsp>=inputArray.length) dsp -= inputArray.length;
            System.out.println("Фактический сдвиг:" + dsp);
        int a;
        int b;
        while (dsp!=0){
            a = inputArray[0];
            for(int i = 1;i<=maxIndexArray; i++){
                b=inputArray[i];
                inputArray[i]=a;
                a=b;
                if(i==maxIndexArray) inputArray[0]=a;
            }
            dsp--;
        }
    }

    private static void printBalanceArray(int[] inputArray) {
        int[] rsl = findBalance(inputArray);
        if (rsl[3]==1){
            for (int i = 0; i < inputArray.length; i++) {
                System.out.print(" " + inputArray[i]);
                if (i == rsl[0]) {
                    System.out.print(" |||");
                }
            }
            System.out.println("\nЛевая сумма: " + rsl[1]);
            System.out.println("Правая сумма: " + rsl[2]);
        }else{
            System.out.println("Баланс не найден");
        }
    }

    static int[] findBalance(int[] inputArray){
        int[] rsl = new int[4];
        int leftSum = 0;
        for(int i =0; i<inputArray.length-1;i++){
            leftSum += inputArray[i];
            int rightSum = 0;
            for(int j=i+1; j<inputArray.length;j++){
                rightSum+=inputArray[j];
            }
            if (leftSum==rightSum){
                rsl[0] = i;
                rsl[1] = leftSum;
                rsl[2] = rightSum;
                rsl[3] = 1;
            }
        }
        return rsl;
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
