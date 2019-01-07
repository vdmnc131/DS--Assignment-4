import java.io.*;
import java.lang.*;
import java.util.*;

class Simulate{

	public static void main (String[] args)
	{		
		long start=System.currentTimeMillis();
		Matching B = new Matching();
	

		try 
		{
			FileInputStream fstream =  new FileInputStream("query3.txt"); 
	 		Scanner f = new Scanner(fstream);
	 		
	 		while(f.hasNextLine())
	 		{
	 			String query = f.nextLine(); 
	 			String[] word = query.split(" ");
	 			int size = word.length;
	 			// System.out.println(word[0]+"."+word[1]+"."+word[2]);
	 			
	 			if(word[0].equals("ADD") && word[1].equals("COMPANY")){
	 				
	 				
	 				B.ADD_COMPANY(word[2].substring(0,word[2].length()-1),word[3].substring(0,word[3].length()-1),Integer.parseInt(word[4]));
	 				
			

	 			}
	 			else if(word[0].equals("ADD") && word[1].equals("GRADUATE")){
	 		
	 				
	 				Vector<String> preferences = new Vector<String>();
	 				for(int i=5; i<size; i++){
	 					if(i==(size-1))
	 						preferences.add(word[i]);
	 					else
	 						preferences.add(word[i].substring(0,word[i].length()-1));
	 				}
	 				B.ADD_GRADUATE(word[2].substring(0,word[2].length()-1),word[3].substring(0,word[3].length()-1),Double.parseDouble(word[4].substring(0,word[4].length()-1)), preferences);
	 			

	 			}
	 			else if(word[0].equals("RANK") && word[1].equals("GRADUATES")){
	 			 	try{
	 			 	Vector<String> preferences = new Vector<String>();
	 			 	for(int i=3; i<size; i++){
	 					if(i==(size-1))
	 						preferences.add(word[i]);
	 					else
	 						preferences.add(word[i].substring(0,word[i].length()-1));
	 				}
	 			 	B.PREFERENCE_BY_COMPANY(word[2].substring(0, word[2].length()-1),preferences);
	 			 }
				catch(Exception e){e.printStackTrace();}				


 
	 			}
	 			else if(word[0].equals("DISPLAY") && word[1].equals("COMPANY")){
	 			try{
	 				B.DISPLAY_COMPANY(word[2]);
	 			}
				catch(Exception e){e.printStackTrace();}	 				
	 			}
	 			else if(word[0].equals("DISPLAY") && word[1].equals("GRADUATE")){
	 			try
	 			{	
	 				B.DISPLAY_GRADUATE(word[2]);
	 			}
				catch(Exception e){e.printStackTrace();}			
	 			}
	 			else if(word[0].equals("DISPLAY") && word[1].equals("RANKING")){
	 			try{	
	 				B.DISPLAY_PREFERENCE_BY_COMPANY(word[2]);
	 			}
				catch(Exception e){e.printStackTrace();}	 				
	 			}
	 			else if(word[0].equals("UPDATE") && word[1].equals("CAPACITY")){

	 				try{B.UPDATE_CAPACITY(word[2].substring(0, word[2].length()-1),Integer.parseInt(word[3]));}
					catch(Exception e){e.printStackTrace();}	 				

	 			}
	 			else if(word[0].equals("UPDATE") && word[1].equals("CGPA")){
	 			
	 				try{B.UPDATE_CGPA(word[2].substring(0, word[2].length()-1),Double.parseDouble(word[3]));}
				 	catch(Exception e){e.printStackTrace();}			
	 			}
	 			else if(word[0].equals("UPDATE") && word[1].equals("GRADUATE") && word[2].equals("PREFERENCE")){
	 			try{	
	 				Vector<String> preferences = new Vector<String>();
	 			 	for(int i=4; i<size; i++){
	 					if(i==(size-1))
	 						preferences.add(word[i]);
	 					else
	 						preferences.add(word[i].substring(0,word[i].length()-1));
	 				}
	 				B.UPDATE_PREFERENCE_OF_GRADUATE(word[3].substring(0, word[3].length()-1),preferences);
	 			}
					catch(Exception e){e.printStackTrace();} 			
	 			
	 			}
	 			else if(word[0].equals("DELETE") && word[1].equals("COMPANY")){
	 				try{B.DELETE_COMPANY(word[2]);}
				catch(Exception e){e.printStackTrace();} 				
	 			}
	 			else if(word[0].equals("DELETE") && word[1].equals("GRADUATE")){
	 				try{B.DELETE_GRADUATE(word[2]);}
				catch(Exception e){e.printStackTrace();}			 				
	 	
	 			}
	 			 else if(word[0].equals("MATCH")){
	 			 	B.PERFORM_ASSIGNMENT();
	 			 	 
	 			}
	 		
		}
		}
		catch (FileNotFoundException e)
		{
	 		System.out.println("File not found");
		}
	// }
				long stop=System.currentTimeMillis();
				long elapsedTime=stop-start;
				System.out.println(elapsedTime);
				System.out.println();


	}
}