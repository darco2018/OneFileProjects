class Box {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}
public class DriveTest {

	public static void main(String[] args) {

		String name4 = "Tomek";
		Integer age4 = 50;
		
		Box box = new Box();
		box.set(name4);
		box.set(age4);
		
		
		String name = "Darek";
		Integer age = 50;
		
		Pair pair1 = new Pair(name, age);
		System.out.println(pair1);
		
		String name2 = "Tomek";
		Integer age2 = 50;
		
		Pair pair2 = new Pair(name2, age2);
		System.out.println(pair1.equals(pair2));
		
		Double num = 5.6;
		Pair pair3 = new Pair(num, age2);;
		System.out.println(pair1.equals(pair3));
		
		
		
	}

}
