package lab.model;

public interface Person<T extends Person> {
    T setName(String name);
    public String getName();
    public void sayHello(Person person);
}