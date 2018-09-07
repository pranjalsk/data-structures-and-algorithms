package com.java8.lambda;

public class FunctionalInterfaceDemo1 {

	@FunctionalInterface
	interface FunctionInterface1{	
		int operation(int a, int b);
	}
	
	public int operate(int a, int b, FunctionInterface1 fun) {
		return fun.operation(a, b);
	}
	
	public static void main(String[] args) {
		
		FunctionInterface1 add = (a,b) -> a+b;
		
		FunctionInterface1 multiply = (a,b) -> a*b;
		
		FunctionalInterfaceDemo1 obj = new FunctionalInterfaceDemo1();
		
		System.out.println(obj.operate(3, 6, add));
		System.out.println(obj.operate(3, 6, multiply));
		
	}
	
}
