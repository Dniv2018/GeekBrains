package Java_Level_02.Lesson_02;

public class Main {
    public static void main(String[] args) {

        Solid notright1 = new Solid("Массив №1 с нарушенной размерностью", new String[][] {{"1","1","1"}, {"1","1"}});
        Solid notright2 = new Solid("Массив №2 с нарушенной размерностью", new String[][] {{"1","1","1","1","1"}, {"1","1"}, {"1","1"},{"1","1"}});
        Solid notright3 = new Solid("Массив №3 с нарушенной размерностью", new String[][] {{"1","1","1","1"}, {"1","1"}, {"1","1"}, {"1","1"}});
        Solid error = new Solid("Массив с ошибками", new String[][] {{"1","1","1","1"},{"1","З", null,"1"},{"1","I","1","1"},{"1","1","1","1"}});
        Solid right = new Solid("Правильный массив", new String[][] {{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"}});

        MyArrays arrays = new MyArrays(right, error, notright1, notright2, notright3);


        for (Solid a: arrays.getArray()) {
            sumArrayUnStoppAble(a);
        }

        System.out.println("\nМетод с останавливающими исключениями");
        for (Solid a: arrays.getArray()) {
            sumArrayStop(a);
        }


    }

    private static void sumArrayUnStoppAble(Solid a) {
        int count;
        System.out.println(a.getName());
        String[][] massif = a.getMass();
        int len = massif.length;
        try {
            if (len != 4) throw new MyArraySizeException("");
        }catch (MyArraySizeException e){
            System.out.println("Ощибка размера массива. Число строк: надо - 4, найдено - " + len);
        }
//        if (len != 4) throw new MyArraySizeException
//                ("Ощибка размера массива. Число строк: надо - 4, найдено - " + len);

        for (int i=0; i<len;i++){
            int innerLen = massif[i].length;
            try {
                if (innerLen !=4) throw new MyArraySizeException("");
            }catch (MyArraySizeException e){
                System.out.println("Ощибка размера массива. Число столбцов в строке с индексом " + i + ": надо - 4, найдено - " + innerLen);
            }
//            if (innerLen !=4) throw new MyArraySizeException
//                    ("Ощибка размера массива. Число столбцов в строке с индексом " + i + ": надо - 4, найдено - " + innerLen);
        }

        count = 0;
        for (int i=0; i<len;i++){
            for (int j=0; j<massif[i].length;j++){
                try {
                    count += Integer.parseInt(massif[i][j]);
                }catch (NumberFormatException e){
                    System.out.println("В ячейке с координатами: [" + i + "][" + j + "] лежат неверные данные");
//                        throw new MyArrayDataException("В ячейке с координатами: [" + i + "][" + j + "] лежат неверные данные");
                }
            }
        }
        System.out.println(a.getName() + " имеет сумму " + count);
        System.out.println(" ");
    }

    private static void sumArrayStop(Solid a) {
        int count;
        System.out.println(a.getName());
        String[][] massif = a.getMass();
        int len = massif.length;
        if (len != 4) throw new MyArraySizeException
                ("Ощибка размера массива. Число строк: надо - 4, найдено - " + len);

        for (int i=0; i<len;i++){
            int innerLen = massif[i].length;
            if (innerLen !=4) throw new MyArraySizeException
                    ("Ощибка размера массива. Число столбцов в строке с индексом " + i + ": надо - 4, найдено - " + innerLen);
        }

        count = 0;
        for (int i=0; i<len;i++){
            for (int j=0; j<massif[i].length;j++){
                try {
                    count += Integer.parseInt(massif[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("В ячейке с координатами: [" + i + "][" + j + "] лежат неверные данные");
                }
            }
        }
        System.out.println(a.getName() + " имеет сумму " + count);
        System.out.println(" ");
    }
}
