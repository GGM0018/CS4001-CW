public class PartTimeStaffHire extends StaffHire
{
    private int workingHours; //new attributes to be added
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    //constructor
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName, String joiningDate,
    String qualification, String appointedBy, boolean joined, int workingHours, double wagesPerHour, String shifts) //dont need terminated as assigning false in body
    {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        //new attributes
        this.workingHours = workingHours;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }


    public int getWorkingHours()
    {
        return workingHours;
    }

    public void setWorkingHours(int newWorkingHours)
    {
        this.workingHours = newWorkingHours;
    }

    public double getWagesPerHour()
    {
        return wagesPerHour;
    }

    public void setWagesPerHour(double newWagesPerHour)
    {
        this.wagesPerHour = newWagesPerHour;
    }

    public String getShifts()
    {
        return shifts;
    }

    public void setShifts(String newShifts)
    {
        if (getJoined() == true)
        {
            this.shifts = newShifts;
        }
        else
        {
            System.out.println("Staff has not joined. Shifts cannot be updated.");
        }
    }

    public boolean getTerminated()
    {
        return terminated;
    }

    public void setTerminated(boolean newTerminated)
    {
        if (newTerminated == true) //if termination is wanted on staffmember
        {
            if(terminated == false) //if staff currently isnt terminated
            {
                this.setStaffName("");
                this.setJoiningDate("");
                this.setQualification("");
                this.setAppointedBy("");
                this.setJoined(false);
                this.terminated = true;
                System.out.println("Staff has successfully been terminated.");
            }
            else //if staff has already been terminated
            {
                System.out.println("Staff has already been terminated.");
            }
        }

        else //if false is entered
        {
            System.out.println("Staff has NOT been terminated.");
        }
    }

    //printing details inc new attributes

    @Override
    public void printDetails()
    {
        super.printDetails(); //old attributes
        
        if (workingHours > 0) //if workingHours has been assigned a value
        {
            System.out.println("Working Hours per day: " + workingHours); //prints new attributes
            System.out.println("Wages per hour: " + wagesPerHour);
            System.out.println("Shifts: " + shifts);
            System.out.println("Terminated: " + terminated);
            double incomePerDay = (workingHours * wagesPerHour); //calc daily pay
            System.out.println("Income per day: " + incomePerDay);
        }
        else
        {
            System.out.println("Working Hours have not been assigned.");
        }
   
   
   
    }


}