package model;

/**
 * @class Employee
 */
public class Employee extends Person
{
    /* ATTRIBUTES */

    /**
     * @name Employee#employeeID
     * @type {java.util.UUID}
     * @private
     */
    private java.util.UUID employeeId;

    /**
     * @name Employee#department
     * @type {Department}
     * @private
     */
    private Department department;

    /**
     * @name Employee#employeeTime
     * @type {employeeTime}
     * @private
     */
    private EmployeeTime employeeTime;

    /* CONSTRUCTORS */

    /**
     * @constructor copy
     * @param {employee} param
     */
    public Employee(Employee param)
    {
        super(param.getName(), param.getSurname());
        this.employeeId = param.getEmployeeId();
        setDepartment(param.getDepartment());
        this.employeeTime = param.getEmployeeTime();
    }

    /**
     * @constructor
     * @param {String} name - the employee's name
     * @param {String} surname - the employee's surname
     * @param {boolean} isAtWork - true if the employee is at work | false if the employee is not at work
     * @param {java.time.Duration} mustArriveAt - the time at which the employee is supposed to arrive at work
     * @param {java.time.Duration} mustLeaveAt - the time at which the employee is supposed to leave work
     */
    public Employee(String name, String surname, boolean isAtWork, java.time.Duration mustArriveAt, java.time.Duration mustLeaveAt)
    {
        super(name, surname);
        this.employeeId.randomUUID();
        this.employeeTime = new EmployeeTime(isAtWork, mustArriveAt, mustLeaveAt);
    }

    /* GETTERS */

    /**
     * @function Employee#getEmployeeId
     * @return {java.util.UUID} the employee's ID
     */
    public java.util.UUID getEmployeeId()
    {
        return this.employeeId;
    }

    /**
     * @function Employee#getDepartment
     * @return {Department} the employee's department
     */
    public Department getDepartment()
    {
        return this.department;
    }

    /**
     * @function Employee#getEmployeeTime
     * @return {EmployeeTime} the employee's time data
     */
    public EmployeeTime getEmployeeTime()
    {
        return this.employeeTime;
    }

    /* SETTERS */

    /**
     * @function Employee#setDepartment
     * @param {Department} department - the employee's new department
     */
    public void setDepartment(Department department)
    {
        this.department = department;
    }
}
