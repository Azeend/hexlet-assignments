package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> data = storage.toMap();
        for(Map.Entry<String,String> map : data.entrySet()){
            storage.unset(map.getKey());
            storage.set(map.getValue(), map.getKey());
        }
    }
}
// END
