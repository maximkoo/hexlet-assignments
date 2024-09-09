package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> attrs) {
        super(name);
        this.name = name;
        this.attrs = attrs;
    }
}
// END
