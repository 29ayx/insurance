package insuranceCompany;
/**
 *
 * @author Hooman Shidanshidi hooman@uow.edu.au
 * 
 * Assignment 3 
 * Iterated By Ashutosh Yadav ( 7541302 )
 */
import java.util.ArrayList;
import java.util.Random;

public class InsuranceCompany 
{
    private String name; 
    public ArrayList<User>users; 
    private String adminUsername;
    private String adminPassword; 
    private int flatRate; 

    public InsuranceCompany(String name,  String adminUsername, String adminPassword, int flatRate)
    {
        this.name = name;
        this.users = new ArrayList <>();
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.flatRate = flatRate;
    }
    
       public static String genPolicyID() {

        Random rNum = new Random();
        int id = rNum.nextInt(99999);

        //Id will always start with 3
        return String.format("3%05d", id);


    }

       
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
    
    
    
    public int countPolcies(){
        int totalPolicies =0;
    
        for(User x : users){
        
            totalPolicies+=x.totalPolicy();
            
        }
        
        return totalPolicies;
    }

       
    
    // get and set methods------------------------------------------------------
    public String getAdminUsername()
    {
        return adminUsername;
    }
    
    public String getAdminPassword()
    {
        return adminPassword;
    }
     
    public int getFlatRate()
    {
        return flatRate;
    }
    
    public void setFlatRate(int fRate)
    {
        flatRate= fRate;
    }
    
    public boolean validateAdmin(String username, String password)
    {
        if(adminUsername.equals(username) && adminPassword.equals(password))
	{
            return true;
        }
        else 
        {
            return false;
        }
    }

    public User validateUser(int userID, String password)
    {
        
//        for(User user : users) // a bad way
//        {
//            if(user.validateUser(userID, password))
//            {
//                return user;
//            }
//        }
//        return null;
        
        // Correct way by using findUser
        User user=findUser(userID);
        if ((user!= null) && user.validateUser(userID, password))
        {
            return user;
        }
        else
            return null;
    }
	
    // finds the user with the given ID or returns null if user does not exist
    public User findUser(int userID)
    {
        for(User user : users)
        {
            if(user.getUserID() == userID)
            {
                return user;
            }
        }
        return null;
    }
    
    // adds the user to users list if userID is unique, if not returns false
    public boolean addUser(User user)
    {
        if(findUser(user.getUserID()) == null)
        {
            users.add(user);
            return true;
        }
        else 
        {
            return false;
        }
    }

    // creates and adds the User to users list if userID is unique, if not returns false. Create a user object and reuse the addUser(User user) method 
    public boolean addUser(String name, int userID, Address address, String password)
    {
        User user = new User(userID, name, address, password);
        return addUser(user);
    }
    
    public boolean addUser(String name, Address address, String password) //automatic ID generation
    {
        User user = new User(name, address, password); // user constructor to generate ID automatically
        return addUser(user);
    }
	
    // finds the user with the given userID by using findUser method and adds the policy to the user,
    // unsuccessful if userID does not exist or policy is not unique
    public boolean addPolicy (int userID, InsurancePolicy policy)
    {
        User user = findUser(userID);
        if(user != null)
        {
            return user.addPolicy(policy);
        }
        return false;
    }
	
    // finds the insurance policy for the given userID and returns it.
    // Returns null if userID does not exist or policyID does not exist for the given user
    public InsurancePolicy findPolicy (int userID ,int policyID)
    {
        User user = findUser(userID);
        if(user!= null)
        {
            return user.findPolicy(policyID);
        }
        return null;
    }

