package exercise.dto.posts;

import java.util.List;
import java.util.Map;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditPostPage {
    private long id;
    private String name;
    private String body;
    private Map<String, List<ValidationError<Object>>> errors;

    public EditPostPage(Long id, String name, String body){
        this.id = id;
        this.name = name;
        this.body=body;
    }
}


// BEGIN
// END
