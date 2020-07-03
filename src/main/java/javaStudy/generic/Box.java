package javaStudy.generic;

public class Box<T> {
    protected T ob;

    public void set(T o) {
        ob = o;
    }

    public T get() {
        return ob;
    }


    public static void main(String[] args) {

    }
}

class Toy {
}

class Car extends Toy {

}

class Robot extends Toy {

}

class BoxHandler<T> {
    public void outBox(Box<? extends T> box, T t) {
        T temp = box.get(); // 꺼내는 것 OK
//        box.set(t); // 넣는 거 안됨. 컴파일 오류, 하한 제한 때문
    }

    public void inBox(Box<? super T> box, T t) {
//        T temp = box.get(); // 에러 발생, 상한 제한 때문
        box.set(t); // 넣는 것 OKT temp = box.get(); // 에러 발생
//        System.out.println(t);
    }
}
