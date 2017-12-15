/*****************************************************************************************************************
 * Notes - I want to add something that would indicate if im in debt or not. Im also considering making this an
 *         optional panel to subtract time.
 *         
 *         I kind of want to implement a list in List_Of_Accountabilites that
 *         would allow me to pick the thing I did and how many time I did so that would subtract the time instead.
 *         Im also going to add a add/delete buttons so the list can be created through the program and not all
 *         written from the file myself.
 *         
 *         I think I might add a backup button that can used in case I mess up.
 *         
 *         Add a possible clear button of all data. This might be best put in the splash page.
 *         
 *         Make sure to look over folder and file names as I dont want these to follow the same naming convention
 *         as my variables.
 *         
 *         You dont close files created by File only when they are created by Formatter and read and writing
 *         objects.
 *         
 *         Dont for get to make backgrounds for your panels to make everything nice :D
 *         
 *         Go back over your functions to make sure they are private if possible. I dont want my functions to be
 *         open for anyone to use them to prevent errors from occurring.
****************************************************************************************************************/


package Options;


import java.awt.Font;						// For Font
import java.awt.GridBagConstraints;			// For GridBagConstraints
import java.awt.GridBagLayout;				// For GridBagLayout
import java.awt.Insets;						// For Insets
import java.awt.event.MouseAdapter;			// For MouseAdapter
import java.awt.event.MouseEvent;			// For MouseEvent
import java.io.File;						// For File
import java.io.FileWriter;					// For FileWriter
import java.io.IOException;
import java.text.DecimalFormat;				// For DecimalFormat
import java.util.Scanner;					// For Scanner

import javax.swing.JButton;					// For JButton
import javax.swing.JFrame;					// For JFrame
import javax.swing.JLabel;					// For JLabel
import javax.swing.JPanel;					// For JPanel
import javax.swing.JTextField;				// For JTextField


/*************************************************************************************
 * 
 * Option_1 - Holds all the functions that are needed to run the input time interface.
 * 
*************************************************************************************/
public class Option_1
{

	/*******************************************
	 * 
	 * main - Is used for testing new functions.
	 * 
	*******************************************/
	public static void main(String[] args) 
	{
		
		Input_Time();//THIS IS FOR TESTING.
		
		/*
		Runtime rt = Runtime.getRuntime();
		
		
		try {
			
			Process pr = rt.exec("tasklist > c:\\Tyler.txt");
			//Process pr = rt.exec("taskkill /IM Steam.exe /f");
			//Process pr = rt.exec("tasklist");
			
			System.out.println("tasklist > c:\\processes_list.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Steam Is Already Closed.");
		}
		
		*/
		
	}
	
	/********************************************************************************
	 * 
	 * Create_Window - Creates the JFrame that will be used for the input time frame.
	 * 
	********************************************************************************/
	private static JFrame Create_Window()
	{
		
		int Screen_Width = 350;																	// Holds the width of the JFrame.
		int Screen_Height = Consistent_Variables.Held_Variables.Screen_Height;					// Holds that screen height to be used for all frames.
		String Title = "Input Time";															// Holds the title of the program.
		
		JFrame F_Window = new JFrame();	
		F_Window.setSize(Screen_Width, Screen_Height);
		F_Window.setTitle(Title);
		F_Window.setResizable(false);
		F_Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F_Window.setLocationRelativeTo(null);// Puts the JFrame in the middle of the screen.
		
		
		return F_Window;
		
	}
	
