package org.apache.nutch.scoring.webgraph;

public class Address implements java.io.Serializable{
	private int housenum;
	private String streetName;
	private int zip;
	
	public Address(){}

	public int getHousenum() {
		return housenum;
	}

	
	public void setHousenum(int housenum) {
		this.housenum = housenum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	
}
