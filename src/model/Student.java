package model;

import java.util.Objects;

public class Student extends Person{


    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public String getDetails() {
        return "Student: " + getName() + " | ID: " + getId() +
                " | Age: " + getAge();
    }
}
