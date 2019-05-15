package model;

/**
 * @class Manager
 * @extends Employee
 */
public class Manager extends Employee
{
    /**
     * @constructor
     * @param {Employee} param
     */
    public Manager(Employee param)
    {
        super(param);
    }

    public void makeManager(Employee employee)
    {
        Manager manager = new Manager(employee);
        employee = null;
    }
}
