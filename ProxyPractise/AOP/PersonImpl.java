package ProxyPractise.AOP;

public class PersonImpl implements Person{
    @Override
    public void eat() {
        System.out.println("I am eating.");
    }

    @Override
    public void washHand() {
        System.out.println("I am washing hands.");
    }

    @Override
    public void bath() {
        System.out.println("I am bathing.");
    }
}
