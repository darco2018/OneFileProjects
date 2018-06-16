package com.ustrzycki.employees;

// BasePlusCommissionEmployee using composition rather than inheritance

public class BasePlusCommissionEmployeeComposition {
	
	private CommissionEmployee commissionEmployee;
	private double baseSalary; // base salary per week
	
	public BasePlusCommissionEmployeeComposition(String firstName, String lastName, 
			String socialSecurityNumber, double grossSales,    
			double commissionRate, double baseSalary)
   {
		commissionEmployee = new CommissionEmployee(firstName, lastName, 
			 socialSecurityNumber, grossSales, commissionRate);
		
		if (baseSalary < 0.0)                   
		      throw new IllegalArgumentException(
		         "Base salary must be >= 0.0");  

		this.baseSalary = baseSalary;
   }
	
	public void setBaseSalary(double baseSalary)
	{
	   if (baseSalary < 0.0)                   
	      throw new IllegalArgumentException(
	         "Base salary must be >= 0.0");  

	   this.baseSalary = baseSalary;                
	} 

	public double getBaseSalary()
	{
	   return baseSalary;
	} 
	
	//return first name
	public String getFirstName()
	{
	 return commissionEmployee.getFirstName();
	}

	//return last name
	public String getLastName()
	{
	 return commissionEmployee.getLastName();
	}

	//return social security number
	public String getSocialSecurityNumber()
	{
	 return commissionEmployee.getSocialSecurityNumber();
	} 

	//set gross sales amount
	public void setGrossSales(double grossSales)
	{
		commissionEmployee.setGrossSales(grossSales);
	} 

	//return gross sales amount
	public double getGrossSales()
	{
	 return commissionEmployee.getGrossSales();
	} 

	//set commission rate
	public void setCommissionRate(double commissionRate)
	{
		commissionEmployee.setCommissionRate(commissionRate);
	} 

	//return commission rate
	public double getCommissionRate()
	{
	 return commissionEmployee.getCommissionRate();
	}
	
	public double earnings()
	{
	   return getBaseSalary() + commissionEmployee.earnings();
	}

	public String toString()
	{
	   return String.format("%s %s%n%s: %.2f", "base-salaried",
			   commissionEmployee.toString(), "base salary", getBaseSalary());   
	} 
}
