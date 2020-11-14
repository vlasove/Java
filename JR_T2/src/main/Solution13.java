package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Solution13 {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        for(int i =1; i <= 10; i++){
            map.put("Смирнов" + i, dateFormat.parse("MAY " + i + " 2012"));
        }
        return map;

        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Map<String, Date> copyMap = new HashMap<>();
        copyMap.putAll(map);
        for(Map.Entry<String, Date> pair : copyMap.entrySet()) {
            Date cur = pair.getValue();
            if (cur.getMonth() >= 5 && cur.getMonth() <= 7) {
                map.remove(pair.getKey());
            }
        }

    }

    public static void main(String[] args) {

    }

}
