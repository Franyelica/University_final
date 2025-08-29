package model;

public abstract class Teacher extends Person {
    protected static float baseSalary = 1423500;
    protected float salary;

    public Teacher(String name) {
        super(name);
    }

    public static float getBaseSalary() {
        return baseSalary;
    }

    public static void setBaseSalary(float baseSalary) {
        Teacher.baseSalary = baseSalary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "salary=" + salary +
                '}';
    }

    public void calculateSalary(){
    }
}
