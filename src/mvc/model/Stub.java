package mvc.model;

import launch.CentralApp;

public class Stub
{
    public static void main(String[] args)
    {
        Company company = new Company("Polytech Tours", "Emmanuel", "Neron");

        Employee employee_1 = new Employee("Pauline", "Henri", false, java.time.Duration.ofHours(8), java.time.Duration.ofHours(18));
        Manager manager_1 = new Manager(employee_1);
        employee_1 = null;

        Department department_1 = new Department("Amenagement et Environnement", manager_1);
        company.addDepartment(department_1);

        Employee employee_2 = new Employee("Pauline", "Mourlon", false, java.time.Duration.ofHours(8), java.time.Duration.ofHours(18));
        department_1.addEmployee(employee_2);
        Employee employee_3 = new Employee("Pauline", "Occelli", false, java.time.Duration.ofHours(8), java.time.Duration.ofHours(18));
        department_1.addEmployee(employee_3);

        Employee employee_4 = new Employee("Samuel", "Souville", false, java.time.Duration.ofHours(8), java.time.Duration.ofHours(18));
        Manager manager_2 = new Manager(employee_4);
        employee_4 = null;

        Department department_2 = new Department("Informatique", manager_2);
        company.addDepartment(department_2);

        Employee employee_5 = new Employee("Olivier", "Millochau", false, java.time.Duration.ofHours(8), java.time.Duration.ofHours(18));
        department_2.addEmployee(employee_5);
        Employee employee_6 = new Employee("Mathieu", "Guillot", false, java.time.Duration.ofHours(8), java.time.Duration.ofHours(18));
        department_2.addEmployee(employee_6);

        company.getDepartment("Amenagement et Environnement").getEmployee(manager_1.getEmployeeId())
                .getEmployeeTime().addArrival(java.time.Duration.ofHours(7));
        System.out.println("IN : " + manager_1.getEmployeeTime().getIsAtWork());

        manager_1.getEmployeeTime().addDeparture(java.time.Duration.ofHours(19));
        System.out.println("OUT : " + manager_1.getEmployeeTime().getIsAtWork());

        manager_1.getEmployeeTime().addArrival(java.time.Duration.ofHours(8));
        System.out.println("IN : " + manager_1.getEmployeeTime().getIsAtWork());

        manager_1.getEmployeeTime().addDeparture(java.time.Duration.ofHours(18));
        System.out.println("OUT : " + manager_1.getEmployeeTime().getIsAtWork());

        printData(department_1);
        printData(department_2);
    }

    static void printData(Department department)
    {
        System.out.println("Le departement " + department.getDepName()
                + " a pour manager " + department.getManager().getName() + " " + department.getManager().getSurname() + ".\n");
        System.out.println("Ses employés sont :");

        for(int i = 0; i < department.getNbEmployees(); i++)
        {
            System.out.println("    " + department.getEmployeeList().get(i).getName() + " " + department.getEmployeeList().get(i).getSurname()
                    + " : " + department.getEmployeeList().get(i).getEmployeeTime().getHRatio().toHours() + " heures supplémentaires");
        }

        System.out.println("--------------------------------------------------");
    }
}
