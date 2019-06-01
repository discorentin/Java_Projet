package mvc.model;

/**
 * @class Department
 */
public class Department
{
    /* ATTRIBUTES */

    /**
     * @name Department#depName
     * @type {String}
     * @private
     */
    private String depName;

    /**
     * @name Department#manager
     * @type {Manager}
     * @private
     */
    private Manager manager;

    /**
     * @name Department#employeeList
     * @type {java.util.ArrayList<Employee>}
     * @private
     */
    private java.util.ArrayList<Employee> employeeList;

    /**
     * @name Department#nbEmployees
     * @type {int}
     * @private
     */
    private int nbEmployees;

    /* CONSTRUCTORS */

    /**
     * @param {Department} param
     * @constructor copy
     */
    public Department(Department param)
    {
        setDepName(param.getDepName());
        setManager(param.getManager());
        this.employeeList = param.getEmployeeList();
        this.nbEmployees = param.getNbEmployees();
    }

    /**
     * @param {String} depName
     * @constructor
     */
    public Department(String depName)
    {
        this.employeeList = new java.util.ArrayList<Employee>();
        this.nbEmployees = 0;
        setDepName(depName);
    }

    /**
     * @param {String} depName
     * @param {Manager} manager
     * @constructor
     */
    public Department(String depName, Manager manager)
    {
        this.employeeList = new java.util.ArrayList<Employee>();
        this.nbEmployees = 0;
        setDepName(depName);
        setManager(manager);
    }

    /* GETTERS */

    /**
     * @return {String} the name of the department
     * @function Department#getDepName
     */
    public String getDepName()
    {
        return this.depName;
    }

    /**
     * @return {Manager} the department's manager
     * @function Department#getManager
     */
    public Manager getManager()
    {
        return this.manager;
    }

    /**
     * @return {java.util.ArrayList<Employee>} the department's list of employees
     * @function Department#getEmployeeList
     */
    public java.util.ArrayList<Employee> getEmployeeList()
    {
        return this.employeeList;
    }

    /**
     * @param {int} employeeId
     * @return {Employee} the employee if found | null if not found
     * @function Department#getEmployee
     */
    public Employee getEmployee(java.util.UUID employeeId)
    {
        for (int i = 0; i < this.nbEmployees; i++)
        {
            if (this.employeeList.get(i).getEmployeeId() == employeeId)
            {
                return this.employeeList.get(i);
            }
        }

        return null;
    }

    /**
     * @return {int} the department's number of employees
     * @function Department#getNbEmployees
     */
    public int getNbEmployees()
    {
        return this.nbEmployees;
    }

    /* SETTERS */

    /**
     * @param {String} depName - the new name of the department
     * @function Department#setDepName
     */
    public void setDepName(String depName)
    {
        this.depName = depName;
    }

    /**
     * @param {Manager} manager - the new department's manager
     * @function Department#setManager
     */
    public void setManager(Manager manager)
    {
        this.manager = manager;

        this.addEmployee(this.manager);
    }

    /* METHODS */

    /**
     * @param {Employee} employee - the employee to add
     * @function Department#addEmployee
     * @description Adds an employee to the department.
     */
    public void addEmployee(Employee employee)
    {
        for(int i = 0; i < this.getNbEmployees(); i++)
        {
            if (this.employeeList.get(i).getEmployeeId() == employee.getEmployeeId())
            {
                return;
            }
        }

        employee.setDepartment(this);
        this.employeeList.add(employee);
        this.nbEmployees++;
    }

    /**
     * @param {Employee} employee - the employee to remove
     * @function Department#removeEmployee
     * @description Removes an employee from the department.
     */
    public void removeEmployee(java.util.UUID employeeId)
    {
        try
        {
            if (this.getEmployee(employeeId) == null)
            {
                this.getEmployee(employeeId).setDepartment(null);
                this.employeeList.remove(this.getEmployee(employeeId));
            }
            else
            {
                throw new Exception("error : the employee with ID " + employeeId.toString() + " is not in the department " + this.getDepName());
            }
        }
        catch (Exception exception)
        {
            System.err.println(exception.getMessage());
        }
    }
}
