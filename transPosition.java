// package programmingTools;

import java.util.*;
import java.io.*;
 
public class transPosition
{   

	/* Function writes the excrypted message to an output file. */
	public static void writeEncryptionToFile(String inputFileName, String outputFileName, String key) 
	{
        
		String contents = getFileContents(inputFileName);
		String encryptedText = encryptString(contents, key);
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
	public static String encryptString(String message, String key) 
	{
        	String encryptedMessage; 
		// Letters in the x-axis
		int x=0; 
		// Letters in the y-axis
		int y=0; 
		
		int msgchar = message.length();
		int keycahr = key.length();

		if (!((msgchar % keycahr) == 0))
		{

			do
			{
				message = message + "x";
				msgchar = message.length();
			}
			while(!((msgchar % keycahr) == 0));

		}


		encryptedMessage = "";

		// To set the temp as [x][y]
		char temp[][]=new char [key.length()][message.length()];
		char msg[] = message.toCharArray();

		// To populate the array
		x=0;
		y=0;

		// To convert the message into an array of char
		for (int i=0; i< msg.length;i++)
		{
			temp[x][y]=msg[i];
			if (x==(key.length()-1)) 
			{
				x=0;
				y=y+1;
			} 
			else 
			{
				x++;
			}
		} 

		// To sort the key
		int len=key.length();
		char t[]=new char [len];
		t=key.toCharArray();
		
		System.out.println(" ");
		
		Arrays.sort(t);
				
		// To print out row by row (i.e. y)
		for (int j=0;j<y;j++)
		{ 
			// To compare the the sorted Key with the key
			// For char in the key
			for (int i=0;i<key.length();i++)
			{ 
				int pos=0;
				// To get the position of key.charAt(i) from sorted key
				for (pos=0;pos<t.length;pos++)
				{ 
					if (key.charAt(i)==t[pos])
					{ 
						// To break the for loop once the key is found
						break;
					}
				}
				//System.out.print(temp[pos][j]);
				encryptedMessage+=temp[pos][j];
			}
			//System.out.println();
		}

		// return the new encrypted string
		return new String(encryptedMessage);
	}
	
	}
