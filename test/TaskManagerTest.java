package test;

import helper.FileHelper;
import helper.InputHelper;
import helper.StringHelper;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void fromFile() {
        assertEquals(" Hello. My name is Yana.", FileHelper.readFile("test.txt"));
    }

    @Test
    void fromConsole() {
        {
            System.setIn(new ByteArrayInputStream("just normal text from a line\n\n".getBytes()));
            assertEquals("just normal text from a line", InputHelper.readConsole());
        }

        {
            System.setIn(new ByteArrayInputStream("\n\n".getBytes()));
            assertEquals("", InputHelper.readConsole());
        }
    }

    @Test
    void doTask() {
        {
            List<String> list = new ArrayList<>() {
                {
                    add("");
                    add("the1 ?");
                    add("the2 only?");
                    add("the3 only .");
                    add("the4 only.");
                    add("the5 only one1 word.");
                    add("the5 only one2, word.");
                    add("the5 only one3 , word.");
                }
            };

            List<String> words = new ArrayList<>();

            Pattern pattern = Pattern.compile("\\w+(?=\\s*\\p{Punct}*\\s+\\w+\\p{Punct}*\\s*[.?!])");

            for (String item : list) {
                Matcher mat = pattern.matcher(item);

                if (mat.find()) {
                    words.add(mat.group());
                }
            }

            assertEquals(words, new ArrayList<>() {
                {
                    add("the2");
                    add("the3");
                    add("the4");
                    add("one1");
                    add("one2");
                    add("one3");
                }
            });
        }
    }
}