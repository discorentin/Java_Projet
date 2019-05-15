package model;

/**
 * @class Company
 */
public class Company
{
    /* ATTRIBUTES */

    /**
     * @name Company#companyName
     * @type {String}
     * @private
     */
    private String companyName;

    /**
     * @name Company#companyBoss
     * @type {Boss}
     * @private
     */
    private Boss companyBoss;

    /**
     * @name Company#departmentList
     * @type {java.util.ArrayList<Department>}
     * @private
     */
    private java.util.ArrayList<Department> departmentList;

    /**
     * @name Company#nbDepartments
     * @type {int}
     * @private
     */
    private int nbDepartments;

    /* CONSTRUCTOR */

    /**
     * @constructor
     * @param {String} companyName
     * @param {String} bossName
     * @param {String} bossSurname
     */
    public Company(String companyName, String bossName, String bossSurname)
    {
        setCompanyName(companyName);
        setCompanyBoss(bossName, bossSurname);
        this.nbDepartments = 0;
    }

    /* GETTERS */

    /**
     * @function Company#getCompanyName
     * @return {String} the name of the company
     */
    public String getCompanyName()
    {
        return this.companyName;
    }

    /**
     * @function Company#getCompanyBoss
     * @return {Boss} the boss of the company
     */
    public Boss getCompanyBoss()
    {
        return this.companyBoss;
    }

    /**
     * @function Company#getDepartmentList
     * @return {java.util.ArrayList<Department>} the company's list of departments
     */
    public java.util.ArrayList<Department> getDepartmentList()
    {
        return this.departmentList;
    }

    /**
     * @function Company#getDepartment
     * @param {String} depName - the name of the department to return
     * @return {Department} the department if found | null if not found
     */
    public Department getDepartment(String depName)
    {
        for(int i = 0; i < this.nbDepartments; i++)
        {
            if(this.departmentList.get(i).getDepName() == depName)
            {
                return this.departmentList.get(i);
            }
        }

        return null;
    }

    /**
     * @name Company#getNbDepartments
     * @return {int} the company's number of departments
     */
    public int getNbDepartments()
    {
        return this.nbDepartments;
    }

    /* SETTERS */

    /**
     * @function Company#setCompanyName
     * @param {String} companyName - the new name of the company
     */
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    /**
     * @function Company#setCompanyBoss
     * @param {String} bossName - the name of the company's new boss
     * @param {String} bossSurname - the surname of the company's new boss
     */
    public void setCompanyBoss(String bossName, String bossSurname)
    {
        this.companyBoss = new Boss(bossName, bossSurname);
    }

    /* METHODS */

    /**
     * @function Company#addDepartment
     * @description Adds a given department to the company.
     * @param {Department} department - the department to add
     */
    public void addDepartment(Department department)
    {
        this.departmentList.add(department);
        this.nbDepartments++;
    }

    /**
     * @function Company#removeDepartment
     * @description Removes a given department from the company.
     * @param {Department} department - the department to remove
     */
    public void removeDepartment(Department department)
    {
        this.departmentList.remove(department);
        this.nbDepartments--;
    }

    public void makeManager(java.util.UUID employeeId)
    {
        try
        {
            Manager manager;
            boolean done = false;

            for(int i = 0; i < this.getNbDepartments(); i++)
            {
                if(this.departmentList.get(i).getEmployee(employeeId) != null)
                {
                    manager = new Manager(this.departmentList.get(i).getEmployee(employeeId));
                    this.departmentList.get(i).removeEmployee(employeeId);
                    this.departmentList.get(i).addEmployee(manager);

                    done = true;
                }
            }

            if(done == false)
            {
                throw new Exception("error : the company " + this.getCompanyName() + " has no employee with the ID " + employeeId);
            }
        }
        catch(Exception exception)
        {
            System.err.println(exception.getMessage());
        }
    }
}
