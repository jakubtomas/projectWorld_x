package project2.project;

public class Box<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void add(T value) {
        this.value = value;
    }



}
