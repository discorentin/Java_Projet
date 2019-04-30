package Model;

import java.util.ArrayList;

public class Department
{
    private String depName;
    private Employee manager;
    private java.util.ArrayList<Employee> employeeList;
    private int nbEmployees;

    public Department(Department param)
    {
        setDepName(param.depName);
        setManager(param.manager);
        setEmployeeList(employeeList);
        setNbEmployees(employeeList.size());
    }

    public Department(String depName)
    {
        setDepName(depName);
        setManager(manager);
        setEmployeeList(employeeList);
        setNbEmployees(employeeList.size());
    }

    public Department(String depName, Employee manager, ArrayList<Employee> employeeList)
    {
        setDepName(depName);
        setManager(manager);
        setEmployeeList(employeeList);
        setNbEmployees(employeeList.size());
    }

    public String getDepName()
    {
        return depName;
    }

    public void setDepName(String depName)
    {
        this.depName = depName;
    }

    public Employee getManager()
    {
        return manager;
    }

    public void setManager(Employee manager)
    {
        this.manager = manager;
    }

    public ArrayList<Employee> getEmployeeList()
    {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList)
    {
        this.employeeList = employeeList;
    }

    public int getNbEmployees()
    {
        return nbEmployees;
    }

    public void setNbEmployees(int nbEmployees)
    {
        this.nbEmployees = nbEmployees;
    }
}
