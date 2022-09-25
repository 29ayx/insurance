package insuranceCompany;
/**
 *
 * @author Hooman Shidanshidi hooman@uow.edu.au
 * 
 * Assignment 3 
 * Iterated By Ashutosh Yadav ( 7541302 )
 */

import java.util.Scanner;

public class UITools 
{
    //User UI methods
    
    public static void validateUser(User user, int userID, String password)
    {
        if(user.validateUser(userID, password))
        {
            System.out.println("User Login Successful");
        }
        else
        {
            System.out.println("User Login Unsuccessful");
        }
    }

    public static void addPolicy(User user,InsurancePolicy policy)
    {
        if(user.addPolicy(policy))
        {
            System.out.println("The policy has been added successfully");
        }
        else
        {
            System.out.println("The polciy can't be added ID already exists");
        }
    }

    public static void addComprehensivePolicy(User user, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level)
    {
        if(user.createComprehensivePolicy(policyHolderName,  id,  car,  numberOfClaims,  expiryDate,  driverAge,  level))
        {
            System.out.println("The policy is added successfully");
        }
        else 
        {
            System.out.println("The policy can't be added. A policy with the same ID exists");
        }
    }

    public static void addThirdPartyPolicy(User user,String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments )
    {
        if(user.createThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments))
        {
            System.out.println("The policy is added successfully");
        }
        else 
        {
            System.out.println("The policy can't be added. A policy with the same ID exists");
        }
    }

    //Company UI methods
	
    public static void validateAdmin(InsuranceCompany insuranceCompany, String username, String password)
    {
        if(insuranceCompany.validateAdmin(username, password))
        {
            System.out.println("Admin Login Successful");
        }
        else
        {
            System.out.println("Admin Login Unsuccessful");
        }
    }

    public static void addUser(InsuranceCompany insuranceCompany, User user)
    {
        if(insuranceCompany.addUser(user))
        {
            System.out.println("The user has been added successfully");
        }
        else
        {
            System.out.println("The user can't be added ID already exists");
        }
    }

    public static void addUser(InsuranceCompany insuranceCompany, String name, int id, Address address, String password)
    {
        if(insuranceCompany.addUser(name, id, address,password))
        {
            System.out.println("The user has been added successfully");
        }
        else
        {
            System.out.println("The user can't be added ID already exists");
        }
    }

    public static void addPolicy(InsuranceCompany insuranceCompany, int userID, InsurancePolicy policy)
    {
        if(insuranceCompany.addPolicy(userID,policy))
        {
            System.out.println("The policy is added successfully");
        }
        else
        {
            System.out.println("The policy can't be added. A policy with the same ID exists");
        }
    }

    public static void addThirdPartyPolicy(InsuranceCompany insuranceCompany,int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments)
    {
        if(insuranceCompany.createThirdPartyPolicy(userID, policyHolderName, id, car, numberOfClaims, expiryDate, comments))
        {
            System.out.println("The policy was added successfully");
        }
        else 
        {
            System.out.println("The policy can't be added. A policy with the same ID exists");
        }
    }

    public static void addComprehensivePolicy(InsuranceCompany insuranceCompany,int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level )
    {
        if(insuranceCompany.createComprehensivePolicy(userID, policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level))
        {
            System.out.println("The policy is added successfully");
        }
        else 
        {
            System.out.println("The policy can't be added. A policy with the same ID exists");
        }
    }
	
    public static void carPriceRise(InsuranceCompany insuranceCompany, int userID, double risePercent)
    {
        if(insuranceCompany.carPriceRise(userID, risePercent))
        {
            System.out.println("The price rise has been applied successfully");
        }
        else 
        {
            System.out.println("The user has not been found");
        }
    }
    
    //scanner and user input methods
    
    public static Address getAddress()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Address:");
        System.out.println("Enter Street Number:");
        int steetNum = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Street Name:");
        String streetName = sc.nextLine();
        System.out.println("Enter Suburb:");
        String suburb = sc.nextLine();
        System.out.println("Enter City:");
        String city = sc .nextLine();
        return new Address(steetNum, streetName, suburb, city);
    }
    
    public static User getUser()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Create User---");
        System.out.println("Enter User ID:");
        int userID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        System.out.println("Enter Password:");
        String password = sc.nextLine();
        Address address=UITools.getAddress();
        return new User(userID, name, address, password);
    }
    
    public static Car getCar()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter car model:");
        String carModel = sc.next();
        System.out.print("Please enter manufacturing year:");
        int manufacturingYear = sc.nextInt();
        System.out.print("Please enter price:");
        double price = sc.nextDouble();
        System.out.print("Please choose one car type: SUV,SED,LUX,HATCH,UTE");
        CarType carType = CarType.valueOf(sc.next());
        // or CarType carType = CarType.values()[index]; and read index by scanner
        return new Car(carModel, carType, manufacturingYear, price);
    }
    
    public static MyDate getDate()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Expiry Date--");
        System.out.println("Enter Day:");
        int day = sc.nextInt();
        System.out.println("Enter Month:");
        int month = sc.nextInt();
        System.out.println("Enter Year:");
        int year = sc.nextInt();
        sc.nextLine();
        return new MyDate(year, month, day);
    }
    
    public static ThirdPartyPolicy getThirdPartyPolicy()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- ThirdParty Policy ---");
        System.out.println("Enter Policy HolderName:");
        String policyHolderName = sc.nextLine();
        System.out.println("Enter Policy ID:");
        int id = sc.nextInt();
        sc.nextLine();
        Car car=UITools.getCar();
        System.out.println("Enter Number of Claims: ");
        int numberOfClaims = sc.nextInt();
        MyDate expiryDate=UITools.getDate();
        System.out.println("Enter Comments: ");
        String comments = sc.nextLine();
        return new ThirdPartyPolicy (policyHolderName, id, car, numberOfClaims, expiryDate, comments);
    }
    
    public static ComprehensivePolicy getComprehensivePolicy()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- ComprehensivePolicy Policy ---");
        System.out.println("Enter Policy HolderName:");
        String policyHolderName = sc.nextLine();
        System.out.println("Enter Policy ID:");
        int id = sc.nextInt();
        sc.nextLine();
        Car car=UITools.getCar();
        System.out.println("Enter Number of Claims: ");
        int numberOfClaims = sc.nextInt();
        MyDate expiryDate=UITools.getDate();
        System.out.println("Enter driver Age ");
        int driverAge = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter level ");
        int level = sc.nextInt();
        sc.nextLine();
        return new ComprehensivePolicy (policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level);
    }
}
