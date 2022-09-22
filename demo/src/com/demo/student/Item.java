package com.demo.student;
/**
 * @author wei
 * Email: ghostwei@gmail.com
 * Project Name: java-demo
 * DateTime: 2022/9/20 14:11
 */
public class Item {

	protected int id;
	protected String number;
	protected String name;
	protected int age;
	protected String address;

	@Override
	public String toString() {
		return this.id + "\t\t" + this.number + "\t\t" + this.age + "\t\t" + this.name + "\t\t" + this.address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Item(int id, int age, String number, String name, String address) {
		this.id = id;
		this.number = number;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Item() {
	}

}
