package ReflectionPractise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        B obj = new B();
        Class c = obj.getClass();

        //获得public方法包括父类和接口
        Method[] ms = c.getMethods();
        for (Method m : ms) {
            if ("f1".equals(m.getName())) {
                m.invoke(obj, null);
            }
        }

        //获得该类的所有方法
        Method[] ms2 = c.getDeclaredMethods();
        for (Method m : ms2) {
            if ("f2".equals(m.getName())) {
                m.setAccessible(true);
                String result = (String) m.invoke(obj, "abc");
                System.out.println(result);
            }
        }
    }
}

class B {
    public void f1() {
        System.out.println("B.f1()...");
    }

    private String f2(String s) {
        System.out.println("B.f2()...");
        return s;
    }
}
