package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String str;
    private String tag;


    public LabelTag(String str, TagInterface tag) {
        this.str = str;
        this.tag = tag.render();
    }

    @Override
    public String render() {
        return "<label>" + str + tag + "</label>";
    }
}
// END
