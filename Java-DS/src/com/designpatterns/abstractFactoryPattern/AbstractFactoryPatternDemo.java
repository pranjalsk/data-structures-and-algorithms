//credits:http://www.waytoeasylearn.com
package com.designpatterns.abstractFactoryPattern;

public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {
		MyComputer pc = MyComputerfactory
				.getComputerInstance(new MyPersonalComputerFactory("4 GB", "500 GB", "2.6 GHz"));
	}

}

// Factory class
class MyComputerfactory {

	public static MyComputer getComputerInstance(MyComputerAbstractFactory factory) {
		return factory.createComputer();
	}

}

// ----------------------------------------------------------------
// create a Abstract Factory interface or abstract class.
interface MyComputerAbstractFactory {
	public MyComputer createComputer();

}

// we need Factory Class for Each subclass.
class MyPersonalComputerFactory implements MyComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;

	public MyPersonalComputerFactory(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public MyComputer createComputer() {
		return new MyPersonalComputer(ram, hdd, cpu);
	}

}

class MyServerFactory implements MyComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;

	public MyServerFactory(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public MyComputer createComputer() {
		return new MyServer(ram, hdd, cpu);
	}

}

// -----------------------------------------------------------------------
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
