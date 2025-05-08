import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RecruitmentSystemGUI implements ActionListener {
    // Database component
    private ArrayList<StaffHire> staffList;

    // GUI components for input fields
    private JTextField vacancyNumberField;
    private JTextField designationField;
    private JTextField jobTypeField;
    private JTextField staffNameField;
    private JTextField joiningDateField;
    private JTextField qualificationField;
    private JTextField appointedByField;
    private JCheckBox joinedCheckBox;
    private JTextField salaryField;
    private JTextField weeklyFractionalHoursField;
    private JTextField workingHoursField;
    private JTextField wagesPerHourField;
    private JTextField shiftsField;
    private JTextField displayNumberField;
    private JTextField terminateNumberField;

    // GUI components for buttons
    private JButton addFullTimeStaffButton;
    private JButton addPartTimeStaffButton;
    private JButton setSalaryButton;
    private JButton setShiftsButton;
    private JButton terminateButton;
    private JButton displayButton;
    private JButton clearButton;

    private int displayNumber = -1;


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addFullTimeStaffButton) {
            addFullTimeStaff();
        } else if (e.getSource() == addPartTimeStaffButton) {
            addPartTimeStaff();
        } else if (e.getSource() == setSalaryButton) {
            setSalary();
        } else if (e.getSource() == setShiftsButton) {
            setWorkingShifts();
        } else if (e.getSource() == terminateButton) {
            terminatePartTimeStaff();
        } else if (e.getSource() == displayButton) {
            displayStaffInfo();
        } else if (e.getSource() == clearButton) {
            clearFields();
        }
    }

    public RecruitmentSystemGUI() {
        // Initialize staffList
        staffList = new ArrayList<StaffHire>();
        makeFrame();
    }


    private void makeFrame() {
        // Initialize GUI interface
        JFrame frame = new JFrame("Recruitment System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);

        // Using GridBagLayout for more flexibility
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Creating left column labels
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Vacancy Number:"), gbc);

        gbc.gridy = 1;
        mainPanel.add(new JLabel("Job Type:"), gbc);

        gbc.gridy = 2;
        mainPanel.add(new JLabel("Staff Name:"), gbc);

        gbc.gridy = 3;
        mainPanel.add(new JLabel("Qualification:"), gbc);

        gbc.gridy = 4;
        mainPanel.add(new JLabel("Weekly Fractional Hours:"), gbc);

        gbc.gridy = 5;
        mainPanel.add(new JLabel("Wages Per Hour:"), gbc);

        gbc.gridy = 6;
        mainPanel.add(new JLabel("Display Number:"), gbc);

        gbc.gridy = 7;
        mainPanel.add(new JLabel("Terminate Number:"), gbc);

        // Creating left column fields
        gbc.gridx = 1;
        gbc.gridy = 0;
        vacancyNumberField = new JTextField(15);
        mainPanel.add(vacancyNumberField, gbc);

        gbc.gridy = 1;
        jobTypeField = new JTextField(15);
        mainPanel.add(jobTypeField, gbc);

        gbc.gridy = 2;
        staffNameField = new JTextField(15);
        mainPanel.add(staffNameField, gbc);

        gbc.gridy = 3;
        qualificationField = new JTextField(15);
        mainPanel.add(qualificationField, gbc);

        gbc.gridy = 4;
        weeklyFractionalHoursField = new JTextField(15);
        mainPanel.add(weeklyFractionalHoursField, gbc);

        gbc.gridy = 5;
        wagesPerHourField = new JTextField(15);
        mainPanel.add(wagesPerHourField, gbc);

        gbc.gridy = 6;
        displayNumberField = new JTextField(15);
        mainPanel.add(displayNumberField, gbc);

        gbc.gridy = 7;
        terminateNumberField = new JTextField(15);
        mainPanel.add(terminateNumberField, gbc);

        // Creating right column labels
        gbc.gridx = 2;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Designation:"), gbc);

        gbc.gridy = 1;
        mainPanel.add(new JLabel("Joining Date:"), gbc);

        gbc.gridy = 2;
        mainPanel.add(new JLabel("Appointed By:"), gbc);

        gbc.gridy = 3;
        mainPanel.add(new JLabel("Salary:"), gbc);

        gbc.gridy = 4;
        mainPanel.add(new JLabel("Working Hours:"), gbc);

        gbc.gridy = 5;
        mainPanel.add(new JLabel("Shifts:"), gbc);

        // Creating right column fields
        gbc.gridx = 3;
        gbc.gridy = 0;
        designationField = new JTextField(15);
        mainPanel.add(designationField, gbc);

        gbc.gridy = 1;
        joiningDateField = new JTextField(15);
        mainPanel.add(joiningDateField, gbc);

        gbc.gridy = 2;
        appointedByField = new JTextField(15);
        mainPanel.add(appointedByField, gbc);

        gbc.gridy = 3;
        salaryField = new JTextField(15);
        mainPanel.add(salaryField, gbc);

        gbc.gridy = 4;
        workingHoursField = new JTextField(15);
        mainPanel.add(workingHoursField, gbc);

        gbc.gridy = 5;
        shiftsField = new JTextField(15);
        mainPanel.add(shiftsField, gbc);

        // Add Joined checkbox
        gbc.gridx = 3;
        gbc.gridy = 6;
        joinedCheckBox = new JCheckBox("Joined");
        mainPanel.add(joinedCheckBox, gbc);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 10, 10));

        addFullTimeStaffButton = new JButton("Add Full Time Staff");
        addFullTimeStaffButton.addActionListener(this);
        buttonPanel.add(addFullTimeStaffButton);

        addPartTimeStaffButton = new JButton("Add Part Time Staff");
        addPartTimeStaffButton.addActionListener(this);
        buttonPanel.add(addPartTimeStaffButton);

        setSalaryButton = new JButton("Set Salary");
        setSalaryButton.addActionListener(this);
        buttonPanel.add(setSalaryButton);

        setShiftsButton = new JButton("Set Working Shifts");
        setShiftsButton.addActionListener(this);
        buttonPanel.add(setShiftsButton);

        terminateButton = new JButton("Terminate");
        terminateButton.addActionListener(this);
        buttonPanel.add(terminateButton);

        displayButton = new JButton("Display Number");
        displayButton.addActionListener(this);
        buttonPanel.add(displayButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        // Add button panel to main panel
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(buttonPanel, gbc);
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
    private void addFullTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String designation = designationField.getText();
            String jobType = jobTypeField.getText();
            String staffName = staffNameField.getText();
            String joiningDate = joiningDateField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = joinedCheckBox.isSelected();
            double salary = Double.parseDouble(salaryField.getText());
            int weeklyFractionalHours = Integer.parseInt(weeklyFractionalHoursField.getText());

            // Validate input fields
            if (designation.isEmpty() || jobType.isEmpty() || staffName.isEmpty() ||
                    joiningDate.isEmpty() || qualification.isEmpty() || appointedBy.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create and add the full-time staff
            FullTimeSH fullTimeStaff = new FullTimeSH(vacancyNumber, designation, jobType, staffName,
                    joiningDate, qualification, appointedBy, joined,
                    salary, weeklyFractionalHours);
            staffList.add(fullTimeStaff);

            JOptionPane.showMessageDialog(null, "Full-time staff added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric values for Vacancy Number, Salary, and Weekly Fractional Hours",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addPartTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String designation = designationField.getText();
            String jobType = jobTypeField.getText();
            String staffName = staffNameField.getText();
            String joiningDate = joiningDateField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = joinedCheckBox.isSelected();
            int workingHours = Integer.parseInt(workingHoursField.getText());
            double wagesPerHour = Double.parseDouble(wagesPerHourField.getText());
            String shifts = shiftsField.getText();

            // Validate input fields
            if (designation.isEmpty() || jobType.isEmpty() || staffName.isEmpty() ||
                    joiningDate.isEmpty() || qualification.isEmpty() || appointedBy.isEmpty() || shifts.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create and add the part-time staff
            PartTimeSH partTimeStaff = new PartTimeSH(vacancyNumber, designation, jobType, staffName,
                    joiningDate, qualification, appointedBy, joined,
                    workingHours, wagesPerHour, shifts);
            staffList.add(partTimeStaff);

            JOptionPane.showMessageDialog(null, "Part-time staff added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric values for Vacancy Number, Working Hours, and Wages Per Hour",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setSalary() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String staffName = staffNameField.getText();
            double newSalary = Double.parseDouble(salaryField.getText());

            boolean found = false;

            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNumber && staff.getStaffName().equals(staffName)) {
                    if (staff instanceof FullTimeSH) {
                        FullTimeSH fullTimeStaff = (FullTimeSH) staff;
                        fullTimeStaff.setSalary(newSalary);
                        found = true;
                        JOptionPane.showMessageDialog(null, "Salary updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "This staff member is not a full-time employee",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "No staff found with the given vacancy number and name",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric values for Vacancy Number and Salary",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setWorkingShifts() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String staffName = staffNameField.getText();
            String newShifts = shiftsField.getText();

            if (newShifts.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter new shifts", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean found = false;

            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNumber && staff.getStaffName().equals(staffName)) {
                    if (staff instanceof PartTimeSH) {
                        PartTimeSH partTimeStaff = (PartTimeSH) staff;
                        partTimeStaff.setShifts(newShifts);
                        found = true;
                        JOptionPane.showMessageDialog(null, "Shifts updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "This staff member is not a part-time employee",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "No staff found with the given vacancy number and name",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid vacancy number",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void terminatePartTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(terminateNumberField.getText());

            boolean found = false;

            for (int i = 0; i < staffList.size(); i++) {
                StaffHire staff = staffList.get(i);
                if (staff.getVacancyNumber() == vacancyNumber) {
                    if (staff instanceof PartTimeSH) {
                        PartTimeSH partTimeStaff = (PartTimeSH) staff;
                        partTimeStaff.terminateStaff();
                        found = true;
                        JOptionPane.showMessageDialog(null, "Part-time staff terminated successfully!",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "This staff member is not a part-time employee",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "No staff found with the given vacancy number",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid vacancy number",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayStaffInfo() {
        try {
            int index = Integer.parseInt(displayNumberField.getText());

            if (index >= 0 && index < staffList.size()) {
                displayNumber = index;
                StaffHire staff = staffList.get(displayNumber);

                StringBuilder info = new StringBuilder();
                info.append("Staff Information:\n\n");
                info.append("Vacancy Number: ").append(staff.getVacancyNumber()).append("\n");
                info.append("Designation: ").append(staff.getDesignation()).append("\n");
                info.append("Job Type: ").append(staff.getJobType()).append("\n");
                info.append("Staff Name: ").append(staff.getStaffName()).append("\n");
                info.append("Joining Date: ").append(staff.getJoiningDate()).append("\n");
                info.append("Qualification: ").append(staff.getQualification()).append("\n");
                info.append("Appointed By: ").append(staff.getAppointedBy()).append("\n");
                info.append("Joined: ").append(staff.getJoined()).append("\n");

                if (staff instanceof FullTimeSH) {
                    FullTimeSH fullTimeStaff = (FullTimeSH) staff;
                    info.append("Staff Type: Full-Time\n");
                    info.append("Salary: ").append(fullTimeStaff.getSalary()).append("\n");
                    info.append("Weekly Fractional Hours: ").append(fullTimeStaff.getWeeklyFractionalHours()).append("\n");
                } else if (staff instanceof PartTimeSH) {
                    PartTimeSH partTimeStaff = (PartTimeSH) staff;
                    info.append("Staff Type: Part-Time\n");
                    info.append("Working Hours: ").append(partTimeStaff.getWorkingHours()).append("\n");
                    info.append("Wages Per Hour: ").append(partTimeStaff.getWagesPerHour()).append("\n");
                    info.append("Shifts: ").append(partTimeStaff.getShifts()).append("\n");
                    info.append("Terminated: ").append(partTimeStaff.isTerminated()).append("\n");
                    if (!partTimeStaff.isTerminated()) {
                        double dailyIncome = partTimeStaff.getWagesPerHour() * partTimeStaff.getWorkingHours();
                        info.append("Daily Income: ").append(dailyIncome).append("\n");
                    }
                }

                JOptionPane.showMessageDialog(null, info.toString(), "Staff Information", JOptionPane.INFORMATION_MESSAGE);

            } else {
                displayNumber = -1;
                JOptionPane.showMessageDialog(null, "Invalid display number. Please enter a number between 0 and " + (staffList.size() - 1),
                        "Display Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            displayNumber = -1;
            JOptionPane.showMessageDialog(null, "Please enter a valid display number",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        vacancyNumberField.setText("");
        designationField.setText("");
        jobTypeField.setText("");
        staffNameField.setText("");
        joiningDateField.setText("");
        qualificationField.setText("");
        appointedByField.setText("");
        joinedCheckBox.setSelected(false);
        salaryField.setText("");
        weeklyFractionalHoursField.setText("");
        workingHoursField.setText("");
        wagesPerHourField.setText("");
        shiftsField.setText("");
        displayNumberField.setText("");
        terminateNumberField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RecruitmentSystemGUI();
            }
        });
    }
}
