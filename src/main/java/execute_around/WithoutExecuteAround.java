package execute_around;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WithoutExecuteAround {

    // here is one limitation, we can't do anything if we
    // want to read many more words
    public static String processFile() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/execute_around/data.txt"))) {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(processFile());
    }
}
