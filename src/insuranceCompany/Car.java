package insuranceCompany;
/**
 *
 * @author Hooman Shidanshidi hooman@uow.edu.au
 * 
 * Assignment 3 
 * Iterated By Ashutosh Yadav ( 7541302 )
 */

enum CarType{SUV,SED,LUX,HATCH,UTE}

public class Car
{
    private String model;
    private CarType carType;
    private int manufacturingYear;
    private double price;
    
    public Car(String model, CarType carType, int manufacturingYear, double price)
    {
        this.model = model;
        this.carType = carType;
        this.manufacturingYear = manufacturingYear;
        this.price = price;    
    }
    
    // get and set methods
    public String getModel()
    {
        return model;
    }
    
    public void setCarModel(String mdel)
    {
        model=mdel;
    }
    
    public CarType getCarType()
    {
        return carType;
    }
    
    public int getManufacturingYear()
    {
        return manufacturingYear;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    // print
    
    public void print()
    {
        System.out.print(" Model: " + model + " Car Type: " + carType + " Manufacturing Year: " + manufacturingYear + " Price: ");
        System.out.printf("%.2f", price);
	// or System.out.printf("%-15s%-20s%-15s%-15s%n",model,manufacturingYear,price,carType);
    }
    
    @Override
    public String toString()
    {
        return "Model: "+model+" Car Type: "+carType+ " Manufacturing Year: "+manufacturingYear+" Price: " + String.format("%.2f",price);
    }

    public void priceRise(double rise)
    {
        price *= (1+rise); 
    } 
    
        public String toFancyString() {

        return "\n Car Model : "+model+"\n Car Type : "+carType+"\n Manufacturing Year : "+manufacturingYear+"\n Car Price : "+price;
    }
}
