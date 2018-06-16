public enum Directions{
	
  EAST ("E"), 
  WEST ("W"), 
  NORTH ("N"), 
  SOUTH ("S"); 
  
  private final String shortCode;
	  
  
  Directions(String code) {
      this.shortCode = code;
  }
	  
  public String getDirectionCode() {
      return this.shortCode;
  }
}