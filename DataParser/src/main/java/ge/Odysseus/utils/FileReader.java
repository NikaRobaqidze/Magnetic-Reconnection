package ge.Odysseus.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader{
    public static Path dataAbsPath = Paths.get(System.getProperty("user.dir"))
            .resolve("src").resolve("main").resolve("java").resolve("ge")
            .resolve("Odysseus").resolve("sources");
    String FileName;
    Readable condition;

    public FileReader(String fileName, Readable condition) {
        this.FileName = fileName;
        this.condition = condition;
    }

    public void readLines() {

        String fileName = this.FileName;

        Path dataFileAbsPath = Paths.get(System.getProperty("user.dir"))
                .resolve(dataAbsPath).resolve(fileName);

        String filePath = dataFileAbsPath.toString(); // Replace with the actual file path
        try (FileInputStream inputStream = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            String[] perv = new String[20];
            while ((line = br.readLine()) != null) {

                String[] stringArray = line.split("\\s+");

                this.condition.readLine(perv, stringArray);
                perv = stringArray;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                "FileName='" + FileName + '\'' +
                '}';
    }
}
