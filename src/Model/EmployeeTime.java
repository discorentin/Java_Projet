package Model;

import java.time.Duration;

public class EmployeeTime
{
    private boolean isAtWork;
    private java.time.Duration mustArriveAt;
    private java.time.Duration mustLeaveAt;
    private java.time.Duration[] ArrivalList;
    private java.time.Duration[] DepartureList;
    private java.time.Duration hRatio;

    public EmployeeTime()
    {
    }

    public EmployeeTime(EmployeeTime param)
    {
    }

    public EmployeeTime(boolean isAtWork, Duration mustArriveAt, Duration mustLeaveAt, Duration[] ArrivalList, Duration[] DepartureList)
    {
    }

    public boolean isAtWork()
    {
        return isAtWork;
    }

    public void setAtWork(boolean atWork)
    {
        isAtWork = atWork;
    }

    public Duration getMustArriveAt()
    {
        return mustArriveAt;
    }

    public void setMustArriveAt(Duration mustArriveAt)
    {
        this.mustArriveAt = mustArriveAt;
    }

    public Duration getMustLeaveAt()
    {
        return mustLeaveAt;
    }

    public void setMustLeaveAt(Duration mustLeaveAt)
    {
        this.mustLeaveAt = mustLeaveAt;
    }

    public Duration[] getArrivalList()
    {
        return ArrivalList;
    }

    public void setArrivalList(Duration[] arrivalList)
    {
        ArrivalList = arrivalList;
    }

    public Duration[] getDepartureList()
    {
        return DepartureList;
    }

    public void setDepartureList(Duration[] departureList)
    {
        DepartureList = departureList;
    }

    public Duration gethRatio()
    {
        return hRatio;
    }

    public void sethRatio(Duration hRatio)
    {
        this.hRatio = hRatio;
    }
}
