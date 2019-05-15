package model;

/**
 * @class EmployeeTime
 */
public class EmployeeTime
{
    /* ATTRIBUTES */

    /**
     * @name EmployeeTime#isAtWork
     * @type {boolean}
     * @private
     */
    private boolean isAtWork;

    /**
     * @name EmployeeTime#mustArriveAt
     * @type {java.time.Duration}
     * @private
     */
    private java.time.Duration mustArriveAt;

    /**
     * @name EmployeeTime#mustLeaveAt
     * @type {java.time.Duration}
     * @private
     */
    private java.time.Duration mustLeaveAt;

    /**
     * @name EmployeeTime#arrivalList
     * @type {java.util.ArrayList<java.time.Duration>}
     * @private
     */
    private java.util.ArrayList<java.time.Duration> arrivalList;

    /**
     * @name EmployeeTime#nbArrivals
     * @type {int}
     * @private
     */
    private int nbArrivals;

    /**
     * @name EmployeeTime#departureList
     * @type {java.util.ArrayList<java.time.Duration>}
     * @private
     */
    private java.util.ArrayList<java.time.Duration> departureList;

    /**
     * @name EmployeeTime#nbDepartures
     * @type {int}
     * @private
     */
    private int nbDepartures;

    /**
     * @name EmployeeTime#hRatio
     * @type {java.time.Duration}
     */
    private java.time.Duration hRatio;

    /* CONSTRUCTORS */

    /**
     * @constructor copy
     * @param {EmployeeTime} param
     */
    public EmployeeTime(EmployeeTime param)
    {
        try
        {
            this.isAtWork = param.getIsAtWork();
            this.setMustArriveAt(param.getMustArriveAt());
            this.setMustLeaveAt(param.getMustLeaveAt());
            this.arrivalList = param.getArrivalList();
            this.nbArrivals = param.getNbArrivals();
            this.departureList = param.getDepartureList();
            this.nbDepartures = param.getNbDepartures();
            this.calculateRatio();

            if (this.getHRatio() != param.getHRatio())
            {
                throw new Exception("error : this.hRatio is " + this.getHRatio() + " when it should be " + param.getHRatio());
            }
        }
        catch(Exception exception)
        {
            System.err.println(exception.getMessage());
        }
    }

    /**
     * @constructor
     * @param {boolean} isAtWork - true if the employee is at work | false if the employee is not at work
     * @param {java.time.Duration} mustArriveAt - the time at which the employee is supposed to arrive at work
     * @param {java.time.Duration} mustLeaveAt - the time at which the employee is supposed to leave work
     */
    public EmployeeTime(boolean isAtWork, java.time.Duration mustArriveAt, java.time.Duration mustLeaveAt)
    {
        try
        {
            this.isAtWork = isAtWork;
            this.setMustArriveAt(mustArriveAt);
            this.setMustLeaveAt(mustLeaveAt);
            this.nbArrivals = 0;
            this.nbDepartures = 0;
            this.calculateRatio();

            if (this.getHRatio() != java.time.Duration.ofMinutes(0))
            {
                throw new Exception("error : this.hRatio is " + this.getHRatio() + " when it should be " + java.time.Duration.ofMinutes(0));
            }
        }
        catch(Exception exception)
        {
            System.err.println(exception.getMessage());
        }
    }

    /* GETTERS */

    /**
     * @function EmployeeTime#getIsAtWork
     * @return {boolean} true if the employee is at work | false if the employee is not at work
     */
    public boolean getIsAtWork()
    {
        return this.isAtWork;
    }

    /**
     * @function EmployeeTime#getMustArriveAt
     * @return {java.time.Duration} the time at which the employee is supposed to arrive at work
     */
    public java.time.Duration getMustArriveAt()
    {
        return this.mustArriveAt;
    }

    /**
     * @function EmployeeTime#getMustLeaveAt
     * @return {java.time.Duration} the time at which the employee is supposed to leave work
     */
    public java.time.Duration getMustLeaveAt()
    {
        return this.mustLeaveAt;
    }

    /**
     * @function EmployeeTime#getArrivalList
     * @return {java.util.ArrayList<java.time.Duration>} the employee's list of arrival hours
     */
    public java.util.ArrayList<java.time.Duration> getArrivalList()
    {
        return this.arrivalList;
    }

    /**
     * @function EmployeeTime#getNbArrivals
     * @return {int} the employee's number of stocked arrival hours
     */
    public int getNbArrivals()
    {
        return this.nbArrivals;
    }

    /**
     * @function EmployeeTime#getDepartureList
     * @return {java.util.ArrayList<java.time.Duration>} the employee's list of departure hours
     */
    public java.util.ArrayList<java.time.Duration> getDepartureList()
    {
        return this.departureList;
    }

    /**
     * @function EmployeeTime#getNbDepartures
     * @return {int} the employee's number of stocked departure hours
     */
    public int getNbDepartures()
    {
        return this.nbDepartures;
    }

    /**
     * @function EmployeeTime#getHRatio
     * @return {java.time.Duration} the employee's time ratio
     */
    public java.time.Duration getHRatio()
    {
        return this.hRatio;
    }

    /* SETTERS */

    /**
     * @function EmployeeTime#setMustArriveAt
     * @param {java.time.Duration} mustArriveAt - the new time at which the employee is supposed to arrive at work
     */
    public void setMustArriveAt(java.time.Duration mustArriveAt)
    {
        this.mustArriveAt = mustArriveAt;
    }

    /**
     * @function EmployeeTime#setMustLeaveAt
     * @param {java.time.Duration} mustLeaveAt - the new time at which the employee is supposed to leave work
     */
    public void setMustLeaveAt(java.time.Duration mustLeaveAt)
    {
        this.mustLeaveAt = mustLeaveAt;
    }

    /* METHODS */

    /**
     * @function EmployeeTime#calculateRatio
     * @description Calculate the employee's time ratio and set its value.
     */
    public void calculateRatio()
    {
        java.time.Duration ratio = java.time.Duration.ofMinutes(0);

        for(int i = 0; i < this.nbArrivals; i++)
        {
            ratio = ratio.plus(this.mustArriveAt.minus(this.arrivalList.get(i)));
        }

        for(int i = 0; i < this.nbDepartures; i++)
        {
            ratio = ratio.plus(this.departureList.get(i).minus(this.mustLeaveAt));
        }

        this.hRatio = ratio;
    }

    /**
     * @function EmployeeTime#addArrival
     * @description Adds an arrival hour to the employee's list of arrival hours
     * @param {java.time.Duration} arrivalTime - the employee's arrival hour
     */
    public void addArrival(java.time.Duration arrivalTime)
    {
        this.arrivalList.add(arrivalTime);
        this.nbArrivals++;
    }

    /**
     * @function EmployeeTime#addDeparture
     * @description Adds a departure hour to the employee's list of departure hours
     * @param {java.time.Duration} departureTime - the employee's departure hour
     */
    public void addDeparture(java.time.Duration departureTime)
    {
        this.departureList.add(departureTime);
        this.nbDepartures++;
    }
}
