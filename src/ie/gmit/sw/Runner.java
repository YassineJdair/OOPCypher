package ie.gmit.sw;


import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


public class Runner {

	//Variables
	static int ui;
	static int i;
    static int numOfThreads;
    static int defaultThread = 5;
    static boolean enterThread = false;
    static Map<String, Double> monogram;
    static ArrayList<Character> CharList = new ArrayList<Character>();
    static ThreadCreation tc = new ThreadCreation();
    static MonogramReader reader = new MonogramReader();
	static fileReader fr = new fileReader();
	
	
	//main method
	public static void main(String[] args) throws Exception{
		tableCreation();
		startUp();
	}
	
	//start up method
	public static void startUp() throws Exception {
		
		//loops through to give the user a selection multiple times
		for(i = 0;i != -1;) 
		{ 
			
			//start up menu
			System.out.println("***************************************************");
			System.out.println("*        Cypher Cracker System             *");
			System.out.println("***************************************************");
			
			System.out.println("\n1) Enter Cyphertext");
			System.out.println("2) Specify a Text File");
			System.out.println("3) Customisation");
			
			//signout/quit			
			System.out.println("4) Quit");
			System.out.println("\nSelect Option [1-4]>");
			
			//creates scanner for user input
			Scanner input = new Scanner(System.in);
			ui = input.nextInt();
			userInput(ui);
		}
			//end of menu when user quits
			System.out.println("***************************************************");
			System.out.println("*              End of Program                     *");
			System.out.println("***************************************************"); 
			
			System.out.println("Number of Threads : "+tc.countThreads());
			
	}
	
	//creates table using monograms
	private static void tableCreation() throws Exception {
		reader.load();
		monogram = reader.createMonogramMap();
	}

	//user input method
	private static void userInput(int ui) throws Exception {
		switch(ui) {
		case 1->{
			System.out.println("1"); reader.show();
			}
		
		//encrypting specified text
		case 2->{
			encrypt();
			}
		
		//runs if 3 is entered
		case 3->{
			//checks if user has entered the number of threads they wish to use 
			if(enterThread == false) {
				numOfThreads = defaultThread;
				tc.create(numOfThreads);
				tc.countThreads();
			}
			//if no threads have been entered auto creates 5 threads to run 
			else {
				tc.create(numOfThreads);
				tc.countThreads();
			}
		}
		
		//if user enters 4
		case 4->{
			enterThread = true;
		    Threads();
		    }
		//edns programme once user enters 4
		case 5->{i=-1;}
		}	
	}

	//method to encrypt
	private static void encrypt() throws Exception {
		
		System.out.println("Enter file to encrypt");
		Scanner fileInput = new Scanner(System.in);
		String fileToEncrypt = fileInput.next();
		CharList = fr.load(fileToEncrypt);
		
		for(int g = 0; g < CharList.size(); g++) {
			System.out.println(monogram.get(CharList.get(g).toString()));
		}
	}

	//method for threads
	private static void Threads() {
		
		System.out.println("Enter Number Of Threads");
		//takes in user input
		Scanner input = new Scanner(System.in);
		numOfThreads = input.nextInt();
		//new instance of thread class
		tc.create(numOfThreads);
	}
	
//	//chwcks to see if any threads have been entered
//	private static int checkEnteredThreads() {
//		if(enterThread == true) {
//			System.out.println("Entered Threads");
//			return 1;
//			}
//			else {
//			System.out.println("Default Threads");
//			return 0;
//			}
//	}
//	
			
}


