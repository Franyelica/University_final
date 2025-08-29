package model;

public abstract class Person {
    protected int id;
    protected String name;

    public Person(String name) {
        this.name = name;
    }
//getter y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    protected abstract int generateId();
}
