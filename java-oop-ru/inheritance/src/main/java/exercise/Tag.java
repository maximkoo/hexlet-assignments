package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    String name;
    Map<String, String> attrs = new HashMap<>();

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, Map<String, String> attrs) {
        this.name = name;
        this.attrs = attrs;
    }

    public String getAttrsText(){
        StringBuilder s = new StringBuilder();
        for (Map.Entry e : attrs.entrySet()) {
            s.append(" ").append(e.getKey()).append("=").append("\"").append(e.getValue()).append("\"");
        }
        return s.toString();
    }

    public String getText() {
        return this.name;
    }

    @Override
    public String toString() {
        if (attrs.isEmpty()) {
            return "<" + getText() + ">";
        } else {
            return "<" + getText() +getAttrsText()+">";
        }
    }
}
// END
