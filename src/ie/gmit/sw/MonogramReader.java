package ie.gmit.sw;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class MonogramReader {

	public final String fileName = "./monograms.txt";
	static Map<String,Double> monogram;
	public String[] wordArray;
	ArrayList<String> words = new ArrayList<String>();
	ArrayList<String> percent = new ArrayList<String>();
	ArrayList<Double> percentAfterConversion = new ArrayList<Double>();
	
	
	//takes in file
	public Map<String, Double> createMonogramMap(){
		monogram = new TreeMap<>();
		for(int i = 0; i<percent.size();i++) {
			monogram.put(words.get(i),percentAfterConversion.get(i));
		}
		addLastChar();
		return monogram;
	}
	
	private void addLastChar() {
		monogram.put(",", (0.00323418*100));
		monogram.put(" ", (0.00189169*100));
	}

	//loads monogram
	public void load() throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) 
		{
			String next;
			
			
			while ((next = br.readLine()) != null) {
				String[] str = next.split(","); 
				String s = str[0];
				words.add(s);
				
				String[] str2 = str[1].split(",");
				String p = str2[0];
				percent.add(p);
				
			 }
			}
		
		catch (Exception e) {
			throw new Exception("Error" + e.getMessage());
		}
		
		convert();
	}
	
	//changes string to doubles and adds it to the monogram
	private void convert() {

		for(int c = 0; c < percent.size(); c++) {
			percentAfterConversion.add(Double.parseDouble(percent.get(c))*100);

		}
		
	}

	//shows the monogram
	public void show() {
		System.out.println(monogram);
	}

}
