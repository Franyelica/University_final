package model;

public class PartTimeTeacher extends Teacher{
    private int hoursWorked;

    public PartTimeTeacher(String name, int age, int hoursWorked) {
        super(name, age);
        this.hoursWorked = hoursWorked;
        calculateSalary();
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary(){

        return getBaseSalary() / hoursWorked;
    }

    @Override
    public String getDetails(){
        return super.getDetails() + " | Hours worked: " + hoursWorked;
    }
}
