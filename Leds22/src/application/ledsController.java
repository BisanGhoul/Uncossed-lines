package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;


public class ledsController {
	 

			@FXML
			TextField numOfOnLeds;
			@FXML
			TextField whatAreTheLeds;
			@FXML
			TextArea tableArea;
			
			 String s="";
			 Scanner scan ;
			 int size;
			 int size1=size;
			//size1=size;
			 int[] leds;
			 int []power;
			 int[][] dp;
			public void browse() {
			FileChooser chooser = new FileChooser();
			chooser.getExtensionFilters().addAll(new ExtensionFilter("txt files", "*.txt"));
			File in =chooser.showOpenDialog(null);
			//= new File("C:\\Users\\AsuS\\Desktop\\numbers project 1");
					System.out.println(in.length());

			try {
				scan = new Scanner(in);
			} catch (FileNotFoundException e1) {
				System.out.println("No file Selected");

			
			}catch(java.lang.NullPointerException e2) {
				System.out.println("No file Selected");

			}
		}
			
			
			public  String ifFile() {
				return s;
				
			}
			
			
			
			
			public  void readInt() {
				 int size=scan.nextInt();
				 leds= new int[size];
				 
				for(int i=0;i<leds.length;i++) {
					leds[i]=scan.nextInt();
				}
				 power= new int[size];
				for(int j=0;j<leds.length;j++) {
					power[j]=j+1;
				}
				
				String m=stageOne(leds,power);
				
				numOfOnLeds.setText(m);

			}
			public  String stageOne(int[]leds,int[]power) {
				int size= power.length;String string="";
				 int[][] dp = new int[power.length + 1][power.length + 1]; 
				return string=Integer.toString(numUncrossedLines(dp,leds,power,size,size));
			}
			
			public  void stageTwo() {
				String string2="";
				s="";
				int[][] dp = new int[power.length + 1][power.length + 1]; 
				int size=power.length;
				numUncrossedLines(dp,leds,power,size,size);
				LCS(leds,power,size,size,dp);
				whatAreTheLeds.setText(s);
				
				
			}

			

				// Function to count maximum number 
				// of uncrossed lines between the 
				// two given arrays 
				 public int numUncrossedLines(int[][] dp,int[] rows, int[] power, 
				                          int size, int size1) 
				{ 
				      
				   
				  
				    // Iterate over first array 
				    for(int i = 0; i <= size; i++)  
				    { 
				          
				        // Iterate over second array 
				        for(int j = 0; j <= size1; j++)  
				        { 
				            if (i == 0 || j == 0) 
				              
				                // Update value in dp table 
				                dp[i][j] = 0; 
				  
				            // If both characters 
				            // are equal 
				            else if (rows[i - 1] == power[j - 1]) 
				  
				                // Update the length of lcs 
				                dp[i][j] = 1 + dp[i - 1][j - 1]; 
				  
				            // If both characters 
				            // are not equal 
				            else
				  
				                // Update the table 
				                dp[i][j] = Math.max(dp[i - 1][j], 
				                                    dp[i][j - 1]); 
				        } 
				    } 
				  
				    // Return the answer 
				    return dp[size][size1]; 
				} 
				  
				public  int LCS(int[] leds, int[] power, int i,int j,int[][] dp) {
				

					// return empty string if we have reached the end of
					// either sequence
					if (i == 0 || j == 0) {
						return 0;
					}

					// if last character of X and Y matches
					if (leds[i-1] == power[j-1])
					{try {
						// append current character (X[m-1] or Y[n-1]) to LCS of
						// substring X[0..m-2] and Y[0..n-2]
						
						return LCS(leds, power, i - 1, j - 1, dp);}finally { 
							System.out.println(leds[i-1]);
						s+=	(leds[i-1]);
						}
							
						
					}


					// else when the last character of X and Y are different

					// if top cell of current cell has more value than the left
					// cell, then drop current character of String X and find LCS
					// of substring X[0tom-2], Y[0ton-1]

					if (dp[i - 1][j] > dp[i][j - 1]) {
						return LCS(leds, power, i - 1, j, dp);
					}
					else {
						// if left cell of current cell has more value than the top
						// cell, then drop current character of String Y and find LCS
						// of substring X[0..i-1], Y[0..j-2]

						return LCS(leds, power, i, j - 1, dp);
					}
				
				}
				
				
				public void printTable() {
					int[][] dp = new int[power.length + 1][power.length + 1]; 
					int size=power.length;
					numUncrossedLines(dp,leds,power,size,size);
					LCS(leds,power,size,size,dp);
					String a= printTablePri(dp);
					tableArea.setText(a);
					
					
				}
				
				
				public String printTablePri(int[][] dp) {
					String a="";
				    for(int i = 0; i <= dp.length-1; i++) { 
				     
				          
				        // Iterate over second array 
				        for(int j = 0; j <=dp[i].length-1; j++) {
				        	System.out.print(dp[i][j]+" "+"|");
				        	a+=(dp[i][j]+" "+"|");
				        	
				        }
				        System.out.println("\n");
				        a+="\n";
				        }
					return a;
				}
				
				
				
				
				
				
			/*	// Driver Code 
				public static void main (String[] args) 
				{ 
				      
				    // Given array A[] and B[] 
				   // int A[] = { 1, 2, 3, 4, 5, 6}; 
				   // int B[] = readInt();
				   
				    // Stores the length of lcs 
				    // obtained upto every index 
				    dp = new int[size + 1][size + 1]; 
				    // Function call 
				  System.out.println(numUncrossedLines(dp,leds, power, size, size));
				    System.out.println("\n"+LCS(leds, power, size, size,dp)); 
				    printTable(dp);
				    System.out.println(s);
				}
		*/
		
	
}
