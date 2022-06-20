package ProxyPractise.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public static void initXml() {
        XmlReader.readXml("aops.xml");
        ResourceListener.addListener("D:/文档/2022/GitHub项目/AlgorithmRepsotory/ProxyPractise/");
    }

    public static void main(String[] args) throws Exception {
        Main.initXml();

        Person action = new PersonImpl();
        ProxyHandler mh = new ProxyHandler(action);
        ClassLoader cl = Main.class.getClassLoader();
        Class<?> proxyClass = Proxy.getProxyClass(cl, new Class<?>[]{Person.class});
        Person proxy = (Person) proxyClass.
                getConstructor(new Class[]{InvocationHandler.class}).
                newInstance(new Object[]{mh});
        while (true) {
            proxy.eat();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
