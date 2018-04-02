//credits:http://www.waytoeasylearn.com
package com.designpatterns.factoryPattern;

public class FactoryPatternDemo {
	
	public static void main(String[] args) {
		MyComputer pc = MyComputerfactory.getComputerInstance("PersonalComputer","4 GB","500 GB","2.6 GHz");
	}
	
}

// Factory class
class MyComputerfactory {

	public static MyComputer getComputerInstance(String type, String hdd, String cpu, String ram) {

		if ("MyPersonalComputer".equalsIgnoreCase(type)) {
			return new MyPersonalComputer(ram, hdd, cpu);
		}
		else if ("MyServer".equalsIgnoreCase(type)) {
			return new MyServer(ram, hdd, cpu);
		}
		return null;
	}

}

/**
 * Super class in factory design pattern can be an interface, abstract class or
 * a normal java class
 */
abstract class MyComputer {
	
	public abstract String getRAM();

	public abstract String getHDD();

	public abstract String getCPU();

	@Override
	public String toString() {
		return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
	}
}

// --------SubClasses-----------
class MyPersonalComputer extends MyComputer {

	private String ram;
	private String hdd;
	private String cpu;

	public MyPersonalComputer(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public String getRAM() {
		return this.ram;
	}

	@Override
	public String getHDD() {
		return this.hdd;
	}

	@Override
	public String getCPU() {
		return this.cpu;
	}
}

class MyServer extends MyComputer {

	private String ram;
	private String hdd;
	private String cpu;

	public MyServer(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public String getRAM() {
		return this.ram;
	}

	@Override
	public String getHDD() {
		return this.hdd;
	}

	@Override
	public String getCPU() {
		return this.cpu;
	}

}
