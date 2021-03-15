package pace_practice;
import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;

public class Player2 {
	public Player2() {
       Socket clientSocket = null;
    try {// Complete this part. Use the port number: 16790
    	int ip = 16791;
    	BufferedReader in=null;
    	int numberOfTurns=0;
    	String host = "localhost"; 
    	clientSocket = new Socket(host, ip);
    	
    	PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		Scanner keyboard = new Scanner(System.in);
		 in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			String t=in.readLine();
			int times = Integer.parseInt(t);
		
		while (numberOfTurns<times) 
		{
	    System.out.println("Enter 0 for Rock ,1 for paper, 2 for scissor");
	    out.println(keyboard.nextLine());
		
	   
//    	in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//    	String s = in.readLine();
//    	while(s == null)//As long as there is nothing in the stream keep reading
//    		s = in.readLine();
    		//System.out.println(s);
    	numberOfTurns++;
		}
    	in.close();
    	keyboard.close();
    	clientSocket.close();
	
    }catch (IOException e) {
      System.out.println("Error: " + e);
      System.exit(0);
    }   		
  }
  public static void main(String[] args){
    //This method is complete. Do not change it.
  	new Player2();
  }
  
  private void play(PrintWriter out) {
    //This method is complete. Do not change it.
    final int times = 10;
    Random rand = new Random();
    for(int i =1; i <= times; i++) {
      int ply = rand.nextInt(3);
      out.println("" + ply);
      display(ply);
    }
    System.out.println("P1=");
  }
  
  private void display(int ply) {
    //This method is complete. Do not change it.
    if(ply == 0)
    	System.out.print("Paper,");
    else if(ply == 1)
    	System.out.print("Rock,");
    else
    	System.out.print("Scissors,");
	}
}

