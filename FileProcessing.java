import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessing {
    public static void main(String[] args) {
        
        String inputFilePath = "E:\\java\\input.txt";
        String outputFilePath = "E:\\java\\output.txt";

        try {
            
            String inputData = readFile(inputFilePath);

            
            String processedData = processData(inputData);

            
            writeFile(outputFilePath, processedData);

            System.out.println("File processing successful.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static String readFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            return content.toString();
        }
    }

    private static String processData(String input) {
        
        return input.toUpperCase();
    }

    private static void writeFile(String filePath, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        }
    }
}