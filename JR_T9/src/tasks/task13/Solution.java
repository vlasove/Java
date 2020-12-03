package tasks.task13;

import java.io.*;
import java.util.*;

/*
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        ArrayList<String> files = new ArrayList<>();    // литс для всех имен файлов
        while (!(fileName = reader.readLine()).equals("end")){  // читаем, заполняем лист
            files.add(fileName);
        }
        reader.close();
        int lastDot = files.get(0).lastIndexOf(".");
        String resultName = files.get(0).substring(0, lastDot);

        Comparator<String>  comparyByLastId = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1.substring(o1.lastIndexOf(".") + 5, o1.length());
                String s2 = o2.substring(o2.lastIndexOf(".") + 5, o2.length());
                int v1 = Integer.parseInt(s1);
                int v2 = Integer.parseInt(s2);
                if (v1 > v2){
                    return 1;
                } else if(v1 < v2){
                    return - 1;
                } else {
                    return 0;
                }
            }
        };
        Collections.sort(files, comparyByLastId);
        FileOutputStream streamOut = new FileOutputStream(resultName, true);

        for(String file : files){
            FileInputStream streamIn = new FileInputStream(file);
            byte[] bytes = new byte[streamIn.available()];
            streamIn.read(bytes);
            streamOut.write(bytes);
            streamIn.close();
        }
        streamOut.close();

    }
}
