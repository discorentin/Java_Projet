package mvc.model;

import mvc.model.Person;
import mvc.model.Employee;
import mvc.model.Manager;
import mvc.model.Boss;
import mvc.model.EmployeeTime;
import mvc.model.Department;
import mvc.model.Company;

public class ModelCentralApp
{
    Company company;

    public ModelCentralApp()
    {
        company = new Company();
    }

    public Company getCompany()
    {
        return this.company;
    }
}
