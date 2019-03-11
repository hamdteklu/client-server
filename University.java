import java.io.Serializable;

public class University implements Serializable
{
	private String name;
	private int totalCreditHour;
	private double costPerCreditHour;
	private double totalTuition;
	
	//attributes
	public University(String name, int totalCreditHour, double costPerCreditHour)
	{
		this.name=name;
		this.totalCreditHour= totalCreditHour;
		this.costPerCreditHour= costPerCreditHour;
	}
	
	//default constructor
	public University()
	{

	}
	//set methods
	public void setName(String name)
	{
		this.name= name;
	}
	
	public void setTotalCreditHour(int totalCreditHour)
	{
		this.totalCreditHour= totalCreditHour;
	}

	public void setCostPerCreditHour(double costPerCreditHour)
	{
		this.costPerCreditHour= costPerCreditHour;
	}

	//minght not need this
	
	//get methods
	public String getName()
	{
		return name;
	}	
	public int getTotalCreditHour()
	{
		return totalCreditHour;
	}
	public double getCostPerCreditHour()
	{
		return costPerCreditHour;
	}

	//might not need this
	public double getTotalTuition()
	{
		return totalTuition;
	}
	
	//toString

	public String toString()
	{
		System.out.println("_____________________________________________________________________________");
		return("Name: "+ name+ " Total Credit Hour: "+ totalCreditHour+ " Cost Per Credit Hour: "+ 
		costPerCreditHour+ " Total Tuition "+ totalTuition);
	}

	public void setTotalTuition()
	{
		totalTuition= totalCreditHour*costPerCreditHour;
	}
	
	
}