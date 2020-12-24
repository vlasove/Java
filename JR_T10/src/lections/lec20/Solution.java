package lections.lec20;

import javax.sound.sampled.Line;
import javax.swing.text.Document;
import javax.swing.text.html.HTML;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String fileName = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName = reader.readLine();
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        StringBuilder contentOfFile = new StringBuilder();
        try {
            while (fileReader.ready()) {
                contentOfFile.append(fileReader.readLine());
            }
            fileReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        String content = contentOfFile.toString().replaceAll("\r\n", "");

        String openTag = "<" + args[0];
        String closeTag = "</" + args[0];
        int closedTagLength = closeTag.length();
        //System.out.println(content);


        TagStack openTagsIDs = makeStack(content, openTag);
        TagStack closedTagsIDs = makeStack(content, closeTag);
        closedTagsIDs.reverseStack();

//        System.out.println("Open Tags:");
//        while (!openTagsIDs.isEmpty()){
//            System.out.println(openTagsIDs.popFromStack());
//        }
//        System.out.println("\n\n");
//        System.out.println("Closed Tags:");
//        while(!closedTagsIDs.isEmpty()){
//            System.out.println(closedTagsIDs.popFromStack());
//        }

        List<ListItem> answerList = makeStringStack(openTagsIDs, closedTagsIDs, closedTagLength, content);
//        while(!answerStack.isEmpty()){
//            System.out.println(answerStack.popFromStack());
//        }

        //Теперь сортируем ListItem
        Collections.sort(answerList, new Comparator<ListItem>() {
            public int compare(ListItem l1, ListItem l2) {
                return l1.openTagID - l2.openTagID;
            }
        });

        for (ListItem line : answerList) {
            System.out.println(line.str);
        }


    }


    public static List<ListItem> makeStringStack(TagStack openTagsIDs, TagStack closedTagsIDs, int closedTagLength, String content) {
        List<ListItem> lines = new ArrayList<>();
        StringStack stack = new StringStack();

        TagStack temporaryOpenTagsIDs = new TagStack();
        while (!openTagsIDs.isEmpty() && !closedTagsIDs.isEmpty()) {
            int start = openTagsIDs.popFromStack();
            int finish = closedTagsIDs.popFromStack();
            if (finish < start) {
                while (finish < start) {
                    temporaryOpenTagsIDs.pushToStack(start);
                    start = openTagsIDs.popFromStack();
                }

                //Опустошаем промежуточный стек
                while (!temporaryOpenTagsIDs.isEmpty()) {
                    openTagsIDs.pushToStack(temporaryOpenTagsIDs.popFromStack());
                }
                //Кладем в стек строк найденную строчку
//                stack.pushToStack(content.substring(start, finish + 1 + closedTagLength));
            } else {
                //Сначала вываливаем все строки в список
                while (!stack.isEmpty()) {
                    lines.add(stack.popFromStack());
                }

                //Добавляем в стек новую строку

            }
            stack.pushToStack(new ListItem(content.substring(start, finish + 1 + closedTagLength), start));
        }
        //Все что осталось в стеке - в список
        while (!stack.isEmpty()) {
            lines.add(stack.popFromStack());
        }
        return lines;
    }

    public static TagStack makeStack(String content, String tag) {

        TagStack stack = new TagStack();
        int index = content.indexOf(tag);
        while (index >= 0) {
            stack.pushToStack(index);
            index = content.indexOf(tag, index + 1);

        }

        return stack;
    }

    public static class TagStack {
        private List<Integer> stack;

        public TagStack() {
            stack = new ArrayList<>();
        }

        public void pushToStack(int val) {
            this.stack.add(val);
        }

        public int popFromStack() {
            int lastID = this.stack.size() - 1;
            int elem = this.stack.get(lastID);
            this.stack.remove(lastID);
            return elem;
        }

        public void reverseStack() {
            Collections.reverse(this.stack);
        }

        public boolean isEmpty() {
            return this.stack.isEmpty();
        }
    }

    public static class StringStack {
        private List<ListItem> stack;

        public StringStack() {
            stack = new ArrayList<>();
        }

        public void pushToStack(ListItem str) {
            this.stack.add(str);
        }

        public ListItem popFromStack() {
            int lastID = this.stack.size() - 1;
            ListItem elem = this.stack.get(lastID);
            this.stack.remove(lastID);
            return elem;
        }

        public boolean isEmpty() {
            return this.stack.isEmpty();
        }
    }

    public static class ListItem {
        public String str;
        public int openTagID;

        public ListItem(String str, int openTagID) {
            this.str = str;
            this.openTagID = openTagID;
        }
    }
}
