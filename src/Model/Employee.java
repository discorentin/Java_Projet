package Model;

public class Employee extends Person
{
    private int employeeId;
    private Department department;
    private EmployeeTime employeeTime;

    public Employee(Employee param)
    {
        super(param.getName(), param.getSurname());
        setEmployeeId(param.employeeId);
        setDepartment(param.department);
        setEmployeeTime(param.employeeTime);
    }

    public Employee(String name, String surname, int employeeId, Department department, EmployeeTime employeeTime)
    {
        super(name, surname);
        setEmployeeId(employeeId);
        setDepartment(department);
        setEmployeeTime(employeeTime);
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
