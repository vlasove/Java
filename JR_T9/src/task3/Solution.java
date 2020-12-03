package task3;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        if (args.length > 0) {
            if (args[0].equals("-c")) {
                String productName = args[1];
                String price = args[2];
                String quantity = args[3];
                FileOutputStream stream = new FileOutputStream(fileName, true);


                int maxId = findMaxId(fileName);
                appendToFile(stream, maxId, productName, price, quantity);
                stream.close();
            } else if (args[0].equals("-u")) {
                String idToUpdate = args[1];
                String productNameToUpdate = args[2];
                String priceToUpdate = args[3];
                String quantityToUpdate = args[4];
                updateInFileById(fileName, idToUpdate, productNameToUpdate, priceToUpdate, quantityToUpdate);
            } else if (args[0].equals("-d")) {
                String idToDelete = args[1];
                deleteInFileById(fileName, idToDelete);
            }
        }
        reader.close();

    }

    public static void deleteInFileById(String fileName, String idToDelete) throws Exception {
        List<String> list = new ArrayList<>();
        BufferedReader stream = new BufferedReader(new FileReader(fileName));
        String line = null;
        boolean isFirst = true;
        while ((line = stream.readLine()) != null) {
            if (line.substring(0, 8).trim().equals(idToDelete)) {

            } else {
                if (isFirst) {
                    list.add(line);
                    isFirst = false;
                } else {
                    list.add("\n" + line);
                }
            }
        }
        stream.close();
        FileOutputStream streamOut = new FileOutputStream(fileName);
        for (String msg : list) {
            streamOut.write(msg.getBytes());
        }
        streamOut.close();
    }

    public static void updateInFileById(String fileName, String idToUpdate, String productNameToUpdate, String priceToUpdate, String quantityToUpdate) throws Exception {
        List<String> list = new ArrayList<>();
        BufferedReader stream = new BufferedReader(new FileReader(fileName));
        String line = null, updatedLine = null;
        boolean isFirst = true;
        while ((line = stream.readLine()) != null) {
            if (line.substring(0, 8).trim().equals(idToUpdate)) {
                updatedLine = String.format("%-8s%-30s%-8s%-4s", idToUpdate, productNameToUpdate, priceToUpdate, quantityToUpdate);
//
            } else {
                updatedLine = line;
            }
            if (isFirst) {
                list.add(updatedLine);
                isFirst = false;
            } else {
                list.add("\n" + updatedLine);
            }

        }
        stream.close();
        FileOutputStream streamOut = new FileOutputStream(fileName);
        for (String msg : list) {
            streamOut.write(msg.getBytes());
        }
        streamOut.close();
    }

    public static int findMaxId(String fileName) throws Exception {
        int maxId = 0;
        BufferedReader stream = new BufferedReader(new FileReader(fileName));
        String line = null, last = null;
        while ((line = stream.readLine()) != null) {
            int curId = Integer.parseInt(line.substring(0, 8).trim());
            if (curId > maxId) {
                maxId = curId;
            }
        }
        stream.close();
        return maxId;
    }

    public static void appendToFile(FileOutputStream stream, int maxId, String productName, String price, String quantity) throws Exception {
        String ans = "\n" + String.format("%-8s%-30s%-8s%-4s", ++maxId, productName, price, quantity);
        stream.write(ans.getBytes());
    }

}
