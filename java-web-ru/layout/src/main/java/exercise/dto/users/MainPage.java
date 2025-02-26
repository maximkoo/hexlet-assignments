package exercise.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class MainPage {
    private Boolean visited;
    private String currentUser;

    public Boolean isVisited() {
        return visited;
    }
}