package test;

import helper.StringHelper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    @Test
    void splitOnSentences() {
        // only one sentence
        {
            List<String> list = new ArrayList<>() {
                {
                    add("the only sentence here!?");
                }
            };

            StringBuilder text = new StringBuilder();
            for (var item : list) {
                text.append(item).append(" ");
            }

            assertEquals(list, StringHelper.splitOnSentences(text.toString()));
        }
        // several sentences
        {
            List<String> list = new ArrayList<>() {
                {
                    add("sentence number one.");
                    add("інше речення, чом би й не спробувати.");
                    add("What's the problem, dude?");
                    add("Також інше речення!!");
                    add("Sentence.");
                }
            };

            StringBuilder text = new StringBuilder();
            for (var item : list) {
                text.append(item).append(" ");
            }

            assertEquals(list, StringHelper.splitOnSentences(text.toString()));
        }
        // empty string
        {
            String text = "";

            assertTrue(StringHelper.splitOnSentences(text).isEmpty());
        }
    }
}