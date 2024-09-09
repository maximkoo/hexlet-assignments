package exercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, String> attributes1 = new LinkedHashMap<>();
        attributes1.put("class", "m-10");
        attributes1.put("id", "10");
        attributes1.put("lang", "en");

        // List<Tag> children = new ArrayList<>();

        Tag p = new PairedTag("p", attributes1, "Text paragraph", new ArrayList<Tag>());
        String actual1 = p.toString();
        String expected1 = "<p class=\"m-10\" id=\"10\" lang=\"en\">Text paragraph</p>";
        System.out.println(actual1);

        //////////
        Map<String, String> attributes = new LinkedHashMap<>();
        attributes.put("lang", "ru");
        attributes.put("id", "abc");


        List<Tag> children = List.of(
                new SingleTag("br", Map.of("id", "s")),
                new SingleTag("hr", Map.of("class", "a-5"))
        );

        Tag div = new PairedTag("div", attributes, "", children);
        String actual = div.toString();
        String expected = "<div lang=\"ru\" id=\"abc\"><br id=\"s\"><hr class=\"a-5\"></div>";
        //assertThat(actual).isEqualTo(expected);
        System.out.println(actual);
    }
}
