package lections.lec5;

import java.io.IOException;

public interface PersonScanner {
    Person read() throws IOException;

    void close() throws IOException;
}

