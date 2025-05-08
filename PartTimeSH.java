public class PartTimeSH extends StaffHire {

    // Attributes
    private int workingHours;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;
    private boolean appointed;

    // Constructor
    public PartTimeSH(int vacancyNumber, String designation, String jobType, String staffName,
                      String joiningDate, String qualification, String appointedBy, boolean joined,
                      int workingHours, double wagesPerHour, String shifts) {

        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.workingHours = workingHours;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }

    // Getters
    public int getWorkingHours() {
        return workingHours;
    }
    public double getWagesPerHour() {
        return wagesPerHour;
    }
    public String getShifts() {
        return shifts;
    }
    public boolean isTerminated() {
        return terminated;
    }
    public boolean isAppointed(){
        return appointed;
    }


    // Setter
    public void setShifts(String shifts) {
        if (getJoined()) {
            this.shifts = shifts;
        } else {
            System.out.println("Cannot change shift because the employee has not been appointed. Shift Change Error");
        }
    }

// Termination method

    public void terminateStaff() {
        if (getJoined()){
            if (!terminated) {
                setJoined(false);
                terminated =true;
                setStaffName("");
                setJoiningDate("");
                setQualification("");
                setAppointedBy("");

                System.out.println("Staff member has been successfully released.");

            } else {
                System.out.println("This employee is already marked as released.");
            }
        }
    }

    // Display method

    public void display() {
        super.display();
        System.out.println("Working Hours: " + workingHours);
        System.out.println("Wages Per Hour: " + wagesPerHour);
        System.out.println("Shifts: " + shifts);
        System.out.println("Terminated: " + terminated);

        if (!terminated) {
            double dailyIncome = wagesPerHour * workingHours;
            System.out.println("Daily Income: " + dailyIncome);
        }

    }

    public void setAppointed(boolean appointed){
        this.appointed =appointed;
}
}