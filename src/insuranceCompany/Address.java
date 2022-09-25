package insuranceCompany;
/**
 *
 * @author Hooman Shidanshidi hooman@uow.edu.au
 * 
 * Assignment 3 
 * Iterated By Ashutosh Yadav ( 7541302 )
 */

public class Address 
{
    private int streetNum;
    private String street;
    private String suburb;
    private String city;

    Address(int streetNum, String street, String suburb, String city)
    {
        this.streetNum = streetNum;
        this.street = street;
        this.suburb = suburb;
        this.city = city;
    }
	// get and set methods
	
    public int getStreetNum()
    {
        return streetNum;
    }
    
    public void setStreetNum(int stNum)
    {
        streetNum = stNum;
    }
    
    public String getStreet()
    {
        return street;
    }
    
    public void setStreet(String st)
    {
        street = st;
    }
    
    public String getSuburb()
    {
        return suburb;
    }
    
    public void setSuburb(String sub)
    {
        suburb = sub;
    }

    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public void print()
    {
        System.out.println("Address:" + streetNum + " "  + street + ", " + suburb + ", " + city);
        // or System.out.printf("%-15s%-15s%-15s%-15s%n",streetNum,streetName,suburb,city);
    }

    public String toString()
    {
        return "Street Number:" + streetNum + " Street:" + street + " Suburb:" + suburb + " City:" + city;
    }
}
