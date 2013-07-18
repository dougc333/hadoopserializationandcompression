//package org.apache.nutch.scoring.webgraph;

public class TestObject implements java.io.Serializable{
	String name;
	Address address;
	int age;
	Integer numToes;
	
	public TestObject(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getNumToes() {
		return numToes;
	}

	public void setNumToes(Integer numToes) {
		this.numToes = numToes;
	}
	
	
}
