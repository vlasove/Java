package task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat formatterFrom = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat formatterTo = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static Date parseDate(String stringDate) {
        Date date = null;
        try {
            date = formatterFrom.parse(stringDate);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return date;
    }

    public static int parseID(String stringID){
        int id = -1;
        try{
            id = Integer.parseInt(stringID);
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }
        return id;
    }

    public static Sex parseSex(String sexString){
        if(sexString.equals("м")){
            return Sex.MALE;
        }
        return Sex.FEMALE;
    }

    public static void main(String[] args) {
        //start here - начни тут
        String flag = args[0];
        if (flag.equals("-c")) {
            //Добавляет человека в конец и выводит индекс
            // -c name sex bd
            //М/Ж

            Person p = null;
            if (args[2].equals("м")) {
                p = Person.createMale(args[1], parseDate(args[3]));
            } else {
                p = Person.createFemale(args[1], parseDate(args[3]));
            }
            allPeople.add(p);
            System.out.println(allPeople.indexOf(p));

        } else if (flag.equals("-u")) {
            //Обновляет данные человека с id
            //-u id name sex bd
            int id = parseID(args[1]);
            Person personToUpdate = allPeople.get(id);
            personToUpdate.setName(args[2]);
            personToUpdate.setSex(parseSex(args[3]));
            personToUpdate.setBirthDate(parseDate(args[4]));
            allPeople.set(id, personToUpdate);

        } else if (flag.equals("-d")) {
            //"Удаление" персоны. Заменяем все поля на null
            //-d id
            int id = parseID(args[1]);
            Person personOnDelete = allPeople.get(id);
            personOnDelete.setName(null);
            personOnDelete.setBirthDate(null);
            personOnDelete.setSex(null);
            allPeople.set(id, personOnDelete);
        } else if (flag.equals("-i")) {
            //Выводит информацию про человека с id
            //-i id
            int id = parseID(args[1]);
            Person personToPrint = allPeople.get(id);
            System.out.println(personToPrint);
        }
    }
}
