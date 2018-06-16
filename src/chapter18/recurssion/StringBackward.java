package chapter18.recurssion;

public class StringBackward {

	public static void main(String[] args) {

		
		String word = "smile";
		char[] wordAsChars = word.toCharArray();
		String backwardWord = stringReverse(wordAsChars, 0);
		System.out.println(backwardWord);
	}
	
	private static String stringReverse(char[] word, int size){
			
		if(size == word.length - 1)
			return String.valueOf(word[word.length - 1]);
		else
			return String.valueOf(stringReverse(word, size + 1 )) + word[size];
	}
}
