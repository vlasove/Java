package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution19 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line.toLowerCase());
        }
        Map<Character, Integer> mapper = createMap(list, alphabet);
        for(Character chr : alphabet){
            System.out.println(chr + " " + mapper.get(chr));
        }

        // напишите тут ваш код
    }

    public static Map<Character, Integer> createMap(List<String> messages, List<Character> alphabet){
        Map<Character, Integer> counter = new HashMap<>();
        for(Character chr: alphabet){
            counter.put(chr, 0);
        }
        for(String message: messages){
            for(int i =0; i < message.length(); i++){
                if (alphabet.contains(  message.toLowerCase().charAt(i))){
                    //Этап добавления в словарь
                    //Если уже был - то +1 в value
                    if(counter.containsKey(message.toLowerCase().charAt(i))){
                        counter.replace(message.toLowerCase().charAt(i), counter.get(message.toLowerCase().charAt(i)) + 1);
                    } else {
                        counter.replace((message.toLowerCase().charAt(i)), 1);
                    }
                }
            }
        }
        return counter;
    }

}
