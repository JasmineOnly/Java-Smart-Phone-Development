package indi.yuanyuam.proj1.util;

import java.io.*;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

import indi.yuanyuam.proj1.model.Automobile;

public class Util {
	public Automobile buildAutoObject(String filename) {
		
		BufferedReader buff = null;
		String line = null;
		Automobile auto = new Automobile();
		int optionSetSize = 0;
		
		String[] info = new String[4];// Basic information: make, model, base price and option set size
		String[] optionSetInfo;// Store the optionSet's name and size
		String[] optionInfo; // Store the options 
		String[] optionDetail;
				
		try{
			// Open the file using FileReader Object.
			File f = new File(filename);
			buff = new BufferedReader(new FileReader(f));
			
			
			// Read the basic information 
			for(int i = 0; i< info.length; i++){
				info[i] = buff.readLine();							
			}
			
			auto = new Automobile(info[0], info[1],
					Float.parseFloat(info[2]),
					Integer.parseInt(info[3]));
			
			optionSetSize = auto.getOptionSetListSize();
			
			boolean eof = false;
			while( ! eof){
				line = buff.readLine();
				if(line == null){
					eof = true;
					break;
				}
				
				for(int i = 0; i< optionSetSize; i++){
					// Initial the option set
					line = buff.readLine();
					optionSetInfo = line.split(",");
					
					auto.setOptionSet(i, optionSetInfo[0],
							Integer.parseInt(optionSetInfo[1]));
					
					// Get the options
					line = buff.readLine();
					optionInfo = line.split(";");
				
					for(int j = 0; j< optionInfo.length; j++){
						optionDetail = optionInfo[j].split(",");
						auto.setOption(i, j, optionDetail[0], Float.parseFloat(optionDetail[1]));
						
					}
				}
			}
			
			
		}catch(IOException e){
			System.out.println("Error--" + e.toString());
		}finally{
			try{
				buff.close();
			}catch(IOException buffNotClose){
				System.out.println("Error--" + buffNotClose.toString());
			}
			
		}
		
		return auto;					
	}
	
	public void serializeAuto(Automobile auto){
		ObjectOutputStream  oos = null;
		try{
			oos = new ObjectOutputStream(new FileOutputStream("auto.ser"));
			oos.writeObject(auto);
			oos.close();
		}catch(IOException e){
			System.out.println("Error--" + e.toString());
			System.exit(1);
		}finally{
			try{
				oos.close();
			}catch(IOException streamNotClose){
				System.out.println("Error: " + streamNotClose.toString());
			}
		}
	}
	
	public Automobile deserializeAuto(String filename){
		ObjectInputStream ois = null;
		Automobile auto = null;
		try{
			ois = new ObjectInputStream(new FileInputStream(filename));
			auto = (Automobile) ois.readObject();			
		}catch(IOException e){
			System.out.println("Error: " + e.toString());
			System.exit(1);
		} catch (ClassNotFoundException e) {
			System.out.println("Error: " + e.toString());
			System.exit(1);
		}finally{
			try{
				ois.close();
			}catch(IOException streamNotClose){
				System.out.println("Error: " + streamNotClose.toString());
				
			}
		}
		
		return auto;
	}
}
