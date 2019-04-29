package Model;

public class Manager extends Employee
{

    public Manager(Manager param)
    {
        super(param.getName(), param.getSurname(), param.getEmployeeId(), param.getDepartment(), param.getEmployeeTime());
    }

    public Manager(String name, String surname, int employeeId, Department department, EmployeeTime employeeTime)
    {
        super(name, surname, employeeId, department, employeeTime);
    }
}
