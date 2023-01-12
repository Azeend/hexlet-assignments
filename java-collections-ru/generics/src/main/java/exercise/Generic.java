package exercise;

import java.util.HashMap;
import java.util.Map;

public class Generic {
    public static Map<String, String> getNewMap(Map<String, String> mapL, Map<String, String> info) {
        Map<String, String> m = new HashMap<>();
        for (Map.Entry<String, String> i : info.entrySet()) {
            if (mapL.containsValue(i.getValue()) && mapL.containsKey(i.getKey())) {
                m.put(i.getKey(), i.getValue());
            }
        }
        return m;
    }
}
