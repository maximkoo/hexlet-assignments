package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    String name;
    Map<String, String> attrs;

    public SingleTag(String name, Map<String, String> attrs) {
        this.name = name;
        this.attrs = attrs;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(name + ((attrs.isEmpty())?"":" "));
        for (Map.Entry<String, String> e : attrs.entrySet()) {
            s.append(e.getKey()).append("=").append("\"").append(e.getValue()).append("\"");
        }
        return "<" + s + ">";
    }
}
// END
