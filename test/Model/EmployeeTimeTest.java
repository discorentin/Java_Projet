package Model;

import java.time.Duration;

import static org.junit.Assert.*;

public class EmployeeTimeTest
{
    @org.junit.Test
    public void TestCalculateRatio()
    {
        Duration[] arrivalList;
        Duration[] departureList;
        EmployeeTime employeeTime;

        arrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(9)};
        departureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(19)};
        employeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), arrivalList, departureList);
        assertEquals(Duration.ofHours(0), employeeTime.gethRatio());

        arrivalList = new Duration[]{Duration.ofHours(8), Duration.ofHours(8), Duration.ofHours(9)};
        departureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(19)};
        employeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), arrivalList, departureList);
        assertEquals(Duration.ofHours(-1), employeeTime.gethRatio());

        arrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(8)};
        departureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(19)};
        employeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), arrivalList, departureList);
        assertEquals(Duration.ofHours(1), employeeTime.gethRatio());

        arrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(9)};
        departureList = new Duration[]{Duration.ofHours(18), Duration.ofHours(18), Duration.ofHours(19)};
        employeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), arrivalList, departureList);
        assertEquals(Duration.ofHours(1), employeeTime.gethRatio());

        arrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(9)};
        departureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(18)};
        employeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), arrivalList, departureList);
        assertEquals(Duration.ofHours(-1), employeeTime.gethRatio());
    }
}