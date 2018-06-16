package initialpackage;

 class B  {
	
	void play(){		
		A a = new A();		
		int ccc = a.x ; // ok - protected variable x visible as A and B are in the same package
	}
}
