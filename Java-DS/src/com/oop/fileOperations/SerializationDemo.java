package com.oop.fileOperations;

import java.io.*;
/**
 * Object A --> serialize --> store on the disk
 * from the disk --> deserialize --> get Object A
 * 
 * Class should implement Serializable interface
 * .ser extension is convention used to save serilized instances
 * 
 * instance variables and primitives/arrays are serializable
 * static variables are not.
 * "transient" keyword to instance any variable = no serilization
 */
public class SerializationDemo {
	
	private static final String FILEPATH = "C:\\Users\\pranj\\Downloads\\data-structures-and-algorithms\\Java-DS\\person.ser";
	
	public static void main(String[] args) {
		
		Person person = new Person("StarMan", "Mars United", 7);
		
		SerializationDemo d = new SerializationDemo();
		
		System.out.println("Before serilization");
		System.out.println(person.toString());
		
		d.serializePerson(person);
		
		System.out.println("\nAfter deseilzation");
		
		d.deserializePerson();
		
		
	}
	
	
	public void serializePerson(Person person){
		
		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream(FILEPATH))) {
			
			oos.writeObject(person);
			System.out.println("Serilized ...");
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void deserializePerson(){
		
		Person person = null;
		try (ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream(FILEPATH))) {

				person = (Person) ois.readObject();

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			System.out.println(person.toString());
	}
	
}



class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String name;
	String country;
	transient int uid;
	
	public Person(String name, String country, int uid) {
		super();
		this.name = name;
		this.country = country;
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public int getUid() {
		return uid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", country=" + country + ", uid=" + uid + "]";
	}
	
}
