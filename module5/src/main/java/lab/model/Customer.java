package lab.model;

public class Customer implements Person {
    private String name;
    private boolean broke;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public Person setName(String name) {
        return null;
    }

    public String getName() {
        return name;
    }

    public boolean isBroke() {
        return broke;
    }

    public void setBroke(boolean broke) {
        this.broke = broke;
    }



    public void sayHello(Person person) {
    }
}
