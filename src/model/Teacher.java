package model;

public abstract class Teacher extends Person {
    private double baseSalary = 1423500;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

//    @Override
//    public String getDetails(){
//        return "Teacher: " + getName() +
//                " | ID: " + getId() +
//                " | Salary: " + calculateSalary();
//    }

    @Override
    public String getDetails() {
        return "Teacher: " + getName() + " | ID: " + getId() +
                " | Salary: " + calculateSalary();
    }
}
