package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{
    String tag;
    Map<String, String> attrs;
    String body;
    List<Tag> nestedTags;

    public PairedTag(String tag, Map<String, String> attrs, String body, List<Tag> nestedTags) {
        this.tag = tag;         
        this.attrs = attrs;
        this.body = body;
        this.nestedTags = nestedTags;
    }

    @Override
    public String toString() {
        return "PairedTag{" +
                "tag='" + tag + '\'' +
                ", attrs=" + attrs +
                ", body='" + body + '\'' +
                ", nestedTags=" + nestedTags +
                '}';
    }
}
// END
