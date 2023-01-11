package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        if (sentence.equals("")) {
            return new HashMap<>();
        }
        Map<String, Integer> words = new HashMap<>();
        String[] sentenceAsArray = sentence.split(" ");
        for (String c: sentenceAsArray){
            var countWord = 1;
            if (words.containsKey(c)){
                countWord = words.get(c);
                countWord++;
            }
            words.put(c,countWord);
        }
        return words;
    }

    public static String toString(Map<String, Integer> words) {
        if (words.isEmpty()) {
            return "{}";
        }
        var k = "{" + "\n";
        for (String key: words.keySet()) {
            k = k + "  " + key + ": " + words.get(key) + "\n";
        }
        String wordsAsString = k + "}";
        return wordsAsString;
    }
}
//END
