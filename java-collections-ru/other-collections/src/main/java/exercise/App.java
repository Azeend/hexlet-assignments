package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>();
        Set<String> keySet = new TreeSet<>();
        keySet.addAll(data1.keySet());
        keySet.addAll(data2.keySet());

        for (String key: keySet) {
            if (!data1.containsKey(key) && data2.containsKey(key)) {
                result.put(key, "added");
            }else if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.put(key, "deleted");
            }else if (data1.containsKey(key) && data2.containsKey(key) && !data1.get(key).equals(data2.get(key))) {
                result.put(key, "changed");
            }else if (data1.containsKey(key) && data2.containsKey(key) && data1.get(key).equals(data2.get(key))) {
                result.put(key, "unchanged");
            }
        }
        return result;
    }
}
//END
