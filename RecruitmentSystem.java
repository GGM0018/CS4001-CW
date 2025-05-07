import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class RecruitmentSystem
{
    private JFrame frame;
    private JTextField vacancyField, designationField, jobTypeField, staffNameField, joiningDateField;
    private JTextField qualificationField, appointedByField, salaryField, weeklyFractionalHoursField, workingHoursField, wagesPerHourField, shiftsField, terminateNumberField, displayNumberField;
    private JCheckBox joinedCheckBox;
    private JButton addFullTimeButton, addPartTimeButton, setSalaryButton, setShiftsButton, terminateNumberButton, displayNumberButton, clearButton;
    private ArrayList<StaffHire> staffList = new ArrayList<>();


    public RecruitmentSystem()
    {
        frame = new JFrame("Recruitment System");
        frame.setLayout(new GridLayout(10,3));

        //input fieds and labels
        frame.add(new JLabel("Vacancy Number:"));
        vacancyField = new JTextField();
        frame.add(vacancyField);

        frame.add(new JLabel("Designation:"));
        designationField = new JTextField();
        frame.add(designationField);

        frame.add(new JLabel("Job Type:"));
        jobTypeField = new JTextField();
        frame.add(jobTypeField);

        frame.add(new JLabel("Staff Name:"));
        staffNameField = new JTextField();
        frame.add(staffNameField);

        frame.add(new JLabel("Joining Date:"));
        joiningDateField = new JTextField();
        frame.add(joiningDateField);

        frame.add(new JLabel("Qualification:"));
        qualificationField = new JTextField();
        frame.add(qualificationField);

        frame.add(new JLabel("Appointed By:"));
        appointedByField = new JTextField();
        frame.add(appointedByField);

        frame.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        frame.add(salaryField);

        frame.add(new JLabel("Weekly Fractional Hours:"));
        weeklyFractionalHoursField = new JTextField();
        frame.add(weeklyFractionalHoursField);

        frame.add(new JLabel("Working Hours:"));
        workingHoursField = new JTextField();
        frame.add(workingHoursField);

        frame.add(new JLabel("Wages:"));
        wagesPerHourField = new JTextField();
        frame.add(wagesPerHourField);

        frame.add(new JLabel("Shifts:"));
        shiftsField = new JTextField();
        frame.add(shiftsField);

        frame.add(new JLabel("Terminate Number:"));
        terminateNumberField = new JTextField();
        frame.add(terminateNumberField);

        frame.add(new JLabel("Display Number:"));
        displayNumberField = new JTextField();
        frame.add(displayNumberField);

        frame.add(new JLabel("Joined:"));
        joinedCheckBox = new JCheckBox();
        frame.add(joinedCheckBox);



        //buttons
        addFullTimeButton = new JButton("Add Full Time Staff");
        frame.add(addFullTimeButton);

        addFullTimeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    int vacancyNumber = Integer.parseInt(vacancyField.getText());
                    String designation = designationField.getText();
                    String jobType = jobTypeField.getText();
                    String staffName = staffNameField.getText();
                    String joiningDate = joiningDateField.getText();
                    String qualification = qualificationField.getText();
                    String appointedBy = appointedByField.getText();
                    boolean joined = joinedCheckBox.isSelected();
                    double salary = Double.parseDouble(salaryField.getText());
                    int weeklyFractionalHours = Integer.parseInt(weeklyFractionalHoursField.getText());

                    FullTimeStaffHire fullTimeStaff = new FullTimeStaffHire(vacancyNumber, designation, jobType, staffName,
                            joiningDate, qualification, appointedBy, joined, salary, weeklyFractionalHours);

                    staffList.add(fullTimeStaff);
                    JOptionPane.showMessageDialog(frame, "Full-time staff added successfully");

                }
                 catch (NumberFormatException error)
                {
                    JOptionPane.showMessageDialog(frame, "ERROR. Please Enter Valid Data.");
                }
            }

        });


        addPartTimeButton = new JButton("Add Part Time Staff");
        frame.add(addPartTimeButton);

        addPartTimeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    int vacancyNumber = Integer.parseInt(vacancyField.getText());
                    String designation = designationField.getText();
                    String jobType = jobTypeField.getText();
                    String staffName = staffNameField.getText();
                    String joiningDate = joiningDateField.getText();
                    String qualification = qualificationField.getText();
                    String appointedBy = appointedByField.getText();
                    boolean joined = joinedCheckBox.isSelected();
                    int workingHours = Integer.parseInt(workingHoursField.getText());
                    double wagesPerHour =Double.parseDouble(wagesPerHourField.getText());
                    String shifts = shiftsField.getText();

                    PartTimeStaffHire partTimeStaff = new PartTimeStaffHire(vacancyNumber, designation, jobType, staffName, joiningDate,
                     qualification, appointedBy, joined, workingHours, wagesPerHour, shifts);

                    staffList.add(partTimeStaff);
                    JOptionPane.showMessageDialog(frame, "Part-time staff added successfully");

                }
                catch (NumberFormatException error)
                {
                    JOptionPane.showMessageDialog(frame,"ERROR. Please Enter Valid Data.");
                }
            }
        });


        setSalaryButton = new JButton("Set Salary");
        frame.add(setSalaryButton);
        setSalaryButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {
                try 
                {
                    int vacancyNumber = Integer.parseInt(vacancyField.getText());
                    String staffName = staffNameField.getText();
                    double newSalary = Double.parseDouble(salaryField.getText());
                    boolean found = false;

                    for (StaffHire staff : staffList)
                    {
                        if (staff instanceof FullTimeStaffHire)
                        
                        {
                            FullTimeStaffHire fullStaff = (FullTimeStaffHire) staff;

                            if (fullStaff.getVacancyNumber() == vacancyNumber && fullStaff.getStaffName().equalsIgnoreCase(staffName))
                            {
                                
                                fullStaff.setSalary(newSalary);
                                JOptionPane.showMessageDialog(frame, "Salary updated successfully");
                                found = true;
                                break;
                            }
                        }
                    }

                    if (found == false)
                    {
                        JOptionPane.showMessageDialog(frame, "No matching staff found.");
                    }

                } catch (NumberFormatException error)
                {
                    JOptionPane.showMessageDialog(frame, "Please enter valid inputs for vacancy number and salary.");
                }
            }
        });





        setShiftsButton = new JButton("Set Shifts");
        frame.add(setShiftsButton);

        setShiftsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event) {
                try 
                {
                    int vacancyNumber = Integer.parseInt(vacancyField.getText());
                    String staffName = staffNameField.getText();
                    String newShifts = shiftsField.getText();
                    boolean found = false;

                    for (StaffHire staff : staffList)
                    {
                        if (staff instanceof PartTimeStaffHire)
                        {
                            PartTimeStaffHire partStaff = (PartTimeStaffHire) staff;

                            if (partStaff.getVacancyNumber() == vacancyNumber && partStaff.getStaffName().equalsIgnoreCase(staffName))
                            {
                                partStaff.setShifts(newShifts);
                                JOptionPane.showMessageDialog(frame, "Shifts updated successfully.");
                                found = true;
                                break;
                            }
                        }
                    }

                    if (found == false)
                    {
                        JOptionPane.showMessageDialog(frame, "No matching staff found.");
                    }

                } catch (NumberFormatException error)
                
                {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid Vacancy Number.");
                }
            }
        });





        terminateNumberButton = new JButton("Terminate");
        frame.add(terminateNumberButton);

        terminateNumberButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    int vacancyNumber = Integer.parseInt(terminateNumberField.getText());
                    boolean found = false;

                    for (StaffHire staff : staffList)
                    {
                        if (staff instanceof PartTimeStaffHire)
                        {
                            PartTimeStaffHire partStaff = (PartTimeStaffHire) staff;

                            if (partStaff.getVacancyNumber() == vacancyNumber)
                            {
                                partStaff.setTerminated(true);
                                JOptionPane.showMessageDialog(frame, "Staff Has Been Terminated.");
                                found = true;
                                break;
                            }
                        }
                    }

                    if (found == false){
                        JOptionPane.showMessageDialog(frame, "No matching staff was found.");
                    }

                }
                catch (NumberFormatException error)
                {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid Vacancy Number.");
                }
            }
        });



        displayNumberButton = new JButton("Display Number");
        frame.add(displayNumberButton);

        displayNumberButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                int index = getDisplayIndex(); 
                if (index != -1)
                {
                    StaffHire staff = staffList.get(index);
                    staff.printDetails(); 
                    JOptionPane.showMessageDialog(frame, "Staff details successfully printed");
                }
            }
        });




        //button to clear everything entered inn a field and to uncheck the box

        clearButton = new JButton("Clear");
        frame.add(clearButton);
        clearButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                //setting empty
                vacancyField.setText("");
                designationField.setText("");
                jobTypeField.setText("");
                staffNameField.setText("");
                joiningDateField.setText("");
                qualificationField.setText("");
                appointedByField.setText("");
                salaryField.setText("");
                weeklyFractionalHoursField.setText("");
                workingHoursField.setText("");
                wagesPerHourField.setText("");
                shiftsField.setText("");
                terminateNumberField.setText("");
                displayNumberField.setText("");
                joinedCheckBox.setSelected(false);

                JOptionPane.showMessageDialog(frame, "Cleared");
            }
        });



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

    }

    private int getDisplayIndex()
    {
        int displayIndex = -1;
        try 
        {
            displayIndex = Integer.parseInt(displayNumberField.getText());
    
            if (displayIndex < 0 || displayIndex >= staffList.size())
            {
                int indexLength = (staffList.size() - 1);
                JOptionPane.showMessageDialog(frame, "Invalid index. Please enter a number between 0 and " + indexLength );
                displayIndex = -1;
            }
    
        } catch (NumberFormatException error)
        {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter an integer.");
        }
    
        return displayIndex;
    }
    


    //main, allows to be run from term
    public static void main(String[] args)
    {
        new RecruitmentSystem();
    }
}