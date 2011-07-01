package org.apache.nutch.scoring.webgraph;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.*;

public class AddressWritable implements Writable,java.io.Serializable {
	private int housenum;
	private String streetName;
	private Integer zip;
	
	public AddressWritable(){}

	 public void readFields(DataInput in)
	    throws IOException {
		housenum = in.readInt();
	    streetName = Text.readString(in);
	    zip = in.readInt();
	 }
	
	  public void write(DataOutput out)
	    throws IOException {
	    out.write(housenum);
	    Text.writeString(out, streetName != null ? streetName : "");
	    out.writeInt(zip);
	  }
	 
	 public int getHousenum() {
		return housenum;
	}

	public void setHousenum(Integer housenum) {
		this.housenum = housenum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

}
