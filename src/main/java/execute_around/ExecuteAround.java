package execute_around;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
    public static String processFile(final BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/execute_around/data.txt"))) {
            return bufferedReaderProcessor.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String singleLineRead = processFile(bufferedReader -> bufferedReader.readLine());
        System.out.println(singleLineRead);

        String multipleLineRead = processFile(bufferedReader -> {
            String read = "";
            String currentString;
            while((currentString = bufferedReader.readLine()) != null)
                read += currentString;
            return read;
        });
        System.out.println(multipleLineRead);
    }
}
