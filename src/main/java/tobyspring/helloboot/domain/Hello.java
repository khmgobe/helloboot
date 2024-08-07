package tobyspring.helloboot.domain;

public class Hello {

    private final String name;
    private int count;

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public Hello(String name, int count) {
        this.name = name;
        this.count = count;
    }
}
