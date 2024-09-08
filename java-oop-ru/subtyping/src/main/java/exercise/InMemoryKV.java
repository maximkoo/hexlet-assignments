package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage{
    public static void main(String[] args) {

public class InMemoryKV implements KeyValueStorage {
    Map<String, String> map = new HashMap<>();

    public InMemoryKV(Map<String, String> map) {
        //this.map = map;
        for (String s : map.keySet()) {
            this.map.put(s, map.get(s));
        }
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return defaultValue;
        }
    }

    @Override
    public Map<String, String> toMap() {
        //return map;
        Map<String, String> map2 = new HashMap<>();
        map2.putAll(this.map);
        return map2;
    }
}
// END
