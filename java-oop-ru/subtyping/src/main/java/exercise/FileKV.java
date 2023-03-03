package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    private String path;
    private Map<String,String> map;

    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        this.map = new HashMap<>(map);
    }

    @Override
    public void set(String key, String value) {
        Map<String,String> data = toMap();
        data.put(key,value);
        Utils.writeFile(this.path, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        Map<String,String> data = toMap();
        data.remove(key);
        Utils.writeFile(this.path, Utils.serialize(data));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> data = toMap();
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String filePath = Utils.readFile(path);
        Map<String,String> data = Utils.unserialize(filePath);
        return data;
    }
}
// END
