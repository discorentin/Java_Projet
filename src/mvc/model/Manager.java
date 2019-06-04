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

    /* DESTRUCTOR */

    public void destroyManager()
    {
        this.getDepartment().removeEmployee(this);
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
