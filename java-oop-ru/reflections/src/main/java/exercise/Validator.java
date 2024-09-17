package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

//    public Validator(Address address) {
//      for (Field field : address.getClass().getDeclaredFields()) {
//        NotNull notNull = field.getAnnotation(NotNull.class);
//      }
//    }

    public static List<String> validate(Address address) {
        List<String> err = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                NotNull anno = field.getAnnotation(NotNull.class);
                String value;
                try {
                    field.setAccessible(true);
                    value = (String) field.get(address);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if ((value == null) || (value == "")) {
                    err.add(field.getName());
                }
            }
        }
        return err;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        String err1 = "length less than 4";
        String err2 = "can not be null";

        Map<String, List<String>> res = new HashMap<>();
        List<Class> classes = new ArrayList<>(List.of(NotNull.class, MinLength.class));
        //
        for (Field field : address.getClass().getDeclaredFields()) {
            List<String> strings = new ArrayList<>();
            //System.out.println("FIELD="+field.getName());
            for (Class aClass : classes) {
                if (field.isAnnotationPresent(aClass)) {
                    field.setAccessible(true);
                    //System.out.println("CLASS="+aClass.getSimpleName());
                    try {
                        //System.out.println("VALUE="+field.get(address));
                        if ((aClass.getSimpleName().equals("NotNull")) && ((String) field.get(address) == null || (String) field.get(address) == "")
                        ) {
                            strings.add(err1);
                        } else if ((aClass.getSimpleName().equals("MinLength")) && ((String) field.get(address)).length() < 4) {
                            strings.add(err2);
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            } //Class
            if (strings.size()>0) {
                res.put(field.getName(), strings);
            }
        }//Field
        return res;
    }
}
// END
