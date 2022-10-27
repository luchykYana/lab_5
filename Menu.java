import helper.DisplayHelper;
import helper.InputHelper;

public class Menu {
    static void menu() {
        while (true) {
            DisplayHelper.start();

            String choice = InputHelper.readConsole();
            switch (choice) {
                case "1" -> TaskManager.fromFile();
                case "2" -> TaskManager.fromConsole();
                case "3" -> {
                    System.out.println("Exit");
                    return;
                }
                default -> System.out.println("Not correct. Try again");
            }
        }

    }
}
