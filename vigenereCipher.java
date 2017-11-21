// package programmingTools;

import java.util.Scanner;
import java.io.*;
 
public class vigenereCipher
{   
            static char [][] CharMatrix=new char[26][26];
	    static char characters[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
					'o','p','q','r','s','t','u','v','w','x','y','z'};
					
					
	/* Function writes the excrypted message to an output file. */
	public static void writeEncryptionToFile(String inputFileName, String outputFileName, String key) 
	{
        
		String contents = getFileContents(inputFileName);
		String encryptedText = encryptString(contents, key);
		BufferedWriter writeFile;
		
		try {
			writeFile = new BufferedWriter(new FileWriter(outputFileName));
			writeFile.write(encryptedText);
			writeFile.close();
		}
		
		catch (Exception ex) {
			System.out.println("\nAn error occured writing to the file!");
		}
	}
	
	
	/* Function writes the decrypted message to an output file. */
	public static void writeDecryptionToFile(String inputFileName, String outputFileName, String key) 
	{
        
		String contents = getFileContents(inputFileName);
		String decryptedText = decryptString(contents, key);
		BufferedWriter writeFile;
		
		try {
			writeFile = new BufferedWriter(new FileWriter(outputFileName));
			writeFile.write(decryptedText);
			writeFile.close();
		}
		
		catch (Exception ex) {
			System.out.println("\nAn error occured writing to the file!");
		}
	}


	/* Function to open and read the file and storing the contents
	 	in a String, and returing the string */
	public static String getFileContents(String fileName) 
	{
       		Scanner readFile;
		String contents = "";
		
		try {
			readFile = new Scanner(new File(fileName));
			contents = readFile.useDelimiter("\0").next(); // store contents in String.
			readFile.close();
		}
		
		catch (FileNotFoundException ex) {
			System.out.println("\nCannot open file!");
		}
		
		return contents;
	}
	
	            
    
	/* Function to encrypt and return a passed String */
	public static String encryptString(String text, String key) 
	{
		
		String cyphir =null;
		int sub1=0,sub2=0,sub3=0;
		int sub=0;
		int start=0;
		
		for(int i=0; i<text.length(); i++) 
		{
		    sub1=text.substring(i,i+1).codePointAt(0);
		    sub2=key.substring(start,start+1).codePointAt(0);
		    start++;
		    sub3=sub1+sub2;
		    sub3=sub3%97;
		    sub=sub3%26;
		     
		    if(cyphir==null)
		        cyphir="" + characters[sub];
		    else
		        cyphir+=characters[sub];
		                  
		     
		    if(start==key.length())
		    {
		        start=0;
		    }
		                 
		}
				
		// return the new encrypted string
		return new String(cyphir);
	}
	
	
	/* Function to decrypt and return a passed String */
	public static String decryptString(String text, String key)
	 {	
	        String dcyphir = null;
		int sub1=0,sub2=0,sub3=0;
		int keyword_len;
		int sub=0;
		int cyphir_len;
		char char_num;
		int start=0;
		for(int i=0; i<text.length(); i++) {
		    sub1=text.substring(i,i+1).codePointAt(0);
		    sub2=key.substring(start,start+1).codePointAt(0);
		     
		    start++;
		     
		    sub1=(sub1%97)%26;
		    sub2=(sub2%97)%26;
		     
		     
		    for(int k=0; k<26; k++) {
		        sub3=(Integer.parseInt(""+(short)CharMatrix[sub2][k])%97)%26;
		         
		        if(sub1==sub3){
		             
		            if(dcyphir==null)
		                dcyphir=Character.toString(CharMatrix[0][k]);
		            else
		                dcyphir+=Character.toString(CharMatrix[0][k]);
		        }
		    }
		     
		      if(start==key.length()){
		        start=0;
		    }
		     
		     
		}
		System.out.println(dcyphir);
		
		return new String(dcyphir);
	}
	
	
	   public void FillCharacMatrix()
	    {         
		for(int i=0; i<=25; i++)
		{
		    for(int j=0; j<=25; j++)
		    {
		        CharMatrix[i][j]=characters[(j+i)%26];
		    }
		}
		 
		for(int i=0;i<=25;i++)
		{             
		    System.out.print(" | ");
		    for(int j=0;j<=25;j++)
		    {      
		        System.out.print(" "+CharMatrix[i][j]+" ");
		    }
		    System.out.println(" | ");
		 }
	     }

}
