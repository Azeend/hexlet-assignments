package exercise;

import java.lang.reflect.Field;
import java.util.*;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> list = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    list.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null ) {
                    list.add("can not be null");
                    map.put(field.getName(), list);
                }
                if (field.get(address) != field.getAnnotation(MinLength.class) && field.isAnnotationPresent(MinLength.class)) {
                    list.add("length less than " + );
                    map.put(field.getName(), list);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException();
            }
        }
        return map;
    }
}
// END