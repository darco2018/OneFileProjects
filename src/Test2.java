import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;

class Test2{
	
	
	
	public static void main(String[] args) {
		
		//Collection<String> list = new ArrayList<>();
		//list.stream();
		
		int[] numbers = {1,2,3,4,5,6};
		
		IntPredicate even = value -> value % 2 == 0;
		IntUnaryOperator addTwo = value -> value + 2;
		Function addTwo2 = value -> (int)value + 2;
		Function<Integer, Integer> add2 = value -> value + 2;
		IntConsumer display = value -> System.out.println(value);
			
		
		IntStream.of(numbers)
				.filter(even)
				.map(addTwo)
				.forEach(display);
		
		IntPredicate smallerThan4 = value -> value < 4;
		
		IntStream.of(numbers)
		.filter(even.and(smallerThan4))
		.filter(even.negate())
		.forEach(display);
		
		String[] stringsArr = {"jazz", "ace", "zoo", "fake"};
		
		Predicate<String> condition = value -> value.compareTo("go") > 0;
		Consumer displayString = value -> System.out.println(value);
		
		Arrays.stream(stringsArr)
		      .filter(condition)
		      .forEach(displayString);
		
		
	}
	
	
	
}
