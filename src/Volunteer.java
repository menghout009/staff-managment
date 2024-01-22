public class Volunteer extends StuffMember {

     private static double volunteerSalary;

    public double getVolunteerSalary() {
        return volunteerSalary;
    }

    public void setVolunteerSalary(double volunteerSalary) {
        this.volunteerSalary = volunteerSalary;
    }

    public Volunteer(int id, String name, String address, double volunteerSalary) {
        super(id, name, address);
        this.volunteerSalary = volunteerSalary;
    }


    @Override
     double pay() {
        return volunteerSalary;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                "volunteerSalary=" + volunteerSalary +
                '}';
    }
}
