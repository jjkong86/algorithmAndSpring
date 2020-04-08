package etc.generic;

public class GenericTest {

    public static <T extends Children<? extends Number>> Number getNumberValue(T vo) {
        return vo.chidrenValue.longValue();
    }

    public static void main(String[] args) {
        Paren p = new Paren();
        p.chidrenValue = 3L;

        Parent2 p2 = new Parent2();
        p2.chidrenValue = 5;

        System.out.println(getNumberValue(p));
        System.out.println(getNumberValue(p2));
    }
}