    // finds the user with the given userID (by calling findUser) and calls the createThirdPartyPolicy for that user. 
    // Returns false if the user does not exist or if User.createThirdPartyPolicy returns false 
    public boolean createThirdPartyPolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments)
    {
        User user = findUser(userID);
        if(user!= null)
        {
            return user.createThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments);
        }
        return false;
    }
    
    // finds the user with the given userID (by calling findUser) and calls the createComprehensivePolicy for that user.
    // Returns false if the user does not exist or if User.createComprehensivePolicy returns false
    public boolean createComprehensivePolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level )
    {
        User user = findUser(userID);
        if(user!= null)
        {
            return user.createComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level);
        }
        return false;
    }
    
    // returns the total premium payments for the given user
    public double calcTotalPayments(int userID)
    {
        User user = findUser(userID);
        if(user != null)
        {
            return user.calcTotalPremiums(flatRate);
        }
        return 0;
    }

    // returns the total premium payments for all the users in the company
    public double calcTotalPayments()
    {
        double totalPayment = 0;
        for(User user : users)
        {
            totalPayment += user.calcTotalPremiums(flatRate);
        }
        return totalPayment;
    }
	
    // calls carPriceRiseAll method for the given user. Returns false if user cannot be found
    public boolean carPriceRise(int userID, double risePercent)
    {
        User user = findUser(userID);
        if(user != null)
        {
            user.carPriceRiseAll(risePercent);
            return true;
        }
        return false;		
    }
	
    // Raise the price of all cars for all users in the company
    public void carPriceRise(double risePercent)
    {
        for(User user: users)
        {
            user.carPriceRiseAll(risePercent);
        }
    }
	  
    // returns a list of all the policies in the company across all users
    public ArrayList<InsurancePolicy> allPolicies ()
    {
        ArrayList<InsurancePolicy> policies = new ArrayList();
        for(User user: users)
        {
            for(InsurancePolicy policy: user.getPolicies())
            {
                policies.add(policy);
            }
        }  
        return policies;
    }

    // find the user by calling findUser and calls filterByCarModel for the given user
    public ArrayList<InsurancePolicy> filterByCarModel (int userID, String carModel)
    {
        User user = findUser(userID);
        if(user != null)
        {
            return user.filterByCarModel(carModel);
        }
        return new ArrayList<InsurancePolicy>();
    }
    
    // find the user by calling findUser and calls filterByExpiryDate for the given user
    public ArrayList<InsurancePolicy> filterByExpiryDate (int userID, MyDate date)
    {
        User user = findUser(userID);
        if(user != null)
        {
            return user.filterByExpiryDate(date);
        }
        return new ArrayList<InsurancePolicy>();
    }
    
    /* filters all the policies in the company by carModel across all users. 
       Iterate over a loop for all users and for each user call the filterByCarModel method and 
       add all the results together for a global list including all users.*/
    public ArrayList<InsurancePolicy> filterByCarModel (String carModel)
    {
        ArrayList<InsurancePolicy> filteredPolicies = new ArrayList();
        for(User user: users)
        {
            for(InsurancePolicy model: user.filterByCarModel(carModel))
            {
                filteredPolicies.add(model);
            }
        }
        return filteredPolicies;
    }
    
    // filters all the policies in the company by ExpiryDate across all users. The same as above
    public ArrayList<InsurancePolicy> filterByExpiryDate (MyDate date)
    {
        ArrayList<InsurancePolicy> filteredPolicies = new ArrayList();
        for(User user: users)
        {
            for(InsurancePolicy exDates: user.filterByExpiryDate(date))
            {
                filteredPolicies.add(exDates);
            }
        }
        return filteredPolicies;
    }

    // print methods 
    
    // prints the user information and all the policies for the given userID  
    public void printPolicies(int userID)
    {
        User user = findUser(userID);
        if(user != null)
        {
            user.printPolicies(flatRate);
        }
    }
    
    public void printUser(int userID) //added for UI
    {
        User user = findUser(userID);
        if(user != null)
        {
            user.print(flatRate);
        }
    }
	
    // prints all the users and for each user all the policies by calling User.PrintPolicies(int flatRate) 
    public void print()
    {
        System.out.println("Company name: "+name+" Username: " + adminUsername+" Flat Rate: "+flatRate);
        for(User user : users)
        {
            // user.print(); // WRONG not based on the spec
            
            // user.printUserInformation() ; // correct but duplicate
            // user.printPolicies(flatRate);
            
            user.print(flatRate); // add this to user and make it better than previous 2 lines
        }
    }

    public String toString()
    {
        String printString = "Company name: "+name+" Username: " + adminUsername+" Flat Rate: "+flatRate+"\n";
        for(User user : users)
        {
            printString += user.toString()+"\n";
        }
        return printString;
    }
    
    public ArrayList<String> populateDistinctCityNames()
    {
        ArrayList<String> cities =new ArrayList<String>();
        for (User user:users)
        {
            boolean found=false;
            for (String city:cities)
            {
                if (user.getCity().equals(city))
                {
                    found=true;
                    break;
                }
            }
            if (!found)
                cities.add(user.getCity());
        }
        return cities;        
    }

    public double getTotalPaymentForCity(String city)
    {
        double totalPaymentForCity = 0;
        for(User user: users)
        {
            if(user.getCity().equals(city))
            {
                totalPaymentForCity += user.calcTotalPremiums(flatRate);
            }
        }
        return totalPaymentForCity;
    }

    public ArrayList<Double> getTotalPaymentPerCity(ArrayList<String> cities)
    {
        ArrayList<Double> totalPerCity = new ArrayList<>();
        for(String city : cities)
        {
            totalPerCity.add(getTotalPaymentForCity(city));
        }
        return totalPerCity;
    }

    public void reportPaymentPerCity(ArrayList<String> cities, ArrayList<Double> payments) // it is in the spec but not good
    {
        String format = "%1$-20s%2$-20s\n";
        System.out.format(format, "City Name", "Total Monthly Payment");
        for (int i=0;i<cities.size();i++)
        {
            System.out.format(format, cities.get(i), payments.get(i));
        }
    }
    
    public void reportPaymentPerCity(ArrayList<String> cities) // for a list of given cities
    {
        ArrayList<Double> payments=getTotalPaymentPerCity(cities);
        String format = "%1$-20s%2$-20s\n";
        System.out.format(format, "City Name", "Total Monthly Payment");
        for (int i=0;i<cities.size();i++)
        {
            System.out.format(format, cities.get(i), payments.get(i));
        }
    }
    
    public void reportPaymentPerCity() // for all cities
    {
        ArrayList<String> cities=populateDistinctCityNames();
        ArrayList<Double> payments=getTotalPaymentPerCity(cities);
        String format = "%1$-20s%2$-20s\n";
        System.out.format(format, "City Name", "Total Monthly Payment");
        for (int i=0;i<cities.size();i++)
        {
            System.out.format(format, cities.get(i), payments.get(i));
        }
    }
    
    public ArrayList<String> populateDistinctCarModels()
    {
        ArrayList<String> allModels =new ArrayList<String>();
        for (User user:users)
        {
            ArrayList<String> userModels =user.populateDistinctCarModels();
            for (String userModel:userModels)
            {
                boolean found=false;
                for (String model:allModels)
                {
                    if (model.equals(userModel))
                    {
                        found=true;
                        break;
                    }
                }
                if (!found)
                    allModels.add(userModel);
            }
        }
        return allModels;        
    }
	
