package liu.yan.other;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(Teacher.str);
    }
}
class Person {
    public static String str = "hello world!";
    static {
        System.out.println("Person static block");
    }
}
class Teacher extends Person {
    static {
        System.out.println("Teacher static block");
    }
}



