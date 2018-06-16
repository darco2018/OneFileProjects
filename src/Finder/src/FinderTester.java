import java.util.ArrayList;


public class FinderTester {

	public static void main(String[] args) {

			ArrayList<String> aList = new ArrayList<String>();
			aList.add("drug");
			aList.add("crime");
			aList.add("slimmer");
			aList.add("coffee");
			
		    Finder finder = new Finder();
		    String target = "c";
			String firstStringWithTarget = finder.getIndex(aList, target);
			
			System.out.println(firstStringWithTarget);

	}

}
