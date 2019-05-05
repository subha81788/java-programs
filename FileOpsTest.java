import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileOpsTest {

    public static final String inFile = "input.txt";

    public static void main(String[] args) throws IOException {
        System.out.println("File content: " + getFileContent(inFile));
        System.out.println("First line: " + getFirstLine(inFile));
        System.out.println("Lines count: " + countLines(inFile));
        printLines(inFile);
        System.out.println("\n\nAll lines\n" + getAllLines(inFile));
    }

    public static String getFileContent(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        char[] buffer = new char[10];
        while(br.read(buffer) != -1) {
            sb.append(buffer);
            buffer = new char[10];
        }
        return sb.toString();
    }

    public static String getAllLines(String filePath) {
        StringBuilder sb = new StringBuilder();
        
        try {
            Files.lines(Paths.get(filePath)).forEachOrdered(s -> {
            sb.append(s); 
            sb.append(System.lineSeparator());
            }); 
        } catch(IOException e) {
            System.err.println(e);
        }
        
        return sb.toString();
    }

    public static String getFirstLine(String filePath) {
        String line = null;
        Path path = Paths.get(filePath);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            line = br.readLine();
        } catch(IOException e) {
            System.err.println(e);
        }
        return line;
    }

    public static void printLines(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),Charset.forName("UTF-8")));
            br.lines().forEach(System.out::println);
        } catch(IOException e) {
            System.err.println(e);
        }
    }

    public static long countLines(String filePath) {
        Path path = Paths.get(filePath);
        long count = 0L;
        try (BufferedReader br = Files.newBufferedReader(path)) {
            count = br.lines().count();
        } catch(IOException e) {
            System.err.println(e);
        }
        return count;
    }
}
