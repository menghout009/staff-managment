public class HourlySalaryEmployee extends StuffMember {

    private static int hourWorked;
    private static double rate;

    public static int getHourWorked() {
        return hourWorked;
    }

    public void setHourWorked(int hourWorked) {
        this.hourWorked = hourWorked;
    }

    public static double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    public HourlySalaryEmployee(int id, String name, String address, double rate, int hourWorked) {
        super(id, name, address);
        this.hourWorked = hourWorked;
        this.rate = rate;
    }


    @Override
    double pay() {
        return (rate * hourWorked);
    }

    @Override
    public String toString() {
        return "HourlySalaryEmployee{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                "rate=" + rate +
                '}';
    }

}
