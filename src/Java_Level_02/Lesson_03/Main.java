package Java_Level_02.Lesson_03;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] str = {"main", "public", "class", "static", "String", "java", "class", "massif", "array", "Class", "java", "java"};
        HashMap<String, Integer> hm_collection = new HashMap<>();

        for (String arr: str) {
            hm_collection.put(arr, 0);
        }
        for (Map.Entry<String, Integer> hm: hm_collection.entrySet()) {
            for (String innerArr: str) {
                if (innerArr.equals(hm.getKey())){
                    hm_collection.put(hm.getKey(), hm.getValue()+1);
                }
            }
        }
        System.out.println(hm_collection);


        PhoneBook pb = new PhoneBook();

        pb.add("Иванов","777");
        pb.add("Петров","555");
        pb.add("Сидоров","333");
        pb.add("Иванов","222");
        pb.add("Васечкин","777");
        pb.add("Прыгунов","111");
        pb.add("Сидоров","444");


        String[] family = {"Иванов", "Петров", "Найденов"};

        for (String s: family) {
            if (pb.get(s) !=null){
                System.out.println(s + ": " + pb.get(s));
            }else System.out.println(s + ": такой фамилии не обнаружено");
        }
    }
}