	/************************************************************************************************************
	 * 
	 * Input_Time - Provides most of the functionality for the interface such as all the components on screen and
	 *              how the buttons will react when clicked on.
	 * 
	************************************************************************************************************/
	public static void Input_Time()
	{
		
		int Screen_Width = 350;															// Holds the width of the JFrame.
		int Screen_Height = Consistent_Variables.Held_Variables.Screen_Height;			// Holds that screen height to be used for all frames.
		
		String File_Path = Consistent_Variables.Held_Variables.File_Path; 						// Holds the path to the folder with the saved files.
		File Time_File = Correction.File_Fixer.File_Creater(File_Path + "Total Time.txt");		// The file that holds all the time for the user.
		
		
		JFrame F_Window = Create_Window();
		
		
		JPanel P_Main_Panel = new JPanel(new GridBagLayout());
		P_Main_Panel.setBounds(0, 0, Screen_Width, Screen_Height);
		
		
		JTextField TF_Time_Box = new JTextField(7);
		JLabel L_Hours_Text = new JLabel("Enter In Your Spent Time");
		JLabel L_Current_Time = new JLabel("Total Allowed Gaming Time: " + File_Time(Time_File) + " Hours");
		
		L_Hours_Text.setFont(new Font("", Font.BOLD, 20));
		
		
		GridBagConstraints GBC_Grid_Bag = new GridBagConstraints();
		
		
		GBC_Grid_Bag.insets = new Insets(10, 10, 10, 0);
		
		GBC_Grid_Bag.gridx = 0;
		GBC_Grid_Bag.gridy = 0;
		P_Main_Panel.add(L_Hours_Text, GBC_Grid_Bag);
		
		GBC_Grid_Bag.gridx = 0;
		GBC_Grid_Bag.gridy = 1;
		P_Main_Panel.add(L_Current_Time, GBC_Grid_Bag);
		
		GBC_Grid_Bag.gridx = 0;
		GBC_Grid_Bag.gridy = 2;
		P_Main_Panel.add(TF_Time_Box, GBC_Grid_Bag);
		
		
		JButton B_Enter = new JButton("Enter");
		JButton B_Home_Page = new JButton("Home Page");
	
		
		Create_Button_Actions(F_Window, Time_File, TF_Time_Box, L_Current_Time, B_Enter, B_Home_Page);

		
		JPanel P_Button_Panel = new JPanel();// Used to help group the buttons together.
		
		
		P_Button_Panel.add(B_Enter);
		P_Button_Panel.add(B_Home_Page);
		
		GBC_Grid_Bag.gridx = 0;
		GBC_Grid_Bag.gridy = 3;
		P_Main_Panel.add(P_Button_Panel, GBC_Grid_Bag);

		
		F_Window.add(P_Main_Panel);
		
		
		F_Window.setVisible(true);
		
	}
	
	/*****************************************************************************************************
	 * 
	 * Create_Button_Action - Creates the button listener actions for the buttons on the input time frame.
	 * 
	*****************************************************************************************************/
	private static void Create_Button_Actions(JFrame F_Window, File Time_File, JTextField TF_Time_Field, JLabel L_Current_Time, JButton B_Enter, JButton B_Home)
	{
		
		B_Enter.addMouseListener(new MouseAdapter()
		{// This looks to see if their is anything in the text field and if the input is also valid before entering in the data to the file.
			
			@Override
			public void mouseClicked(MouseEvent Clicked)
			{
				
				if(!TF_Time_Field.getText().equals("") && Correction.Check_Input.Check_Floats(TF_Time_Field.getText()))
				{
					
					try
					{
						
						DecimalFormat Decimal_Format = new DecimalFormat("#.00");// This helps prevent numbers from having infinite decimals in the file.
						Scanner Read_File = new Scanner(Time_File);
						
						if(Read_File.hasNext())
						{// If the time file already has input we want to add that time plus the additional time inputed by the user.

							float Hold_Num = Float.valueOf(Read_File.next()) + (Float.valueOf(TF_Time_Field.getText()) * -1);// Adds the files time to the inputed time.
							
							
							Hold_Num = Float.valueOf(Decimal_Format.format(Hold_Num));

							
							Read_File.close();

							
							FileWriter Write_File = new FileWriter(Time_File, false);
							
							Write_File.write(Float.toString(Hold_Num));
							
							
							Write_File.close();
							
							
						}
						else
						{

							Read_File.close();
							
							
							FileWriter Write_File = new FileWriter(Time_File, false);
							
							Write_File.write(Decimal_Format.format(Float.valueOf(TF_Time_Field.getText())));
							
							
							Write_File.close();
							
						}

						
						L_Current_Time.setText("Total Allowed Gaming Time: " + Float.valueOf(File_Time(Time_File)) + " Hours");// Updates the label to display the correct total time
						
					}
					catch(Exception E)
					{
						
						System.out.println("Error With File " + Time_File.getName());// This error is vague and could be done better.
						
					}
					
				}
				
				
				TF_Time_Field.setText("");// Clears the text field contents after enter has been pressed.
				
			}
			
		});
		
		B_Home.addMouseListener(new MouseAdapter()
		{// This closes the input time frame and goes back to the home page.
			
			@Override
			public void mouseClicked(MouseEvent Clicked)
			{
				
				F_Window.setVisible(false);
				
				
				Start_Program.Start_Up.Home_Page();
				
			}
			
		});
		
	}
	
	/***************************************************************************************************
	 * 
	 * File_Time - Grabs the time in the time file to be used in the label for the input time interface.
	 * 
	***************************************************************************************************/
	protected static String File_Time(File Time_File)
	{
		
		String Time = "Error";// This will let me know in the JLabel if anything went wrong in reading the file.
		
		
		try
		{// This grabs the contents of the time file.
			
			Scanner S_Time_File = new Scanner(Time_File);
			
			
			if(S_Time_File.hasNext())
			// If this file is new nothing will be inside so we will display a 0 for time.
				Time = S_Time_File.next();
			else
				Time = "0";
			
			
			S_Time_File.close();
		
		}
		catch(Exception E)
		{
			
			System.out.println("Error With Reading File " + Time_File.getName());
			
		}
		
		
		return Time;
		
	}
	
}
