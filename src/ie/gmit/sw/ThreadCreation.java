package ie.gmit.sw;

public class ThreadCreation {

	int ThreadCount;
	
	//creates Threads
	public void create(int numOfThreads){
		ThreadCount = numOfThreads;
		for(int i = 0; i < numOfThreads; i++) {
			
			System.out.println(i+1);
		}
	}
	
	public int countThreads() {
		return ThreadCount;
	}

}