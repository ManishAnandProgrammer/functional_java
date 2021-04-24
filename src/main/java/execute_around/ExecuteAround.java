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
        String singleLineRead = processFile(BufferedReader::readLine);
        System.out.println(singleLineRead);

        String multipleLineRead = processFile(bufferedReader -> {
            StringBuilder read = new StringBuilder();
            String currentString;
            while((currentString = bufferedReader.readLine()) != null)
                read.append(currentString);
            return read.toString();
        });
        System.out.println(multipleLineRead);
    }
}
