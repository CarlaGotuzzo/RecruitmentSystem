public class FullTimeSH extends StaffHire {

    // Atributos
    private double salary;
    private int weeklyFractionalHours;

    // Constructor
    
    public FullTimeSH(int vacancyNumber, String designation, String jobType, String staffName,
                      String joiningDate, String qualification, String appointedBy,
                      boolean joined, double salary, int weeklyFractionalHours) {


        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // Getter
    
    public double getSalary(){
        return salary;
    }

    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }

    //Setter
    public void setSalary(double newSalary) {
        if (getJoined()) {
            System.out.println("Cannot updated Salary. Staff member has already been hired");
        } else {
            this.salary = newSalary;
            System.out.println("Salary updated.");
        }
    }

    public void setWeeklyFractionalHours(int newHours) {
        if (newHours > 0) {
            this.weeklyFractionalHours = newHours;
        } else {
            System.out.println("Invalid number of hours.");
        }
    }


    public void display() {
        super.display();
        System.out.println("Salary: " + salary);
        System.out.println("Weekly working Hours: " + weeklyFractionalHours);
    }
}

