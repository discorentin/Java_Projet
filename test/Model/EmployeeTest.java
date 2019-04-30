package Model;

import java.time.Duration;

import static org.junit.Assert.*;

public class EmployeeTest
{
    @org.junit.Test
    public void TestConstructor()
    {
        String name = "John";
        String surname = "Doe";
        int employeeId = 0;
        Department department = new Department("department");
        Duration[] arrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(9)};
        Duration[] departureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(19)};
        EmployeeTime employeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), arrivalList, departureList);

        Employee employee = new Employee(name, surname, employeeId, department, employeeTime);

        assertEquals(name, employee.getName());
        assertEquals(surname, employee.getSurname());
        assertEquals(employeeId, employee.getEmployeeId());
        assertEquals(department, employee.getDepartment());
        assertEquals(employeeTime, employee.getEmployeeTime());
        assertTrue(department.getEmployeeList().contains(this));
    }

    @org.junit.Test
    public void TestCopyConstructor()
    {
        String name = "John";
        String surname = "Doe";
        int employeeId = 0;
        Department department = new Department("department");
        Duration[] arrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(9)};
        Duration[] departureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(19)};
        EmployeeTime employeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), arrivalList, departureList);
        Employee param = new Employee(name, surname, employeeId, department, employeeTime);

        Employee employee = new Employee(param);

        assertEquals(name, employee.getName());
        assertEquals(surname, employee.getSurname());
        assertEquals(employeeId, employee.getEmployeeId());
        assertEquals(department, employee.getDepartment());
        assertEquals(employeeTime, employee.getEmployeeTime());
    }
}