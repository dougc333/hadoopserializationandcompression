package org.apache.nutch.scoring.webgraph;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.*;

public class TestObjectWritable implements Writable, java.io.Serializable{
	String name;
	AddressWritable address;
	int age;
	Integer numToes;
	
	
	public TestObjectWritable(){}

	
	public void readFields(DataInput in)
    throws IOException {
	age= in.readInt();
    name = Text.readString(in);
    address.readFields(in);
    numToes = in.readInt();
	}

  public void write(DataOutput out)
    throws IOException {
    out.write(age);
    //how to write out address?
    address.write(out);
    Text.writeString(out, name != null ? name : "");
    out.writeInt(numToes);
  }

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public AddressWritable getAddress() {
		return address;
	}


	public void setAddress(AddressWritable address) {
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
