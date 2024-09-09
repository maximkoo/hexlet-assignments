package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {
    String body;
    List<Tag> nestedTags;

    public PairedTag(String name, Map<String, String> attrs, String body, List<Tag> nestedTags) {
        super(name, attrs);
        this.body = body;
        this.nestedTags = nestedTags;
    }

    public String getNestedText() {
        List<String> list3 = new ArrayList<>();
        for (Tag n : nestedTags) {
            list3.add(n.toString());
        }
        String s3 = String.join("", list3);
        return s3;
    }

    @Override
    public String toString() {
        String s = "<" + name + getAttrsText() + ">" + getNestedText() + body + "</" + name + ">";
        return s;
    }
}
// END
