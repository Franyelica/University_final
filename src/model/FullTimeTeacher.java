package model;

public class FullTimeTeacher extends Teacher {
    int yearsWorked;

    public FullTimeTeacher(String name, int yearsWorked) {
        super(name);
        this.yearsWorked = yearsWorked;
        calculateSalary();
    }

    public int getYearsWorked() {
        return yearsWorked;
    }

    public void setYearsWorked(int yearsWorked) {
        this.yearsWorked = yearsWorked;
    }

    public void calculateSalary(){
        this.salary = (float) (baseSalary * (1.1+(yearsWorked * 0.01)));
    }
}