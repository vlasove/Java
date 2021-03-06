package lec13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream component;

    public QuestionFileOutputStream(AmigoOutputStream component) {
        this.component = component;
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choise = new String();
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        choise = reader.readLine();
        reader.close();

        if(choise.equals("Д")){
            component.close();
        }
    }
}

