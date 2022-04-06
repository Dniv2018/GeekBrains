package Java_Level_02.Lesson_03;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    HashMap<String, HashSet<String>> phonebox;

    public PhoneBook(){
        this.phonebox = new HashMap<>();
    }

    public void add(String family, String number){
        HashSet <String> phone = phonebox.getOrDefault(family, new HashSet<>());
        phone.add(number);
        phonebox.put(family, phone);
    }

    public HashSet get(String key){
        return phonebox.get(key);
    }




//    2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
//    В этот телефонный справочник с помощью метода add() можно добавлять записи.
//    С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под однойbфамилией может быть
//    несколько телефонов(в случае однофамильцев),тогда при запросе такой фамилии должны выводиться все телефоны.




}
