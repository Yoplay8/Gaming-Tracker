package Correction;


import java.io.File;			// For File
import java.util.Formatter;		// For Formatter


/*********************************************************************************
 * 
 * Create_File - Creates all files needed for the program but, does not edit them.
 * 
*********************************************************************************/
public class Create_File 
{

	/*******************************************
	 * 
	 * main - Is used for testing new functions.
	 * 
	*******************************************/
	public static void main(String[] args) 
	{
		
		
	}

	/*
	 * 
	 * File_Creater - Creates new files if needed other wise calls a different command that will prevent the current
	 *                file from being deleted.
	 * 
	 */
	public static File File_Creater(String File_Name)
	{
		
		File New_File = new File(File_Name);// This does not create a new file. This will only test to see if a file
		                // with this name already exists.
		
		if (!New_File.exists())
		{// Look to see if a file exists.
			
			try
			{// Create a new file with this name.
				
				Formatter Brand_New_File = new Formatter(File_Name);
				
				
				Brand_New_File.close();
				
			}
			catch(Exception E)
			{
			
				System.out.print("\n\nFile Was Not Created.");
				
			}
			
		}
		
		
		return New_File;
		
	}
	
}
