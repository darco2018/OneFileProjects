public class MyStuff {

	MyStuff(String n) 
	{ name = n; }	

	String name;
	
public static void main(String[] args) {
	MyStuff m1 = new MyStuff("guitar");
	MyStuff m2 = new MyStuff("guitar");	
	System.out.println(m2.equals(m1));}

public boolean equals(Object o) {

	MyStuff m = (MyStuff) o;

	/*if(m.name != null)
		return true;
	
	return false;*/
	
	if(this.name.equals(m.name))
		return true;
	else
		return false;
}

}


/*What is the result?
A) The output is "true" and MyStuff fulfills the Object.equals() contract.
B) The output is "false" and MyStuff fulfills the Object.equals() contract.
C) The output is "true" and MyStuff does NOT fulfill the Object.equals() contract.
D) The output is "false" and MyStuff does NOT fulfill the Object.equals() contract
E) Compilation fails*/