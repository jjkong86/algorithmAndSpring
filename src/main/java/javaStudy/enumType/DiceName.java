package javaStudy.enumType;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum DiceName {
    ACTIONDICE("actiondice"), WHITE("white"), MAGICALCARD("magicalcard"), ROULETTE("roulette"), MAGICALBOX("magicalbox"), TRAP("trap"), FREETRIP("freetrip"),
    START("start"), MILEAGE("mileage"), TELEPORT("teleport"), GACHA("gacha"), LITTLEDOLL("littledoll"), EMPTY("");

    private String name;

    DiceName(String name) {
        this.name = name;
    }

    public static DiceName findByName(String name) {
        String teleport = "teleport";
        if (name.startsWith(teleport))
            name = teleport;

        final String finalName = name;
        return EnumFinder.findByStringType(finalName, DiceName.class);
    }
}
