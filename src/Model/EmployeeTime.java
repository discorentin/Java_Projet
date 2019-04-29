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

    public EmployeeTime(EmployeeTime param)
    {
        setIsAtWork(param.isAtWork);
        setMustArriveAt(param.mustArriveAt);
        setMustLeaveAt(param.mustLeaveAt);
        setArrivalList(param.ArrivalList);
        setDepartureList(param.DepartureList);

    }

    public EmployeeTime(boolean isAtWork, Duration mustArriveAt, Duration mustLeaveAt, Duration[] ArrivalList, Duration[] DepartureList)
    {
    }

    public boolean getIsAtWork()
    {
        return isAtWork;
    }

    public void setIsAtWork(boolean atWork)
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

    public Duration calculateRatio(Duration[] arrivalList, Duration[] departureList)
    {
        int ratio = 0;

        for(int i = 0; i < arrivalList.length; i++)
        {
            ratio = ratio.plus();
        }
    }
}
