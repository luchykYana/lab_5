package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringHelper {
    public static List<String> splitOnSentences(String str) {
        String[] result = str.split("(?<=[\\S][!?.])\\s+");
        return str.isBlank() ? new ArrayList<>() : Arrays.asList(result);
    }
}
