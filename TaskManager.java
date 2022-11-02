import helper.DisplayHelper;
import helper.FileHelper;
import helper.InputHelper;
import helper.StringHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskManager {

    static String data = "";

    static void fromFile() {
        data = FileHelper.readFile("input.txt");
        doTask();
    }

    static void fromConsole() {
        DisplayHelper.printText("Write text in console in one line");
        data = InputHelper.readConsole();
        doTask();
    }

    static void doTask() {
        List<String> strings = StringHelper.splitOnSentences(data);
        List<String> words = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\w+(?=\\s*\\p{Punct}*\\s+\\w+\\p{Punct}*\\s*[.?!])");

        for (String item : strings) {
            Matcher mat = pattern.matcher(item);

            if (mat.find()) {
                words.add(mat.group());
            }
        }

        DisplayHelper.printText("All words before last word in each sentences:");
        DisplayHelper.printList(words);
    }
}
