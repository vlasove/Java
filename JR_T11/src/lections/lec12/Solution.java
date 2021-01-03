package lections.lec12;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) {
        Solution savedObject = new Solution(4);
        FileOutputStream fileOutput = null;
        ObjectOutputStream outputStream = null;
        try {
            fileOutput = new FileOutputStream("Solution.dat");
            outputStream = new ObjectOutputStream(fileOutput);
            outputStream.writeObject(savedObject);
            fileOutput.close();
            outputStream.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        FileInputStream fiStream = null;
        ObjectInputStream objectStream = null;
        Solution loadedObject = new Solution(3);
        try {
            fiStream = new FileInputStream("Solution.dat");
            objectStream = new ObjectInputStream(fiStream);
            Object object = objectStream.readObject();
            loadedObject = (Solution) object;
            fiStream.close();
            objectStream.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }

        System.out.println(savedObject.string.equals(loadedObject.string));


    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }


}
