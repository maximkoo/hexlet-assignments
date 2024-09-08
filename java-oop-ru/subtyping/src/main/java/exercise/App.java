package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static void main(String[] args) {
//        KeyValueStorage storage = new InMemoryKV(Map.of("key1", "value1"));
//        storage.set("key2", "value2");
//        System.out.println("ALL DONE!!!");
//        swapKeyValue(storage);
//        System.out.println("My Test");
//        System.out.println(storage.get("value2",""));
//        FileKV fkv = new FileKV("src\\test\\resources\\file",Map.of("key1", "value1"));
    }

    public static void swapKeyValue(KeyValueStorage kv) {

        Map<String, String> map2 = new HashMap<>();
        for (Entry<String, String> s : kv.toMap().entrySet()) {
            map2.put(s.getKey(), s.getValue());
        }

        for (String s : map2.keySet()) {
            kv.unset(s);
        }

        for (Entry<String, String> s : map2.entrySet()) {
            kv.set(s.getValue(), s.getKey());
        }

    }
}
// END
