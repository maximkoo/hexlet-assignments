package exercise;

// BEGIN
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    Map<String, String> map = new HashMap<>();
    String path;

    public FileKV(String path, Map<String, String> initial) {
        for (String s : initial.keySet()) {
            this.map.put(s, initial.get(s));
        }
        this.path = path;
        System.out.println("Written0");
        Utils.writeFile(path, Utils.serialize(initial));
        System.out.println("Written");
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
        Utils.writeFile(path, Utils.serialize(map));
    }

    @Override
    public void unset(String key) {
        map.remove(key);
        Utils.writeFile(path, Utils.serialize(map));
    }

    @Override
    public String get(String key, String defaultValue) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return defaultValue;
        }
    }

    public Map<String, String> toMap() {
        //return map;
        Map<String, String> map2 = new HashMap<>();
        map2.putAll(this.map);
        return map2;
    }
}
// END
