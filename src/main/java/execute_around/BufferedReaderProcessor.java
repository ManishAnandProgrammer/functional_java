package execute_around;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(final BufferedReader bufferedReader) throws IOException;
}
