package insuranceCompany;
/**
 *
 * @author Hooman Shidanshidi hooman@uow.edu.au
 * 
 * Assignment 3 
 * Iterated By Ashutosh Yadav ( 7541302 )
 */
 
import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class InsurancePolicy
{
    protected String policyHolderName;  
    protected int policyID; 
    protected Car car; 
    protected int numberOfClaims;
    private MyDate expiryDate;
    
    public InsurancePolicy(String policyHolderName, int policyID, Car car, int numberOfClaims, MyDate expiryDate)
    {
        this.policyHolderName = policyHolderName;
        this.policyID = policyID; 
        this.car = car;
        this.numberOfClaims = numberOfClaims;
        this.expiryDate = expiryDate;
    }

    public void setNumberOfClaims(int numberOfClaims) {
        this.numberOfClaims = numberOfClaims;
    }
    
    // get and set methods------------------------------------------------------
    public String getPolicyHolderName()
    {
        return policyHolderName;
    }
    
    public void setPolicyHolderName(String newName)
    {
        policyHolderName = newName;
    }
    
    public int getPolicyID()
    {
        return policyID;
    }
    
    public Car getCar()
    {
        return car;
    }
    
    public void setCar(Car cr)
    {
        car = cr;
    }
    
    public String getCarModel()
    {
        return car.getModel();
    }
    
    public void setCarModel(String model)
    {
        car.setCarModel(model);
    }
     
    public MyDate getExpiryDate()
    {
        return expiryDate;
    }
    
    public void setExpiryDate(MyDate eDate)
    {
        expiryDate=eDate;
    }
    
    public abstract double calcPremium(double flatRate);
    
    // It has one parameter, a price rise in percent. The method increases the policy’s car price by rise percent.
    public void carPriceRise(double risePercent)
    {
        car.priceRise(risePercent);
    }
	
    // print and toString methods-----------------------------------------------
	
    public void print()
    {
        System.out.print("Policy holder name: "+policyHolderName+" ID: "+policyID);
        car.print();
        System.out.print(" Number of claims: "+numberOfClaims);
        //System.out.println(" Expiry Date: " + expiryDate);
	expiryDate.print();
    }

    public void print(double flatRate)
    {
        print();
        System.out.print(" Premium Payment: "+calcPremium(flatRate));
    }
    
    @Override
    public String toString()
    {
        return "Policy holder name: "+policyHolderName+" ID: "+policyID+" Car: "+car+" Number of claims: "+numberOfClaims + " Date: "+ expiryDate;
    }
    
    // prints a list of policies. 
    public static void printPolicies(ArrayList<InsurancePolicy>policies)
    {
        //Lab 8
        this: policies.forEach(x->x.print());
    }

    //print a list of policies and the premiums
    public static void printPolicies(ArrayList<InsurancePolicy> policies,double flatRate)
    {
        for(InsurancePolicy policy: policies )
        {
           policy.print(flatRate);
        }
    }
    
    //calculates the total premium payments for a list of policies. 
    public static double calcTotalPayments(ArrayList<InsurancePolicy> policies, double flatRate)
    {
        return policies.stream()
        .mapToDouble(x->x.calcPremium(flatRate)) .sum();
    }  
    
    // calls the carPriceRise method for all the policies in a given list ( in a for each loop). This is to increase the price of cars for all policies in a list.
    public static void carPriceRiseAll(ArrayList<InsurancePolicy> policies, double risePercent)
    {
        //LAB 8  
        this:policies.forEach(x->x.car.priceRise(risePercent));
    }
    
    // filter methods-----------------------------------------------------------
    
    // which filter a list of policies and creates a filtered list of policies, all with the given car model. 
    public static ArrayList<InsurancePolicy> filterByCarModel(ArrayList<InsurancePolicy> policies, String carModel)
    {
        //LAB 8
        return (ArrayList<InsurancePolicy>)(policies.stream() .filter(x->x.getCarModel().contains(carModel)) .collect(Collectors.toList()));
    } 
    
    // which filter a list of policies and creates a filtered list of policies that are expired by the given date. 
    public static ArrayList<InsurancePolicy> filterByExpiryDate (ArrayList<InsurancePolicy> policies, MyDate date)
    {
        //LAB 8
        return (ArrayList<InsurancePolicy>)(policies.stream() .filter(x->x.getExpiryDate().isExpired(date)) .collect(Collectors.toList()));
        
    }
    
    public abstract String policyType();
    
    public String toFancyString(){
        return   " ID : "+policyID+"\n Policy Holdername : "+policyHolderName+"\n Number Of Claims : "+numberOfClaims+"\n\n +---------Car---------+"+car.toFancyString()+"\n\n +---------Expiring Date---------+ "+expiryDate.toFancyString();
    }
    
}
