package insuranceCompany;
/**
 *
 * @author Hooman Shidanshidi hooman@uow.edu.au
 * 
 * Assignment 3 
 * Iterated By Ashutosh Yadav ( 7541302 )
 */

public class ComprehensivePolicy extends InsurancePolicy
{
    protected int driverAge;
    protected int level;
    
    public ComprehensivePolicy (String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level)
    {
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.driverAge= driverAge;
        this.level=level;
    }
	
    @Override
    public double calcPremium(double flatRate)
    {     
        if(driverAge<=30)
        {
            return car.getPrice()/50 + numberOfClaims * 200 + flatRate + (30-driverAge) * 50;
        }
        else
            return car.getPrice()/50 + numberOfClaims * 200 + flatRate;
    }

    // print
    @Override
    public void print()
    {
        super.print();
	System.out.println(" Driver Age: " + driverAge+ " Level: " + level);
    }
    
    @Override
    public String toString()
    {
        return super.toString()+" Driver Age: " + driverAge+ " Level: " + level;
    }  
    
    
    @Override
    public String policyType() {
        return "CHP";
    }

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
    public String toFancyString(){
    return "Comprehensive Policy\n\n"+super.toFancyString()+"\n\n Driver Age : "+driverAge+"\n Driver Level : "+level;
    }
    
    
}
