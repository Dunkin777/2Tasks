import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Contacts {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfOperations = Integer.parseInt(bufferedReader.readLine());
        List<String> contacts = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < numberOfOperations; i++) {
            lines.add(bufferedReader.readLine());
        }
        for (String line :
                lines) {
            String[] currentLine = line.split(" ");
            String currentOperation = currentLine[0];
            switch (currentOperation) {
                case "add" -> contacts.add(currentLine[1]);
                case "find" -> {
                    long count = contacts.stream().filter(s -> s.contains(currentLine[1])).count();
                    System.out.println(count);
                }
            }
        }
    }
}
