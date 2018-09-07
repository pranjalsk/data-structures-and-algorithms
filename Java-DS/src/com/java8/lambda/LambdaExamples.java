package com.java8.lambda;

import java.math.BigInteger;
import java.util.*;

public class LambdaExamples {

	public static void main(String[] args) {

		List<Developer> listdevs = new ArrayList<Developer>() {{
			add(new Developer("Yappie", 24, new BigInteger("150000")));
			add(new Developer("Sappie", 23, new BigInteger("160000")));
			add(new Developer("Zappie", 24, new BigInteger("130000")));
			add(new Developer("Gappie", 25, new BigInteger("140000")));			
		}};
		
		//streams for each to print list
		System.out.println("Before Sorting");
		listdevs.forEach((developer) -> System.out.println(developer.toString()));
		
		System.out.println("Sorting based on Name");
		sortDevelopoerByNameLambda(listdevs);
		listdevs.forEach((developer) -> System.out.println(developer.toString()));
		
		System.out.println("Sorting based on Age");
		sortDevelopoerByAgeLambda(listdevs);
		listdevs.forEach((developer) -> System.out.println(developer.toString()));
		
		
		System.out.println("Iterating map -------");
		//Iterating map
		Map<String, Integer> itemsMap = new HashMap<>();
		itemsMap.put("A", 10);
		itemsMap.put("B", 20);
		itemsMap.put("C", 30);
		itemsMap.put("D", 40);
		itemsMap.put("E", 50);
		itemsMap.put("F", 60);
		
		itemsMap.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
		
		itemsMap.forEach((k,v)->{
			System.out.println("Item : " + k + " Count : " + v);
			if("E".equals(k)){
				System.out.println("Hello E");
			}
		});
		
		System.out.println("Streams on list----");
		List<String> items = new ArrayList<>();
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");
		//Stream and filter
		//Output : B
		items.stream()
			.filter(s->s.contains("B"))
			.forEach(System.out::println);
		
	}
	
	public static void sortDevelopoerByNameOld(List<Developer> developers) {
		Collections.sort(developers, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}
	
	public static void sortDevelopoerByAgeOld(List<Developer> developers) {
		Collections.sort(developers, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getAge()-o2.getAge();
			}
		});
	}
	
	public static void sortDevelopoerByNameLambda(List<Developer> listdevs) {
		listdevs.sort((Developer o1, Developer o2) -> o1.getName().compareTo(o2.getName()));
	}
	
	public static void sortDevelopoerByAgeLambda(List<Developer> listdevs) {
		listdevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());
	}

}



class Developer{
	
	private String name;
	private int age;
	private BigInteger salary;
	
	public Developer(String name, int age, BigInteger salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public BigInteger getSalary() {
		return salary;
	}
	public void setSalary(BigInteger salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Developer [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
}