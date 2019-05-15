package model;

import java.time.Duration;

import static org.junit.Assert.*;

public class EmployeeTimeTest
{
    @org.junit.Test
    public void TestConstructor()
    {
        boolean isAtWork = false;
        Duration mustArriveAt = Duration.ofHours(8);
        Duration mustLeaveAt = Duration.ofHours(18);
        Duration[] arrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(9)};
        Duration[] departureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(19)};

        EmployeeTime employeeTime = new EmployeeTime(isAtWork, mustArriveAt, mustLeaveAt, arrivalList, departureList);

        assertEquals(isAtWork, employeeTime.getIsAtWork());
        assertEquals(mustArriveAt, employeeTime.getMustArriveAt());
        assertEquals(mustLeaveAt, employeeTime.getMustLeaveAt());
        assertEquals(arrivalList, employeeTime.getArrivalList());
        assertEquals(departureList, employeeTime.getDepartureList());
    }

    @org.junit.Test
    public void TestCopyConstructor()
    {
        boolean isAtWork = false;
        Duration mustArriveAt = Duration.ofHours(8);
        Duration mustLeaveAt = Duration.ofHours(18);
        Duration[] arrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(9)};
        Duration[] departureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(19)};
        EmployeeTime param = new EmployeeTime(isAtWork, mustArriveAt, mustLeaveAt, arrivalList, departureList);

        EmployeeTime employeeTime = new EmployeeTime(param);

        assertEquals(isAtWork, employeeTime.getIsAtWork());
        assertEquals(mustArriveAt, employeeTime.getMustArriveAt());
        assertEquals(mustLeaveAt, employeeTime.getMustLeaveAt());
        assertEquals(arrivalList, employeeTime.getArrivalList());
        assertEquals(departureList, employeeTime.getDepartureList());
    }

    @org.junit.Test
    public void TestCalculateRatio()
    {
        Duration[] arrivalList;
        Duration[] departureList;
        EmployeeTime employeeTime;

        arrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(9)};
        departureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(19)};
        employeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), arrivalList, departureList);
        assertEquals(Duration.ofHours(0), employeeTime.getHRatio());

        arrivalList = new Duration[]{Duration.ofHours(8), Duration.ofHours(8), Duration.ofHours(9)};
        departureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(19)};
        employeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), arrivalList, departureList);
        assertEquals(Duration.ofHours(-1), employeeTime.getHRatio());

        arrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(8)};
        departureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(19)};
        employeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), arrivalList, departureList);
        assertEquals(Duration.ofHours(1), employeeTime.getHRatio());

        arrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(9)};
        departureList = new Duration[]{Duration.ofHours(18), Duration.ofHours(18), Duration.ofHours(19)};
        employeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), arrivalList, departureList);
        assertEquals(Duration.ofHours(1), employeeTime.getHRatio());

        arrivalList = new Duration[]{Duration.ofHours(7), Duration.ofHours(8), Duration.ofHours(9)};
        departureList = new Duration[]{Duration.ofHours(17), Duration.ofHours(18), Duration.ofHours(18)};
        employeeTime = new EmployeeTime(false, Duration.ofHours(8), Duration.ofHours(18), arrivalList, departureList);
        assertEquals(Duration.ofHours(-1), employeeTime.getHRatio());
    }
}