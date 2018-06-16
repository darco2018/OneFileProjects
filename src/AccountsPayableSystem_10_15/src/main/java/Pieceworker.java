
public class Pieceworker extends Employee{
	
	private double wage;
	private double pieces;
	
	public Pieceworker(String firstName, String lastName, 
      String socialSecurityNumber, Date birthdate, double wage, double pieces)
	{
		super(firstName, lastName, socialSecurityNumber, birthdate);
		
		// validate wage and pieces
		validateWage(wage);
		validatePieces(pieces);		
		
		this.wage = wage;
		this.pieces = pieces;
	}
	
	public void setWage(double wage)
	{
		validateWage(wage);		
		this.wage = wage;
	}
	
	public void setPieces(double pieces)
	{
		validatePieces(pieces);			
		this.pieces = pieces;
	}
	
	private static void validateWage(double wage)
	{
		if(wage < 0.0)
			throw new IllegalArgumentException("Wage per piece must be >= 0");
	}
	
	private static void validatePieces(double pieces)
	{
		if(pieces < 0.0)
			throw new IllegalArgumentException("Pieces must be >= 0");
	}

	/**
	 * @return the wage
	 */
	public double getWage() {
		return wage;
	}

	/**
	 * @return the pieces
	 */
	public double getPieces() {
		return pieces;
	}

	@Override
	public double getPaymentAmount() {
		
		return getWage() * getPieces();
	}

	/* (non-Javadoc)
	 * 
	 */
	@Override
	public String toString() 
	{
		return String.format("%s %s%n%s $%.2f, %s %.2f",
				"pieceworker:", super.toString(), 
				"wage per piece:", getWage(), 				
				"pieces produced:", getPieces() 
				);
				
	}
	
	
}
