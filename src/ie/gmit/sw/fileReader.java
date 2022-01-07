package ie.gmit.sw;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class fileReader extends MonogramReader {
	
	//file thast read in
	public final String fileName = "./test.txt";
	ArrayList<Character> characters = new ArrayList<Character>();
	
	public ArrayList<Character> load(String fileToEncrypt) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./"+fileToEncrypt)))) 
		{
			int next;
			while((next = br.read()) != -1)
			{
			char character = (char) next;
			characters.add(character);
			}
		}
		catch (Exception e) {
			throw new Exception("Not Working" + e.getMessage());
		}
		System.out.println(characters);
		return characters;
	}
}
