package ReflectionPractise;

import java.lang.reflect.Field;

public class FieldDemo {

    public static void main(String[] args) throws IllegalAccessException {
        A obj = new A(20, "Tom");
        Class c = obj.getClass();

        //获取本类及父类所有的public字段
        Field[] fs = c.getFields();
        System.out.println(fs[0].getName() + ": " + fs[0].get(obj));

        //获得本类所有声明的字段
        Field[] fs2 = c.getDeclaredFields();
        for (Field f : fs2) {
            //可以将private属性暂时设置为public属性
            f.setAccessible(true);
            System.out.println(f.getName() + ": "+ f.get(obj));
        }
    }

}

class A {
    public int age;
    private String name;

    public A(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
