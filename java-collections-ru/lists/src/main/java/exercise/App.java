package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String args, String word) {
        var anyWord = word.toLowerCase();
        char[] argsArray = args.toCharArray();
        char[] wordArray = anyWord.toCharArray();
        List<Character> listArgs = new ArrayList<>();
        List<Character> listWord = new ArrayList<>();

        for (char w : wordArray) {
            listWord.add(w);
        }
        for (char c : argsArray) {
                listArgs.add(c);
        }

        for (var s : listWord) {
            if (listArgs.contains(s)) {
                listArgs.remove(s);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
