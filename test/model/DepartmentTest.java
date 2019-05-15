package model;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DepartmentTest
{
    @org.junit.Test
    public void TestNameConstructor()
    {
        String depName = "department";

        Department department = new Department(depName);

        assertEquals(depName, department.getDepName());
    }

    @org.junit.Test
    public void TestConstructor()
    {
        String depName = "department";

        Department oldDepartment = new Department("oldDepartment");
        Duration[] billArrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(9)};
        Duration[] billDepartureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(19)};
        EmployeeTime billEmployeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), billArrivalList, billDepartureList);
        Employee manager = new Employee("Bill", "Manager", 0, oldDepartment, billEmployeeTime);

        Duration[] johnArrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(9)};
        Duration[] johnDepartureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(19)};
        EmployeeTime johnEmployeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), johnArrivalList, johnDepartureList);
        Employee employee = new Employee("John", "Doe", 1, oldDepartment, johnEmployeeTime);

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);

        Department department = new Department(depName, manager, employeeList);

        assertEquals(depName, department.getDepName());
        assertEquals(manager, department.getManager());
        assertEquals(employeeList, department.getEmployeeList());
        assertEquals(2, employeeList.size());
        assertEquals(employeeList.get(0), employee);
        assertEquals(employeeList.get(0).getDepartment(), department);
        assertEquals(employeeList.get(1), manager);
        assertEquals(employeeList.get(1).getDepartment(), department);

        employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(manager);

        department = new Department(depName, manager, employeeList);

        assertEquals(2, employeeList.size());
        assertEquals(employeeList.get(0), employee);
        assertEquals(employeeList.get(0).getDepartment(), department);
        assertEquals(employeeList.get(1), manager);
        assertEquals(employeeList.get(1).getDepartment(), department);
    }
}