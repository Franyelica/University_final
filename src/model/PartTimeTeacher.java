package model;

public class PartTimeTeacher extends Teacher{
    int hoursWorked;

    public PartTimeTeacher(String name, int hoursWorked) {
        super(name);
        this.hoursWorked = hoursWorked;
        calculateSalary();
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void calculateSalary(){
        this.salary = baseSalary / hoursWorked;
    }
}
