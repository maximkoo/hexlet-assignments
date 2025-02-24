package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import java.util.Collections;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UsersPage {
    private List<User> Users = Collections.emptyList();
    private String header;
}
// END
