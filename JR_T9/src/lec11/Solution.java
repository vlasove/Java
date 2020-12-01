package lec11;

import java.io.*;

/*
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream = null;
        try {
            while (true) {
                String fileName = reader.readLine();
                stream = new FileInputStream(fileName);
                if (stream.available() < 1000) {
                    reader.close();
                    stream.close();
                    throw  new DownloadException();
                }
            }
        }catch (IOException e){

        }


    }

    public static class DownloadException extends Exception {

    }
}
