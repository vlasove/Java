package lections.lec20;

import javax.swing.text.Document;
import javax.swing.text.html.HTML;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String fileName = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            fileName = reader.readLine();
            reader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }



        BufferedReader fileReader = null;
        try{
            fileReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }

        StringBuilder contentOfFile = new StringBuilder();
        try{
            while (fileReader.ready()){
                contentOfFile.append(fileReader.readLine());
            }
            fileReader.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }

        String content = contentOfFile.toString().replaceAll("\r\n", "");
        //System.out.println(content);


        String openTag = "<" + args[0];
        String closeTag = "</" + args[0];
        int closedTagLength = closeTag.length();


        //Наполняем стеки с тегами индексами
        TagStack openTagsIDs = makeStack(content, openTag);
        TagStack closedTagsIDs = makeStack(content, closeTag);
        closedTagsIDs.reverseStack();

        StringStack answerStack = makeStringStack(openTagsIDs, closedTagsIDs, closedTagLength, content);
        while(!answerStack.isEmpty()){
            System.out.println(answerStack.popFromStack());
        }


    }

    public static StringStack makeStringStack(TagStack openTagsIDs, TagStack closedTagsIDs, int closedTagLength, String content){
        StringStack stack = new StringStack();
        //TODO:Нужна другая логика наполнения стеков
        while(!openTagsIDs.isEmpty() && !closedTagsIDs.isEmpty()){
            int start = openTagsIDs.popFromStack();
            int finish = closedTagsIDs.popFromStack();
            stack.pushToStack(content.substring(start, finish + 1 + closedTagLength));
        }
        return stack;
    }

    public static TagStack makeStack(String content, String tag){
        //TODO: нужно заполнять стеки по необходимости
        TagStack stack = new TagStack();
        int index = content.indexOf(tag);
        while(index >= 0){
            stack.pushToStack(index);
            index = content.indexOf(tag, index + 1);

        }

        return stack;
    }

    public static class TagStack {
        private List<Integer> stack;

        public TagStack(){
            stack = new ArrayList<>();
        }

        public void pushToStack(int val){
            this.stack.add(val);
        }

        public int popFromStack(){
            int lastID = this.stack.size() - 1;
            int elem = this.stack.get(lastID);
            this.stack.remove(lastID);
            return elem;
        }

        public void reverseStack(){
            Collections.reverse(this.stack);
        }

        public boolean isEmpty(){
            return this.stack.isEmpty();
        }
    }

    public static class StringStack {
        private List<String> stack;

        public StringStack(){
            stack = new ArrayList<>();
        }

        public void  pushToStack(String str){
            this.stack.add(str);
        }

        public String popFromStack(){
            int lastID = this.stack.size() - 1;
            String elem = this.stack.get(lastID);
            this.stack.remove(lastID);
            return elem;
        }

        public boolean isEmpty(){
            return this.stack.isEmpty();
        }
    }
}
