import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static int option;
    static int id = 0;


    static Scanner sc = new Scanner(System.in);

    static List<StuffMember> stuffMemberList = new ArrayList<>();

    public static void main(String[] args) {

        do {
            menuDisplay();
            option = sc.nextInt();
            switch (option) {
                case 1 -> insertEmployees();

                case 2 -> displayStuffTable();

                case 3 -> UpdateStuff();

                case 4 -> remove();
            }
        } while (option != 5);
    }

    //DisplayMenuMethod
    public static void menuDisplay() {
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table = new Table(3, BorderStyle.UNICODE_BOX,ShownBorders.ALL);
        table.addCell("Stuff Information",cellStyle);
        table.addCell("1).Insert  Employee Information",cellStyle);
        table.addCell("2).Display Employee Information",cellStyle);
        table.addCell("3).Update  Employee Information",cellStyle);
        table.addCell("4).Remove  Employee Information",cellStyle);
        table.addCell("5).Exit ");
        System.out.println(table.render());
        System.out.print("\n=>Choose your option (1-5) :");
    }

    //InsertSalaryEmployeeOption
    public static void insertEmployees() {

        System.out.println("==========Insert Employees==========");
        System.out.println("1).Insert Volunteer");
        System.out.println("3).Salaried Employees");
        System.out.println("2).Insert HourlySalary");
        System.out.println("4).back");
        System.out.print("Choose option (1-4) :");
        option = sc.nextInt();
        switch (option) {
            case 1 -> insertVolunteer();
            case 2 -> insertSalariedEmployee();
            case 3 -> insertHourlySalaryEmployees();
        }
    }

    //InsertVolunteer
    public static void insertVolunteer() {
        System.out.println("insert-Volunteer");
        String name;
        String address;
        double salary;
        id += 1;
        System.out.println("Id :" + id);
        sc.nextLine();
        System.out.print("Name :");
        name = sc.nextLine();
        System.out.print("Address :");
        address = sc.nextLine();
        System.out.print("Input salary :");
        salary = sc.nextDouble();
        stuffMemberList.add(new Volunteer(id, name, address, salary));

    }

    //InsertSalariedEmployee
    public static void insertSalariedEmployee() {
        System.out.println("Insert-Salaried-Employee");
        id += 1;
        String name;
        String address;
        double salary;
        double bonus;
        System.out.println("Id :" + id);
        sc.nextLine();
        System.out.print("Name :");
        name = sc.nextLine();
        System.out.print("Address :");
        address = sc.nextLine();
        System.out.print("Input salary :");
        salary = sc.nextDouble();
        System.out.print("Bonus :");
        bonus = sc.nextDouble();
        stuffMemberList.add(new SalariedEmployee(id, name, address, salary, bonus));

    }

    //InsertHourlySalaryEmployees
    public static void insertHourlySalaryEmployees() {
        System.out.println("Insert Hourly-Salary-Employees");
        id += 1;
        String name;
        String address;
        int hourWorked;
        double rate;
        System.out.println("Id : " + id);
        sc.nextLine();
        System.out.print("Name :");
        name = sc.nextLine();
        System.out.print("Address :");
        address = sc.nextLine();
        System.out.print("Rate :");
        rate = sc.nextDouble();
        System.out.print("Hour-Work :");
        hourWorked = sc.nextInt();
        stuffMemberList.add(new HourlySalaryEmployee(id, name, address, rate, hourWorked));

    }
    //DisplayStuff
    public static void displayStuffTable() {
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table = new Table(9, BorderStyle.UNICODE_BOX,ShownBorders.ALL);
        table.addCell("Type",cellStyle);
        table.addCell("ID",cellStyle);
        table.addCell("Name",cellStyle);
        table.addCell("Address",cellStyle);
        table.addCell("Salary",cellStyle);
        table.addCell("Bonus",cellStyle);
        table.addCell("Hour",cellStyle);
        table.addCell("Rate",cellStyle);
        table.addCell("Pay",cellStyle);
        for (StuffMember stuffData : stuffMemberList) {
            if (stuffData instanceof Volunteer) {
                Volunteer volunteerStuff = (Volunteer) stuffData;
                table.addCell(volunteerStuff.getClass().getSimpleName(), cellStyle);
                table.addCell(String.valueOf(volunteerStuff.id), cellStyle);
                table.addCell(volunteerStuff.name, cellStyle);
                table.addCell(volunteerStuff.address, cellStyle);
                table.addCell("$" + (volunteerStuff.getVolunteerSalary()), cellStyle);
                table.addCell("---");
                table.addCell("---");
                table.addCell("---");
                table.addCell("$" + (volunteerStuff.pay()));
            } else if (stuffData instanceof SalariedEmployee) {
                SalariedEmployee salariedEmployee = (SalariedEmployee) stuffData;
                table.addCell(salariedEmployee.getClass().getSimpleName(), cellStyle);
                table.addCell(String.valueOf(salariedEmployee.id), cellStyle);
                table.addCell(salariedEmployee.name, cellStyle);
                table.addCell(salariedEmployee.address, cellStyle);
                table.addCell("$" + (salariedEmployee.getSalaryEmployee()), cellStyle);
                table.addCell("$" + (salariedEmployee.getBonus()), cellStyle);
                table.addCell("---");
                table.addCell("---");
                table.addCell("$" + (salariedEmployee.pay()));
            } else if (stuffData instanceof HourlySalaryEmployee) {
                HourlySalaryEmployee hourlySalaryEmployee = (HourlySalaryEmployee) stuffData;
                table.addCell(hourlySalaryEmployee.getClass().getSimpleName(), cellStyle);
                table.addCell(String.valueOf(hourlySalaryEmployee.id), cellStyle);
                table.addCell(hourlySalaryEmployee.name, cellStyle);
                table.addCell(hourlySalaryEmployee.address, cellStyle);
                table.addCell("---", cellStyle);
                table.addCell("---");
                table.addCell("" + (HourlySalaryEmployee.getHourWorked()), cellStyle);
                table.addCell("$" + HourlySalaryEmployee.getRate(), cellStyle);
                table.addCell("$" + (hourlySalaryEmployee.pay()), cellStyle);
            }
            id++;
        }
        System.out.println(table.render());
    }

    //Update stuff Data
    public static void UpdateStuff() {
        System.out.print("Enter id to update :");
        int updatedId = sc.nextInt();
        String name;
        String address;
        Double salary;
        int hourWork;
        int rate;
        double bonus;
        for (int i = 0; i < stuffMemberList.size(); i++) {
            if (stuffMemberList.get(i).getId() == updatedId)
                if (stuffMemberList.get(i) instanceof Volunteer) {
                    System.out.print("Name : ");
                    name = sc.next();
                    System.out.print("Address : ");
                    address = sc.next();
                    System.out.print("Salary :");
                    salary = sc.nextDouble();
                    Volunteer volunteer = new Volunteer(updatedId, name, address, salary);
                    stuffMemberList.set(i, volunteer);
                } else if (stuffMemberList.get(i).getId() == updatedId)
                    if (stuffMemberList.get(i) instanceof SalariedEmployee) {
                        System.out.print("Name : ");
                        name = sc.next();
                        System.out.print("Address : ");
                        address = sc.next();
                        System.out.print("Salary :");
                        salary = sc.nextDouble();
                        System.out.print("Bonus :");
                        bonus = sc.nextDouble();
                        SalariedEmployee salariedEmployee = new SalariedEmployee(updatedId, name, address, salary, bonus);
                        stuffMemberList.set(i, salariedEmployee);
                    } else if (stuffMemberList.get(i).getId() == updatedId) {
                        if (stuffMemberList.get(i) instanceof HourlySalaryEmployee) {
                            System.out.print("Name : ");
                            name = sc.next();
                            System.out.print("Address : ");
                            address = sc.next();
                            System.out.print("Hour=Work");
                            hourWork = sc.nextInt();
                            System.out.print("Rate : ");
                            rate = sc.nextInt();
                            HourlySalaryEmployee hourlySalaryEmployee = new HourlySalaryEmployee(updatedId, name, address, hourWork, rate);
                            stuffMemberList.set(i, hourlySalaryEmployee);
                        }
                    }
                }
            }
    // remove stuff data
    public static void remove() {
        id = 0;
        System.out.print("Enter ID to remove: ");
        id = sc.nextInt();
        for (int i = 0; i < stuffMemberList.size(); i++) {
            if (stuffMemberList.get(i).getId() == id) {
                stuffMemberList.remove(stuffMemberList.get(i));

                break;
            }
        }
        System.out.println("Remove Successfully");
    }
}