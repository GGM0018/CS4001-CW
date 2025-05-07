public class FullTimeStaffHire extends StaffHire
{
    private double salary;
    private int weeklyFractionalHours;

    //constuctor
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName, String joiningDate,
    String qualification, String appointedBy, boolean joined, double salary, int weeklyFractionalHours)
    {
        //superclass
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);

        //new aatributes
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double newSalary)
    {
        if (getJoined() == true)
        {
            this.salary = newSalary;
        }
        else
        {
            System.out.println("Staff has not joined yet ");
        }
    }


    public int getWeeklyFractionalHours()
    {
        return weeklyFractionalHours;
    }


    public void setWeeklyFractionalHours(int newWeeklyFractionalHours)
    {
        this.weeklyFractionalHours = newWeeklyFractionalHours;
    }

    //override the method from the superclass to include the new attributes
    @Override
    public void printDetails()
    {
        super.printDetails(); //calling method to display original attributes
        if (salary > 0)
        {
            System.out.println("Salary: " + salary);
        }
        else
        {
            System.out.println("Salary has not been assigned.");
        }

        if (weeklyFractionalHours > 0)
        {
            System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
        }
        else
        {
            System.out.println("Weekly Fractional Hours have not been assigned.");
        }
        }

    }

