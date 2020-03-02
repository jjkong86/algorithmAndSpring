package test.hiperConnect.secound;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBrackets {
    public static boolean isValid(String brackets) {
        if (brackets.length() == 0)
            return true;

        Map<Character, Character> map = buildMap();

        Stack<Character> s = new Stack<>();
        for (char c: brackets.toCharArray()) {
            if (!s.empty() && s.lastElement() == c) {
                s.pop();
            } else {
                if (map.get(c) == null) {
                    return false;
                }
                s.push(map.get(c));
            }
        }

        return s.size() == 0;
    }

    public static Map<Character, Character> buildMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        return map;
    }

    public static void main(String[] args) {
        System.out.println(ValidBrackets.isValid("{[]"));
        System.out.println(ValidBrackets.isValid("{}[]()"));
        System.out.println(ValidBrackets.isValid("{[]()[]}[]"));
    }
}
