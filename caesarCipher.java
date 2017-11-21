//package programmingTools;

import java.util.Scanner;
import java.io.*;

public class caesarCipher
{
		
	/* Function writes the excrypted message to an output file. */
	public static void writeEncryptionToFile(String inputFileName, String outputFileName, int shift) 
	{
        
		String contents = getFileContents(inputFileName);
		String encryptedText = encryptString(contents, shift);
		BufferedWriter writeFile;
		
		try 
		{
			writeFile = new BufferedWriter(new FileWriter(outputFileName));
			writeFile.write(encryptedText);
			writeFile.close();
		}
		
		catch (Exception ex) 
		{
			System.out.println("\nAn error occured writing to the file!");
		}
	}
	
	
	/* Function writes the decrypted message to an output file. */
	public static void writeDecryptionToFile(String inputFileName, String outputFileName, int shift) 
	{
        
		String contents = getFileContents(inputFileName);
		String decryptedText = decryptString(contents, shift);
		BufferedWriter writeFile;
		
		try 
		{
			writeFile = new BufferedWriter(new FileWriter(outputFileName));
			writeFile.write(decryptedText);
			writeFile.close();
		}
		
		catch (Exception ex) 
		{
			System.out.println("\nAn error occured writing to the file!");
		}
	}
	
	
	/* Function to open and read the file and storing the contents
	 	in a String, and returing the string */
	public static String getFileContents(String fileName) 
	{        
		Scanner readFile;
		String contents = "";
		
		try 
		{
			readFile = new Scanner(new File(fileName));
			contents = readFile.useDelimiter("\0").next(); // store contents in String.
			readFile.close();
		}
		
		catch (FileNotFoundException ex) 
		{
			System.out.println("\nCannot open file!");
		}
		
		return contents;
	}
	
	
	/* Function to encrypt and return a passed String */
	public static String encryptString(String text, int shift) 
	{
        
		char[] encryptedText = new char[text.length()];
		int i = 0;
		int j = 0;
		
		// apply the character shift to each character
		for (i = 0; i < text.length(); i++) 
		{            
			if (text.charAt(i) != ' ') 
			{
				encryptedText[j] = determineNextCharInEncryption(text.charAt(i), shift);
			}
			
			else 
				encryptedText[j] = ' ';
			
			j++;
		}
		
		// return the new encrypted string
		return new String(encryptedText);
	}
	
	
	/* Function to decrypt and return a passed String */
	public static String decryptString(String text, int shift) 
	{        
		char[] decryptedText = new char[text.length()];
		int i = 0;
		int j = 0;
		
		// apply the character shift to character
		for (i = 0; i < text.length(); i++) 
		{            
			if (text.charAt(i) != ' ') 
			{
				decryptedText[j] = determineNextCharInDecryption(text.charAt(i), shift);
			}
			
			else
				decryptedText[j] = ' ';
			
			j++;
		}
		
		// return the new decrypted string
		return new String(decryptedText);
	}
	
	
	/* Finds the next character, applying the shift,
	 * and calling the determineCase function. */
	static char determineNextCharInEncryption(char ch, int shift) 
	{
        
		int findCase = determineCase(ch);
		int asciiVal = -1;
		
		// lowercase
		if (findCase == 1) 
		{
            
			if ((int)ch + shift > 122) 
			{
				asciiVal = 97 + (((int)ch + shift) - 122 - 1);
				ch = (char)asciiVal;
			}
			
			else
				ch = (char)(ch + shift);
		}
		
		// uppercase
		else if (findCase == 0) 
		{            
			if ((int)ch + shift > 90) 
			{
				asciiVal = 65 + (((int)ch + shift) - 90 - 1);
				ch = (char)asciiVal;
			}
			
			else
				ch = (char)(ch + shift);
		}
		
		// if character is undefined returns character.
		return ch;
	}
	
	
	/* Finds the next character, applying the shift,
		and calling the determineCase function. */
	public static char determineNextCharInDecryption(char ch, int shift) {
        
		int findCase = determineCase(ch);
		int asciiVal = -1;
		
		// lowercase
		if (findCase == 1) 
		{            
			if ((int)ch - shift < 97) 
			{
				asciiVal = 122 + (((int)ch - shift) - 97 + 1);
				ch = (char)asciiVal;
			}
			
			else
			ch = (char)(ch - shift);
		}
		
		// uppercase
		else if (findCase == 0) 
		{            
			if ((int)ch - shift < 65) 
			{
				asciiVal = 90 + (((int)ch - shift) - 65 + 1);
				ch = (char)asciiVal;
			}
			
			else
			ch = (char)(ch - shift);
		}
		
		// if character is undefined returns character.
		return ch;
	}
	
	
	/* Function to determine the case of character
	 	using ascii values.		*/
	public static int determineCase(char ch) 
	{		
		if ((int)ch >= 97 && (int)ch <= 122)
			return 1;	// lowercase return.
		
		else if ((int)ch >= 65 && (int)ch <= 90)
			return 0;	// uppercase return.
		
		// default invalid case
		return -1;
	}
}
