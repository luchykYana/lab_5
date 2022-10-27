package helper;

import java.util.Scanner;

public class InputHelper {
    public static String readConsole() {
        Scanner myObj = new Scanner(System.in);

        return myObj.nextLine();
    }
}
