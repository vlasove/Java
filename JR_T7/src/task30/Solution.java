package task30;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private boolean isRun = false;
        private List<String> lines = new ArrayList<>();

        public  void run(){
            BufferedReader fileReader = null;
            isRun = true;

            try {
                fileReader = new BufferedReader(new FileReader(this.fileName));
                String line = fileReader.readLine();
                while (line != null) {
                    lines.add(line);
                    line = fileReader.readLine();
                }
                fileReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            if (!isRun){
                return "";
            }
            return String.join(" ", lines);
        }
    }

    //add your code here - добавьте код тут
}