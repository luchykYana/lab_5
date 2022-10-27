package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHelper {
    public static String readFile(String name) {
        StringBuilder fileData = new StringBuilder();

        try {
            File file = new File(name);
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fileData.append(" ").append(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return "";
        }

        return fileData.toString();
    }
}
