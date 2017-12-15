package Correction;


import java.io.File;			// For File
import java.util.Formatter;		// For Formatter


/*****************************************************************************************************
 * 
 * File_Fixer - Works with files that need to be created or modified but does not actually add content
 *              to the files.
 * 
*****************************************************************************************************/
public class File_Fixer 
{

	/*******************************************
	 * 
	 * main - Is used for testing new functions.
	 * 
	*******************************************/
	public static void main(String[] args) 
	{
		
		
	}

	/***************************************************************************************************************
	 * 
	 * File_Creater - Creates new files if needed other wise calls a different command that will prevent the current
	 *                file from being deleted.
	 * 
	***************************************************************************************************************/
	public static File File_Creater(String File_Path)
	{
		
		File New_File = new File(File_Path);// This does not create a new file. This will only test to see if a file
		                					// with this name already exists.
		
		if (!New_File.exists())
		{// Look to see if a file exists.
			
			try
			{// Create a new file with this name.
				
				Formatter Brand_New_File = new Formatter(File_Path);
				
				
				Brand_New_File.close();
				
			}
			catch(Exception E)
			{
			
				System.out.print("\n\nFile Was Not Created.");
				
			}
			
		}
		
		
		return New_File;
		
	}
	
	/************************************************************************************
	 * 
	 * Clear_File - Will recreate a file in order to erase all the content from the file.
	 * 
	************************************************************************************/
	public static File Clear_File(String File_Path)
	{
			
			File New_File = new File(File_Path);// This does not create a new file. This will only test to see if a file
			                					// with this name already exists.

				
			try
			{// Create a new file with this name.
					
				Formatter Brand_New_File = new Formatter(File_Path);
					
					
				Brand_New_File.close();
					
			}
			catch(Exception E)
			{
				
				System.out.print("\n\nFile Was Not Created.");
					
			}
			
			
			return New_File;
			
		}

}
