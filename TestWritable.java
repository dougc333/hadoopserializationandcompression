package org.apache.nutch.scoring.webgraph;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.*;
import java.io.*;
import org.apache.hadoop.util.*;

//test writable
public class TestWritable implements Writable{


	public static byte[] serialize(Writable writable) throws IOException { 
		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
		DataOutputStream dataOut = new DataOutputStream(out); 
		writable.write(dataOut); 
		dataOut.close(); 
		return out.toByteArray();
	}
	
	public static byte[] deserialize(Writable writable, byte[] bytes) throws IOException { 
		ByteArrayInputStream in = new ByteArrayInputStream(bytes); 
		DataInputStream dataIn = new DataInputStream(in); 
		writable.readFields(dataIn); 
		dataIn.close(); 
		return bytes; 
	}
	
	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String []args){
		IntWritable writable = new IntWritable(); 
		writable.set(16);
		try{
			byte intBytes [] = serialize(writable);
			System.out.println("numBytes:"+intBytes.length);
			System.out.println("hex:"+StringUtils.byteToHexString(intBytes));
			IntWritable makeAgain = new IntWritable();
			byte temp[] = deserialize(makeAgain, intBytes);
			System.out.println("temp length:"+temp.length);
		}catch(Exception e){
			e.printStackTrace();
		}
		TestObject to = new TestObject();
		Address a = new Address();
		a.setHousenum(10);
		a.setStreetName("dead end street");
		a.setZip(99999);
		to.setAddress(a);
		to.setAge(100);
		to.setName("henrietta");
		to.setNumToes(new Integer(10));
		
		//measure size difference to serialize a primitive type using Hadoop then using the Java serialization protocol
		//java serialization 399 bytes
		try{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(to);
			oos.close();
			//restore object and print out fields. 
			byte [] serialBytes = bos.toByteArray();
			System.out.println("serialized byte array lenth:"+serialBytes.length);
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serialBytes));
			TestObject restore = (TestObject)ois.readObject();
			System.out.println("object restore name:"+restore.getName());
			System.out.println("object restore age:"+restore.getAge());
			System.out.println("object restore numToes:"+restore.getNumToes());
			System.out.println("object restore address housenum"+restore.getAddress().getHousenum());
			System.out.println("object restore address houseaddress:"+restore.getAddress().getStreetName());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//hadoop serialization
		TestObjectWritable toWritable = new TestObjectWritable();
		AddressWritable aWritable = new AddressWritable();
		aWritable.setHousenum(10);
		aWritable.setStreetName("dead end street");
		aWritable.setZip(99999);
		toWritable.setAddress(aWritable);
		toWritable.setAge(100);
		toWritable.setName("henrietta");
		toWritable.setNumToes(new Integer(10));
		
		try{
			//this isnt right, you have to use .write to serialize
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(toWritable);
			oos.close();
			
			//restore object and print out fields. 
			byte [] serialBytes = bos.toByteArray();
			byte hadoopBytes[] = WritableUtils.toByteArray(toWritable);
			System.out.println("hadoopBytes:"+hadoopBytes.length);
			
			System.out.println("WRITABLE serialized byte array lenth:"+serialBytes.length);
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serialBytes));
			
			TestObjectWritable restore = (TestObjectWritable)ois.readObject();
			System.out.println("WRITABLE object restore name:"+restore.getName());
			System.out.println("WRITABLE object restore age:"+restore.getAge());
			System.out.println("WRITABLE object restore numToes:"+restore.getNumToes());
			System.out.println("WRITABLE object restore address housenum"+restore.getAddress().getHousenum());
			System.out.println("WRITABLE object restore address houseaddress:"+restore.getAddress().getStreetName());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
}
