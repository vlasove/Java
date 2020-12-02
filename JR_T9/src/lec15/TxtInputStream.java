package lec15;

import java.io.*;
import java.nio.channels.FileChannel;

/*
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    private FileInputStream component;

    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException, IOException {
        super(fileName);
        if(fileName.endsWith(".txt")){
            super.close();
            throw new UnsupportedFileNameException();
        }
        this.component = new FileInputStream(fileName);

    }

    public TxtInputStream(File file) throws FileNotFoundException {
        super(file);
    }

    public TxtInputStream(FileDescriptor fdObj) {
        super(fdObj);
    }

    @Override
    public int read() throws IOException {
        return component.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return component.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return component.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return component.skip(n);
    }

    @Override
    public int available() throws IOException {
        return component.available();
    }

    @Override
    public void close() throws IOException {
        component.close();
    }

    @Override
    public FileChannel getChannel() {
        return component.getChannel();
    }

    public static void main(String[] args) {
    }
}
