
public class InheriDemo {

	public static void main(String[] args) {

		//Base class ref + base class obj
		Parent p = new Parent();
		p.pMethod1(); 
		p.pMethod2();
		//only  base class methods accesible
		

		System.out.println("-----------------");
		
		 //Child ref + child obj
		Child c =new Child();
		c.pMethod1(); //parent method
		c.pMethod2(); //overriden child method
		c.cMethod1(); //child method

		System.out.println("-----------------");
		
		//Base ref + child obj
		Parent pc = new Child();
		pc.pMethod1(); //parent method
		pc.pMethod2(); //overriden child method
		//pc.cMethod1(); //compile error
		
		System.out.println("------------");
		
		//Exception in thread "main" java.lang.ClassCastException: Parent cannot be cast to Child
		//at InheriDemo.main(InheriDemo.java:31)
		Child cp = (Child) new Parent();
		cp.pMethod1();
		cp.pMethod2();
		cp.cMethod1();
		
	}
	
}

class Parent{
	
	public void pMethod1(){
		System.out.println("parent method1");
	}
	
	public void pMethod2(){
		System.out.println("orginal parent method2");
	}
}

class Child extends Parent{
	
	public void pMethod2(){
		System.out.println("overriden parent method1 in child");
	}
	
	public void cMethod1(){
		System.out.println("child method1");
	}


	
}
