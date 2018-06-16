package chapter20genericclassesandmethods;

import java.util.ArrayList;

class Machine {

	@Override
	public String toString() {
		return "I am a machine";
	}

	public void start() {
		System.out.println("Starting...");
	}
}

class Camera extends Machine {

	@Override
	public String toString() {
		return "I am a camera";
	}

	public void snap() {
		System.out.println("Snap!");
	}
}

public class WildcardTesting {

	public static void main(String[] args) {

		ArrayList<Machine> list1 = new ArrayList<>();
		list1.add(new Machine());
		list1.add(new Machine());

		ArrayList<Camera> list2 = new ArrayList<>();
		list2.add(new Camera());
		list2.add(new Camera());

		// printList(list1);
		System.out.println();
		printList(list2);
	}

	static void printList(ArrayList<? extends Machine> list) {

		for (Machine x : list) {
			System.out.println(x);
			x.start();

			if (x instanceof Camera)
				((Camera) x).snap();
		}

		// list.add(new Machine()); >> you cant add to a list defined in the
		// argument list with a wildcard

	}

}
