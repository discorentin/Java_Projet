package Model;

public class Employee extends Person
{
    private int employeeId;
    private Department department;
    private EmployeeTime employeeTime;

    public Employee()
    {
    }

    public Employee(Employee param)
    {
    }

    public Employee(String name, String Surname, int employeeId, Department department, EmployeeTime employeeTime)
    {
    }

    public int getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }

    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    public EmployeeTime getEmployeeTime()
    {
        return employeeTime;
    }

    public void setEmployeeTime(EmployeeTime employeeTime)
    {
        this.employeeTime = employeeTime;
    }
}
