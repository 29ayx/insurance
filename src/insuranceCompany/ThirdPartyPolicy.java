package insuranceCompany;
/**
 *
 * @author Hooman Shidanshidi hooman@uow.edu.au
 * 
 * Assignment 3 
 * Iterated By Ashutosh Yadav ( 7541302 )
 */

public class ThirdPartyPolicy extends InsurancePolicy
{
    protected String comments;

    public ThirdPartyPolicy (String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments)
    {
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.comments = comments;
    }

    @Override
    public double calcPremium(double flatRate)
    {
        return car.getPrice()/100 + numberOfClaims * 200 + flatRate;
    }

    @Override
    public void print()
    {
        super.print();
	System.out.println(" Comments: " + comments);
    }
    
    @Override
    public String toString()
    {
        return super.toString()+ " Comments: " + comments;
    }
    
    @Override
    public String policyType() {
        return "TPP";
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public String toFancyString(){
        return ("Third Party Policy \n\n"+super.toFancyString()+"\n\nComment : "+comments);
    }
 
}
