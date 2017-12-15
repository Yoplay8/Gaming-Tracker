package Consistent_Variables;


import java.awt.Dimension;		// For Dimension
import java.awt.Toolkit;		// For ToolKit


/******************************************************************************************************************
 * 
 * Held_Variables - Holds all the variables that I want my frames to stay consistent with. The idea is to put
 *                  all these variables in one spot which makes for easy access. My only concern is that this is
 *                  easy access and other functions might unexpectedly change my values so im considering making
 *                  these variables protected and the classes that want to use these variables will have to extend
 *                  this class.
 * 
******************************************************************************************************************/
public class Held_Variables 
{

	public static Dimension Screen_Size = Toolkit.getDefaultToolkit().getScreenSize();	// Used to get the max size of a screen.
	
	public static int Screen_Height = 300;												// This is the desired height to be used for mostly all frames.
	
	public static String Title = "Game Tracker (Alpha 16.2)";							// This title will be used for all frames that display the games title.
	public static String Image_Path = "Images/";										// This is the path to the folder that holds all images.
	public static String File_Path = "Program Files/";									// This is the path to the folder where all the program files are saved.
	
}
