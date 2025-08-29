package model;

public  class FullTimeTeacher extends Teacher {
    private int yearsWorked;

    public FullTimeTeacher(String name, int age, int yearsWorked) {
        super(name,age);
        this.yearsWorked = yearsWorked;
        calculateSalary();
    }

    public int getYearsWorked() {
        return yearsWorked;
    }

    public void setYearsWorked(int yearsWorked) {
        this.yearsWorked = yearsWorked;
    }

    public double calculateSalary(){
        return  getBaseSalary() * (1.1+(yearsWorked * 0.01));
    }

    @Override
    public String getDetails(){
        return super.getDetails()+ " | Años de experiencia: " + yearsWorked;
    }
}