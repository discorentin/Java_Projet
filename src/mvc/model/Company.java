package mvc.model;

import java.util.ArrayList;

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

    /* CONSTRUCTORS */

    /**
     * @constructor default
     */
    public Company()
    {
        setCompanyName("");
        setCompanyBoss("", "");
        this.departmentList = new ArrayList<>();
        this.nbDepartments = 0;
    }

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
        this.departmentList = new ArrayList<>();
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

    /**
     * @name Company#getEmployeesList
     * @return {java.util.ArrayList<Employee>} the company's list of employees
     */
    public java.util.ArrayList<Employee> getEmployeesList()
    {
        java.util.ArrayList<Employee> employeesList = new java.util.ArrayList<>();

        for (int i = 0; i < this.nbDepartments; i++)
        {
            for(int j = 0; j < this.departmentList.get(i).getNbEmployees(); j++)
            {
                employeesList.add(this.departmentList.get(i).getEmployeeList().get(j));
            }
        }

        return employeesList;
    }

    /**
     * @name getNbEmployees
     * @return {int} the number of employees of the company
     */
    public int getNbEmployees()
    {
        int nbEmployees = 0;

        for(int i = 0; i < this.getNbDepartments(); i++)
        {
            nbEmployees += this.getDepartmentList().get(i).getNbEmployees();
        }

        return nbEmployees;
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
}
