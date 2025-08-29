package model;

import java.util.Objects;

public class Student extends Person{
    private int age;
    private static int counterStudent = 100;

    public Student(String name, int age) {
        super(name);
        this.age = age;
        generateId();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    protected int generateId() {
        return (++counterStudent);
    }

    public static int getCounterStudent() {
        return counterStudent - 100;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return Objects.equals(id, student.id);
    }

}
