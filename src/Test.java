class Outer{
	
	String s = "hallo";
	String s2;
	
	
	void method(){
		
		s2 = "Goodbye";
		
		int num;
		num = 4;
		
		class Inner{	
			
			int xcv = 8;
			
			
			void innerMethod(){
				
				//num = 3;
				s2 = "gfhgh";
				xcv = 10;
				System.out.println(num);
				System.out.println(s);
				System.out.println(s2);
			}
		}
		
		
		Inner i = new Inner();
		i.innerMethod();
	}
}

class Test  {
	
	
	
	public static void main(String[] args) {
		
		Outer outer = new Outer();
		outer.method();
		
	}
	
}
