package task22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String request = reader.readLine();
            List<Pair> pairs = parseRequest(request);
            printPairs(pairs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printPairs(List<Pair> pairs) {
        List<Object> toPrintVals = new ArrayList<>();
        String toPrintArgs = "";
        for (int i = 0; i < pairs.size(); i++) {
            if (i == pairs.size() - 1) {
                toPrintArgs += pairs.get(i).arg;
            } else {
                toPrintArgs += pairs.get(i).arg + " ";
            }
            if (pairs.get(i).arg.equals("obj"))
                toPrintVals.add(pairs.get(i).val);
        }
        System.out.println(toPrintArgs);
        printVals(toPrintVals);
    }

    public static void printVals(List<Object> toPrintVals) {
        for (Object val : toPrintVals) {
            try {
                Double d = Double.parseDouble((String) val);
                alert(d);
            } catch (Exception e) {
                alert((String) val);
            }
        }
    }


    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

    public static List<Pair> parseRequest(String request) {
        List<Pair> pairs = new ArrayList<>();
        String[] strings = request.split("\\?");
        String[] samplePair = strings[1].split("&");
        for (String sample : samplePair) {
            Pair p = null;
            if (sample.contains("=")) {
                String[] toPair = sample.split("=");
                p = new Pair(toPair[0], toPair[1]);
            } else {
                p = new Pair(sample, null);
            }
            pairs.add(p);
        }
        return pairs;
    }

    public static class Pair {
        public String arg;
        public String val;

        public Pair(String arg, String val) {
            this.arg = arg;
            this.val = val;
        }

        @Override
        public String toString() {
            return this.arg + ":" + this.val;
        }
    }
}
