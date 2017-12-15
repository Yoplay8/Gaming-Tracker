package Correction;


/*************************************************************************************************
 * 
 * Check_Input - Is used for the option classes to validate the input that is given from the user.
 * 
*************************************************************************************************/
public class Check_Input 
{

	/*******************************************
	 * 
	 * main - Is used for testing new functions.
	 * 
	*******************************************/
	public static void main(String[] args) 
	{
		
		
	}
	
	/*************************************************************************
	 * 
	 * Check_Floats - Will validate input that requires decimal point numbers.
	 * 
	*************************************************************************/
	public static boolean Check_Floats(String Text)
	{
		
		try
		{// If valeOf throws and error then we know this is not a number.
			
			Float.valueOf(Text);
			
		}
		catch(Exception E)
		{
			
			System.out.println("This Is Not A Number.");
			
			
			return false;
			
		}
	
		return true;
		
	}
	
	/***************************************************************
	 * 
	 * Check_Ints - Will validate input that requires whole numbers.
	 * 
	***************************************************************/
	public static boolean Check_Ints(String Text)
	{
		
		try
		{// If valeOf throws and error then we know this is not a number.
			
			Integer.valueOf(Text);
			
		}
		catch(Exception E)
		{
			
			System.out.println("This Is Not An Integer.");
			
			
			return false;
			
		}
	
		return true;
		
	}
	
	/*
	 * 
	 * Check_Combobox - HAS NOT BEEN COMPLETED YET.
	 * 
	 */
	public static boolean Check_Combobox()
	{
		
		return true;
		
	}
	
}
