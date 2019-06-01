package mvc.model;

/**
 * @class Manager
 * @extends Employee
 */
public class Manager extends Employee
{
    /* CONSTRUCTORS */

    /**
     * @constructor
     * @param {Employee} param
     */
    public Manager(Employee param)
    {
        super(param);
    }

    /**
     * @constructor
     * @param {Employee} employee : the employee to promote
     */
    public void makeManager(Employee employee)
    {
        Manager manager = new Manager(employee);
        employee = null;
    }

    /* METHOD */

    /**
     * @function Manager#isManager
     * @return {boolean} true
     */
    @Override
    public boolean isManager()
    {
        return true;
    }
}