//    public ArrayList<Integer> getTotalCountPerCarModel (ArrayList<String> carModels)
//    {
//        ArrayList<Integer> totalCounts=new ArrayList<Integer>();
//        int count=0;
//        for (String model:carModels)
//        {
//            count=0;
//            for (User user:users)
//            {
//                count+=user.getTotalCountForCarModel(model); // by calling this method which is not the same as spec
//            }
//            totalCounts.add(count);
//        }
//        return totalCounts;
//    }
	
    public ArrayList<Integer> getTotalCountPerCarModel (ArrayList<String> carModels)
    {
        ArrayList<Integer> totalCounts=new ArrayList<Integer>();
        for (int i=0;i<carModels.size();i++)
        {
            totalCounts.add(0);// initial values with 0
        }

        for (User user:users)
        {
            ArrayList<Integer> userCounts=user.getTotalCountPerCarModel(carModels);
            for(int i=0;i<userCounts.size();i++)
            {
                totalCounts.set(i,totalCounts.get(i)+userCounts.get(i));//for each element of total add the user count
            }	
        }
        return totalCounts;
    }
	
    public ArrayList<Double> getTotalPaymentPerCarModel (ArrayList<String> carModels)
    {
        ArrayList<Double> totalPayments=new ArrayList<Double>();
        for (int i=0;i<carModels.size();i++)
        {
            totalPayments.add(0.0);// initial values with 0
        }

        for (User user:users)
        {
            ArrayList<Double> userTotalPayments=user.getTotalPaymentPerCarModel(carModels,flatRate);
            for(int i=0;i<userTotalPayments.size();i++)
            {
                totalPayments.set(i,totalPayments.get(i)+userTotalPayments.get(i));
            }	
        }
        return totalPayments;
    }
		
    //as spec but it is not good. all lists are sent as parameters
    public void reportPaymentsPerCarModel (ArrayList<String> carModels, ArrayList<Integer>counts, ArrayList<Double> payments)
    {
        System.out.println("\n Car Model \t \t \t Total Payments \t \t \t Average Payment");
        for (int i=0;i<counts.size();i++)
            System.out.println(carModels.get(i)+" \t \t \t "+payments.get(i)+" \t \t \t "+payments.get(i)/(double)counts.get(i));  
    }

    //a list of given models 
    public void reportPaymentsPerCarModel (ArrayList<String> carModels)
    {
        ArrayList<Integer> counts=getTotalCountPerCarModel(carModels);
        ArrayList<Double> payments=getTotalPaymentPerCarModel(carModels);
        reportPaymentsPerCarModel (carModels, counts, payments); 
    }

    public void reportPaymentsPerCarModel () // for all models
    {
        ArrayList<String> carModels=populateDistinctCarModels();
        reportPaymentsPerCarModel (carModels);
    }   
    
    
    boolean deleteUser(int policyID){
        
     for (int i=0; i<users.size(); i++)
        {
            if (users.get(i).getUserID() == policyID){
                users.remove(i);
                return true;  
            }
        }
        return false;
    }
}


