import java.security.SecureRandom;

public class DeckOfCards {
	
	private Card[] deck;
	private int currentCard; // next card to be dealt
	private static final int NUMBER_OF_CARDS = 52;
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	public DeckOfCards()
	{
		String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", 
		         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		
		deck = new Card[NUMBER_OF_CARDS];
		currentCard = 0;                   // the top card (first card to be dealt) 
		
		for (int counter = 0; counter < deck.length; counter++)
		{
			deck[counter] = new Card(faces[counter%13], suits[counter/13]);
		}
	}
	
	public void shuffle()
	{
		currentCard = 0; // FORGOT next call to shuffle() should start at deck[0] again
		
		for (int counter = 0; counter < deck.length; counter++)
		{
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			
			Card temp = deck[counter];			
			deck[counter] = deck[second];
			deck[second] = temp;
		}
	}
	
	public String dealCard()
	{
		if (currentCard < deck.length) // FORGOT
			return deck[currentCard++].toString();
		else
			return null; // FORGOT
	}
	

}
