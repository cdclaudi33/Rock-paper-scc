package pace_practice;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;

public class Refree {

	 // private final int times = 10;
	  private int player1, player2;
	  int numberOfTurns=0;
	
	public static void main(String[] args){
		  new Refree();
	  }

	  public Refree() {
		
		ServerSocket serverSocket,serverSocket2 = null;
		BufferedReader in = null,in2 = null;
		System.out.println("Hi, Refree connected");
		
		
		
		
		try {
			serverSocket = new ServerSocket(16790);
			Socket clientSocket = null;
			serverSocket2 = new ServerSocket(16791);
			Socket clientSocket2 = null;
			clientSocket = serverSocket.accept();
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			String t=in.readLine();
			int times = Integer.parseInt(t);
			clientSocket2 = serverSocket2.accept();
			
			in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket2.getOutputStream(), true);
			out.println(times);
//			in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
//			while(numberOfTurns<3) {

			play(in, in2,times);
			System.out.println("Total Turns :"+numberOfTurns);
			
			
//			}
			
			System.out.println("Final Result");
			if(player1>player2)
			System.out.println("Player 1 Winner");
			else if(player2>player1)
				System.out.println("Player 2 Winner");
			else
				System.out.println("Draw!!");
			
			in.close();
			clientSocket.close();
			serverSocket.close();
			in2.close();
			clientSocket2.close();
			serverSocket2.close();
			
			
			
		}
		catch (IOException e) {
			System.out.println("Error: " + e);System.exit(0);
		}
	
	}
	  private void play(BufferedReader in1, BufferedReader in2,int times) {
		    //Complete this method.
		    //0: paper, 1: Rock, 2: Scissors  
	
		    int sa = 0, sb=0;
		    String a = null,b = null;
		  
		     try {
		    	  
		    	 	while(numberOfTurns<times)
		    	 	{
		    	       a=in1.readLine();
		    		  sa = Integer.parseInt(a);
		    	
		    	
		    		   b=in2.readLine();
		    		  sb = Integer.parseInt(b);
		    		
		     
		      switch (sa) {
		      case 0:
		          switch (sb) {
		              case 1:
		                  player2++;
		                  System.out.println("Player 2 wins this round");
		                  break;
		              case 2:
		                  player1++;
		                  System.out.println("Player 1 wins  this round");
		                  break;
		              case 0:          
		                  System.out.println("This round is a draw!");
		                  break;
		          }
		          	
		          break; 
		      case 1:
		          switch (sb) {
		              case 0:
		            	  player1++;
		                  System.out.println("Player 1 wins this round");
		                  break;
		              case 2:
		            	  player2++;
		                  System.out.println("Player 2 wins  this round");
		                  break;
		              case 1:
		                  System.out.println("This round is a draw!");
		                  break;
		      
		          }
		          break;
		      case 2:
		          switch (sb) {
		              case 0:
		            	  player2++;
		                  System.out.println("Player 2 wins this round");
		                  break;
		              case 1:
		            	  player1++;
		                  System.out.println("Player 1 wins this round");
		                  break;
		              case 2:
		                  System.out.println("This round is a draw!");
		                  break;
		         
		      }
		  break;
		       default:
		          switch (sb) {
		              default:
		            	  
		                  System.out.println("Enter correct number: 0 for Rock ,1 for paper, 2 for scissor");
		           
		                  break;
		         
		      }
		  break;
		      }
		      numberOfTurns++;
		    	 	}
		     } 
		    catch (NumberFormatException | IOException e) {
		    	System.out.println("Enter the correct number");
		  e.printStackTrace();
		   }
		 
		  
		     
		    }
	  
}







