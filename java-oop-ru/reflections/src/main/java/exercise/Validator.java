package exercise;

import java.lang.reflect.Field;

// BEGIN
public class Validator {

    public Validator(Address address) {
      for (Field field : address.getClass().getDeclaredFields()) {
        NotNull notNull = field.getAnnotation(NotNull.class  );
      }
    }
}
// END
