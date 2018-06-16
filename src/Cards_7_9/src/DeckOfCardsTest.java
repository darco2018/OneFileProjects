
public class DeckOfCardsTest {

	public static void main(String[] args) {

		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle();
		
		for (int counter = 0; counter < 52; counter++)
		{
			if (counter % 4 == 0)
				System.out.println();
				
			System.out.printf("%-19s   ", myDeckOfCards.dealCard());
		}
	}

}
