package Model;

import java.time.Duration;

public class EmployeeTime
{
    private boolean isAtWork;
    private java.time.Duration mustArriveAt;
    private java.time.Duration mustLeaveAt;
    private java.time.Duration[] arrivalList;
    private java.time.Duration[] departureList;
    private java.time.Duration hRatio;

    public EmployeeTime(EmployeeTime param)
    {
        setIsAtWork(param.isAtWork);
        setMustArriveAt(param.mustArriveAt);
        setMustLeaveAt(param.mustLeaveAt);
        setArrivalList(param.arrivalList);
        setDepartureList(param.departureList);
        calculateRatio();

    }

    public EmployeeTime(boolean isAtWork, Duration mustArriveAt, Duration mustLeaveAt, Duration[] arrivalList, Duration[] departureList)
    {
        setIsAtWork(isAtWork);
        setMustArriveAt(mustArriveAt);
        setMustLeaveAt(mustLeaveAt);
        setArrivalList(arrivalList);
        setDepartureList(departureList);
        calculateRatio();
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
        return arrivalList;
    }

    public void setArrivalList(Duration[] arrivalList)
    {
        this.arrivalList = arrivalList;
    }

    public Duration[] getDepartureList()
    {
        return departureList;
    }

    public void setDepartureList(Duration[] departureList)
    {
        this.departureList = departureList;
    }

    public Duration gethRatio()
    {
        return hRatio;
    }

    public void sethRatio(Duration hRatio)
    {
        this.hRatio = hRatio;
    }

    public void calculateRatio()
    {
        Duration ratio = Duration.ofMinutes(0);

        for(int i = 0; i < arrivalList.length; i++)
        {
            ratio = ratio.plus(mustArriveAt.minus(arrivalList[i]));
        }

        for(int i = 0; i < departureList.length; i++)
        {
            ratio = ratio.plus(departureList[i].minus(mustLeaveAt));
        }

        sethRatio(ratio);
    }
}
