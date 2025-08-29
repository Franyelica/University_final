package model;

public abstract class Person {
    private static int counter = 1;
    private String name;
    private final int id;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = counter++;
    }
//getter y setters


    public static int getCounter() {
        return counter;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public abstract String getDetails();
}
