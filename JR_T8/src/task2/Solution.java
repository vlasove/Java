package task2;



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
    public static volatile  List<Person> allPeople = new ArrayList<Person>();
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
        switch (args[0]){
            case "-c":
                synchronized (allPeople) {
                    for (int i = 0; i < (args.length - 1) / 3; i++) {
                        Person p = null;
                        if (args[2 + i*3].equals("м")) {
                            p = Person.createMale(args[1 + i * 3], parseDate(args[3 + i*3]));
                        } else {
                            p = Person.createFemale(args[1 + i * 3], parseDate(args[3 + i * 3]));
                        }
                        allPeople.add(p);
                        System.out.println(allPeople.indexOf(p));
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 0; i < (args.length - 1) / 4; i++) {
                        int id = parseID(args[1 + i * 4]);
                        Person personToUpdate = allPeople.get(id);
                        personToUpdate.setName(args[2 + i*4]);
                        personToUpdate.setSex(parseSex(args[3 + i*4]));
                        personToUpdate.setBirthDate(parseDate(args[4 + i*4]));
                        allPeople.set(id, personToUpdate);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 0; i < (args.length - 1); i++) {
                        int id = parseID(args[1 + i * 1]);
                        Person personOnDelete = allPeople.get(id);
                        personOnDelete.setName(null);
                        personOnDelete.setBirthDate(null);
                        personOnDelete.setSex(null);
                        allPeople.set(id, personOnDelete);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for(int i =0; i <(args.length -1); i++){
                        int id = parseID(args[1 + i*1]);
                        Person personToPrint = allPeople.get(id);
                        System.out.println(personToPrint);
                    }
                }
                break;
        }
//        if (flag.equals("-c")) {
//            //Добавляет человека в конец и выводит индекс
//            // -c name sex bd name1 sex1 bd1 name2 sex2 bd2.... nameN sexN bdN
//            // 0   1    2   3  4     5    6   7     8    9
//            //М/Ж
//            // (args.length - 1)/3 = количество наборов (name, sex, bd)
//
//
//
//        } else if (flag.equals("-u")) {
//            //Обновляет данные человека с id
//            //-u id name sex bd id1 name1 sex1 bd1 ...
//            // (args.length - 1) / 4 - количество наборов (id, name, sex, bd)
//
//
//
//
//        } else if (flag.equals("-d")) {
//            //"Удаление" персоны. Заменяем все поля на null
//            //-d id1 id2 id3 id4 ....
//            //args.length - 1 = количество наборов (id)
//
//        } else if (flag.equals("-i")) {
//            //Выводит информацию про человека с id
//            //-i id
//
//        }
    }
}
