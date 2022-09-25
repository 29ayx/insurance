package insuranceCompany;
/**
 *
 * @author Hooman Shidanshidi hooman@uow.edu.au
 * 
 * Assignment 3 
 * Iterated By Ashutosh Yadav ( 7541302 )
 */
public class MyDate 
{
    private int year;
    private int month;
    private int day;

    MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

	// get and set methods
    public int getYear()
    {
        return year;
    }
    
    public void setYear(int yr)
    {
        year=yr;
    }
    
    public int getMonth()
    {
        return month;
    }

    public void setMonth(int mon)
    {
        month=mon;
    }
    
    public int getDay()
    {
        return day;
    }
    
    public void setDay(int dy)
    {
        day=dy;
    }
    
    public String toFancyString() {
        return "\n Date : "+day+"\n Month : "+month+"\n Year : "+year;
    }
    
    
    public String toString()
    {
        return year + "/" + month + "/" + day;
    }
	public void print()
	{
		System.out.print( " "+year + "/" + month + "/" + day+" ");
		//or System.out.printf("%-2s/%-2s/%-4s%n",month,day,year);
	}

    public Boolean isExpired(MyDate expiryDate)
    {
        if(year < expiryDate.year)
        {
            return false;
        }
        else if(year == expiryDate.year)
        {
            if(month < expiryDate.month)
            {
                return false;
            }
            else if(month == expiryDate.month)
            {
                if(day < expiryDate.day)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
