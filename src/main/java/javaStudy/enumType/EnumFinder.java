package javaStudy.enumType;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;

public class EnumFinder {

    final static BiFunction<Object, Integer, Boolean> biInteger = (x, y) -> {
        if (x instanceof Integer)
            return ((Integer) x).intValue() == y.intValue();

        return false;
    };

    final static BiFunction<Object, String, Boolean> biString = (x, y) -> {
        if (x instanceof String)
            return x.equals(y);

        return false;
    };

    public static <T extends Enum<T>> T findByStringType(String type, Class<T> enumType) {
        return applyFunction(type, enumType, biString);
    }

    public static <T extends Enum<T>> T findByIntegerType(Integer type, Class<T> enumType) {
        return applyFunction(type, enumType, biInteger);
    }

    // parameter enum의 요소를 list로 만들어서 type으로 찾음
    public static <T extends Enum<T>, E> T applyFunction(E type, Class<T> enumType, BiFunction<Object, E, Boolean> function) {
        return Arrays.stream(enumType.getEnumConstants())
                .filter(elem ->
                        Arrays.stream(elem.getDeclaringClass().getDeclaredFields())
                                .anyMatch(subElem -> {
                                    try {
                                        subElem.setAccessible(true);
                                        return function.apply(subElem.get(elem), type);
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                    return false;
                                }))
                .findFirst().orElseThrow(() -> new RuntimeException("Enum name : " + enumType.getSimpleName() + ", Type : " + type + ", Not found."));
    }

    public static class TestClass {

        @Test
        public void enum_성능테스트() {
            DiceName diceName = DiceName.LITTLEDOLL;
            long time = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                Arrays.stream(DiceName.values()).anyMatch(elem -> elem.getName().equals(diceName.getName()));
            }
            System.out.println("enum values time : " + (System.currentTimeMillis() - time));

            time = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                EnumFinder.findByStringType(diceName.getName(), DiceName.class);
            }
            System.out.println("enum Finder string access time : " + (System.currentTimeMillis() - time));

            time = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                DiceName temp = DiceName.LITTLEDOLL;
                temp.getName();
            }
            System.out.println("direct access time : " + (System.currentTimeMillis() - time));

        }
    }
}
