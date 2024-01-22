public class SalariedEmployee extends StuffMember {
    private double bonus;
    private double salaryEmployee;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(double salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    public SalariedEmployee(int id, String name, String address, double salaryEmployee, double bonus) {
        super(id, name, address);
        this.bonus = bonus;
        this.salaryEmployee = salaryEmployee;
    }

    @Override
    double pay() {
        return bonus +salaryEmployee;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salaryEmployee=" + salaryEmployee +
                "bonus=" + bonus +

                '}';
    }
}
