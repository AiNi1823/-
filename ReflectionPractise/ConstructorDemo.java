package ReflectionPractise;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorDemo {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        D d = new D();
        Class C = d.getClass();

        Constructor[] cons = C.getConstructors();
        for (Constructor con : cons) {
            if (con.getParameterCount() > 0) {
                //有参构造函数
                D obj = (D) con.newInstance(100);
                obj.printNum();
            } else {
                //无参构造函数
                D obj = (D) con.newInstance();
                obj.printNum();
            }
        }
    }
}

class D {
    private int num;

    public D() {
        this.num = 10;
    }

    public D(int num) {
        this.num = num;
    }

    public void printNum() {
        System.out.println(this.num);
    }
}