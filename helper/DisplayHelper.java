package helper;

import java.util.List;

public class DisplayHelper {
    public static void start() {
        System.out.println("\nSelect an input type:");
        System.out.println("1. File");
        System.out.println("2. Console");
        System.out.println("3. I want exit program");
    }

    public static void printText(String str) {
        System.out.println(str);
    }

    public static void printList(List<String> words) {
        for (String item : words) {
            System.out.print(item + ", ");
        }
        System.out.println("");
    }
}
