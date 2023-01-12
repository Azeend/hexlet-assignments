package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

import static exercise.Generic.getNewMap;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String >> booksInfo, Map<String, String> info) {
        List<Map<String, String>> books = new ArrayList<>();
        for (Map<String, String> mapL: booksInfo) {
            Map<String, String> m = getNewMap(mapL, info);
            if (m.equals(info)) {
                books.add(mapL);
            }
        }
        return books;
    }
}
//END
