
public class Card {
	
	// two instance variables
	private final String suit;
	private final String face;
	
	public Card(String cardFace, String cardSuit)
	{
		this.face = cardFace;
		this.suit = cardSuit;		
	}
	
	public String toString()
	{
		return face + " of " + suit;
	}

}
