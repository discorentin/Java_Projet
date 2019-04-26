package Model;

public class EmployeeTime
{
    private boolean isAtWork;
    private java.time.Duration mustArriveAt;
    private java.time.Duration mustLeaveAt;
    private java.time.Duration[] ArrivalList;
    private java.time.Duration[] DepartureList;
    private java.time.Duration hRatio;
}
