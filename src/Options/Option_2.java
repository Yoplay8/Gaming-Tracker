/*
 * 
 * Notes - DONT FORGET TO CLOSE FILES WHEN DONE!!!!!!!!!!!
 * 
 * When dealing with the grid bag X and Y. Make 2 variables that uses
 * increments so if I add buttons out of order or in the future. Everything
 * will stay aligned with out having to change all the numbers.
 * 
 * I with out a doubt need to go back over all my functions and break them
 * down more. Some of my functions are way to big to only be doing one
 * thing. OPTION_2 DEFENITLY NEEDS TO BE BROKEN DOWN.
 * 
 * Consider making less public functions and more protected functions.
 * UPDATE: I tried this and ran into java problems where I need to do some
 *         crazy interface stuff if I want to accomplish this. Maybe ill come
 *         back to this another time.
 *         
 *         Note I did get this to work with only extending one class but, since
 *         I want more than one class extended I ran into problems explained
 *         above.
 * 
 * Make sure im not calling functions unnecessarily as to waste processing time.
 */


package Options;


import java.awt.Dimension;
import java.awt.GridBagConstraints;		// For GridBagCOnstraints
import java.awt.GridBagLayout;			// For GridBagLayout
import java.awt.Insets;					// For Insets
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;		// For MouseAdapter
import java.awt.event.MouseEvent;		// For MouseEvent
import java.util.List;					// For List
import java.io.File;					// For File
import java.io.FileWriter;				// For FileWriter
import java.util.ArrayList;				// For ArrayList
import java.util.Scanner;				// For Scanner

import javax.accessibility.AccessibleContext;
import javax.swing.JButton;				// For JButton
import javax.swing.JComboBox;			// For JComboBox
import javax.swing.JFrame;				// For JFrame
import javax.swing.JLabel;				// FOr JLabel
import javax.swing.JPanel;				// For JPanel
import javax.swing.JPopupMenu;
import javax.swing.JTextField;			// FOr JTextField
import javax.swing.ListCellRenderer;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;


public class Option_2
{

	/*******************************************
	 * 
	 * main - Is used for testing new functions.
	 * 
	*******************************************/
	public static void main(String[] args) 
	{
		
		List_Of_Accountabilities();// THIS IS FOR TESTING.
		
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
		String Title = "List Of Accountabilites";												// Holds the title of the program.
		
		JFrame F_Window = new JFrame();	
		F_Window.setSize(Screen_Width, Screen_Height);
		F_Window.setTitle(Title);
		F_Window.setResizable(false);
		F_Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F_Window.setLocationRelativeTo(null);// Puts the JFrame in the middle of the screen.
		
		
		return F_Window;
		
	}
	
	/*
	 * REDO ONCE I CLEAR THIS MESS UP.
	 * List_Of_Accountabilites - Adds and controls everything that is on the List Of Accountabilities frame.
	 * 
	 */
	public static void List_Of_Accountabilities()
	{
		
		String File_Path = Consistent_Variables.Held_Variables.File_Path; 		// Holds the path to the folder with the saved files.
		int Screen_Height = Consistent_Variables.Held_Variables.Screen_Height;	// Holds that screen height to be used for all frames.
		int Screen_Width = 350;													// Holds the width of the JFrame.
		
		File List_File = Correction.File_Fixer.File_Creater(File_Path + "List Of Actions.txt");
		File Time_File = Correction.File_Fixer.File_Creater(File_Path + "Total Time.txt");// This is used with in the button actions.
		
		
		JFrame F_Window = Create_Window();
		
		
		JPanel P_Main_Panel = new JPanel(new GridBagLayout());// This is to keep all my components in a decent layout.
		P_Main_Panel.setBounds(0, 0, Screen_Width, Screen_Height);
		
		
		GridBagConstraints GBC_Grid_Bag = new GridBagConstraints();
		int Grid_X = 0, Grid_Y = 0;
		
		
		JLabel L_Current_Time = new JLabel("Total Allowed Gaming Time: " + Options.Option_1.File_Time(Time_File) + " Hours");
		
		GBC_Grid_Bag.gridwidth = GridBagConstraints.REMAINDER;// This allows my JLabel to take up two cells instead of one. Really this takes up the remainder of the row not used but, I only have 2 columns.
		
		GBC_Grid_Bag.gridx = Grid_X;
		GBC_Grid_Bag.gridy = Grid_Y;
		P_Main_Panel.add(L_Current_Time, GBC_Grid_Bag);
		

		JComboBox CB_List = new JComboBox(Get_Items_In_File(List_File));// All of my choices are grabbed from a file.
		String Combobox_Display_Size = "123456789";// This sets the size of the combo box so this does not take up the entire screen.
		Combobox_Action(CB_List);
		//CB_List.setToolTipText((String) CB_List.getSelectedItem());// THIS WORKED FOR THE WORD NULL ONLY.
		//CB_List.setSize(300, 200);
		
		GBC_Grid_Bag.insets = new Insets(10, 10, 10, 0);
		GBC_Grid_Bag.gridwidth = 1;
		
		GBC_Grid_Bag.gridx = Grid_X;
		GBC_Grid_Bag.gridy = ++Grid_Y;
		GBC_Grid_Bag.fill = GBC_Grid_Bag.HORIZONTAL;// This fills the entire cell with my combo box.
		CB_List.setPrototypeDisplayValue(Combobox_Display_Size);
		
		P_Main_Panel.add(CB_List, GBC_Grid_Bag);
		
		
		JTextField TF_Num_Of = new JTextField(5);
		
		GBC_Grid_Bag.gridx = ++Grid_X;
		GBC_Grid_Bag.gridy = Grid_Y;
		GBC_Grid_Bag.fill = GBC_Grid_Bag.NONE;
		P_Main_Panel.add(TF_Num_Of, GBC_Grid_Bag);
		
		
		F_Window.add(P_Main_Panel);
		
		
		JButton B_Add_To_List = new JButton("Add");
		JButton B_Delete_From_List = new JButton("Delete");
		
		
		Grid_X = 0;// Bring components back to the left.
		
		GBC_Grid_Bag.gridx = Grid_X;
		GBC_Grid_Bag.gridy = ++Grid_Y;
		P_Main_Panel.add(B_Add_To_List, GBC_Grid_Bag);
		
		GBC_Grid_Bag.gridx = ++Grid_X;
		GBC_Grid_Bag.gridy = Grid_Y;
		P_Main_Panel.add(B_Delete_From_List, GBC_Grid_Bag);
		
		
		JButton B_Enter = new JButton("Enter");
		JButton B_Home_Page = new JButton("Home Page");
		
		
		Create_Bottom_Button_Actions(F_Window, List_File, Time_File, L_Current_Time, TF_Num_Of, CB_List, B_Enter, B_Home_Page);
		
		
		Grid_X = 0;// Bring components back to the left.
		GBC_Grid_Bag.gridx = Grid_X;
		GBC_Grid_Bag.gridy = ++Grid_Y;
		P_Main_Panel.add(B_Enter, GBC_Grid_Bag);
		
		GBC_Grid_Bag.gridx = ++Grid_X;
		GBC_Grid_Bag.gridy = Grid_Y;
		P_Main_Panel.add(B_Home_Page, GBC_Grid_Bag);
		
		
		B_Delete_From_List.addMouseListener(new MouseAdapter()
		{//  REWRITE
			
			@Override
			public void mouseClicked(MouseEvent Clicked)
			{
				
				if(CB_List.getSelectedItem() != "Default")// I DONT THINK ILL ADD IN A DEFAULT.
				{
					
					JFrame F_Delete_Window = new JFrame();
					F_Delete_Window.setSize(Screen_Width - 50, Screen_Height / 2);
					F_Delete_Window.setTitle("Confirm Delete");
					F_Delete_Window.setResizable(false);
					F_Delete_Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					F_Delete_Window.setLocationRelativeTo(null);// Puts the JFrame in the middle of the screen.
					
					
					JPanel P_Main_Panel2 = new JPanel(new GridBagLayout());
					GridBagConstraints GBC_Grid_Bag2 = new GridBagConstraints();
					int Grid_X2 = 0, Grid_Y2 = 0;
					
					
					JLabel L_Confirming_Message = new JLabel("Are you sure you want to delete " + CB_List.getSelectedItem());
					
					GBC_Grid_Bag2.insets = new Insets(10, 10, 10, 0);
					GBC_Grid_Bag2.gridwidth = GridBagConstraints.REMAINDER;
					
					GBC_Grid_Bag2.gridx = Grid_X2;
					GBC_Grid_Bag2.gridy = Grid_Y2;
					P_Main_Panel2.add(L_Confirming_Message, GBC_Grid_Bag2);
					
					
					GBC_Grid_Bag2.gridwidth = 1;
					
					JButton B_Ok = new JButton("Ok");
					JButton B_Cancel = new JButton("Cancel");
					
					
					GBC_Grid_Bag2.gridx = Grid_X2;
					GBC_Grid_Bag2.gridy = ++Grid_Y2;
					P_Main_Panel2.add(B_Ok, GBC_Grid_Bag2);
					
					GBC_Grid_Bag2.gridx = ++Grid_X2;
					GBC_Grid_Bag2.gridy = Grid_Y2;
					P_Main_Panel2.add(B_Cancel, GBC_Grid_Bag2);
					
					
					B_Ok.addMouseListener(new MouseAdapter()
					{// REWRITE
						
						@Override
						public void mouseClicked(MouseEvent Clicked)
						{
							
							try
							{
				
								File Temp_File = Correction.File_Fixer.Clear_File(File_Path + "Temp File.txt");
								FileWriter Write_Temp = new FileWriter(Temp_File, true);///////
								
								Scanner Read_List = new Scanner(List_File);
								
								String Word = "";
								
								
								while(Read_List.hasNext())
								{
									
									Word = Read_List.next();
									
									if(!Word.equals(CB_List.getSelectedItem()))
									{
										
										Write_Temp.write(Word + " ");
										Write_Temp.write(Read_List.next() + " ");
										
									}
									else
										Read_List.next();
									
								}
								
								
								Write_Temp.close();
								Read_List.close();
								
								
								File List_File = Correction.File_Fixer.Clear_File(File_Path + "List Of Actions.txt");
								
								FileWriter Write_List = new FileWriter(List_File, true);
								
								Scanner Read_Temp = new Scanner(Temp_File);
								
								
								while(Read_Temp.hasNext())
								{
									
									Write_List.write(Read_Temp.next());
									
								}
							
							
							F_Delete_Window.setVisible(false);
							
						}
						catch(Exception E)
						{
								
							System.out.println("We Got Problems.");
							
						}
						
					}});
					
					B_Cancel.addMouseListener(new MouseAdapter()
					{// REWRTIE
						
						@Override
						public void mouseClicked(MouseEvent Clicked)
						{
							
							F_Delete_Window.setVisible(false);
							
						}
						
					});
					
					
					F_Delete_Window.add(P_Main_Panel2);
					
					F_Delete_Window.setVisible(true);
					
				}
				
			}
			
		});
		

		F_Window.setVisible(true);// NOT SURE IF THIS DOES WHAT I WANT. SHOULD THIS BE FALSE???
		
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	private static void Combobox_Action(JComboBox CB_List)// MAYBE MAKE A VECTOR.
	{
		
		CB_List.
		/*CB_List.addMouseListener(new MouseAdapter()
		{
			
			@Override
			public void mouseEntered(MouseEvent Clicked)
			{
				
				//Clicked.MOUSE_ENTERED = ;
				CB_List.setToolTipText((String) CB_List.getSelectedItem());
				//System.out.println(CB_List.setRenderer());
				//CB_List.setSize(30, 200);
				//CB_List.addPopupMenuListener(l);
				//CB_List.get
				//System.out.println(Clicked.getPoint());
				//CB_List.menu
			}
			
		});*/
		
		CB_List.addItemListener(new ItemListener()
		{
			
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				String Tyler = "Is Awesome!";
				int Num = ItemEvent.ITEM_STATE_CHANGED;
				//if(Num )
				//Clicked.MOUSE_ENTERED = ;
				CB_List.setToolTipText((String) CB_List.getSelectedItem());
				//System.out.println(CB_List.setRenderer());
				//CB_List.setSize(30, 200);
				//CB_List.addPopupMenuListener(l);
				//CB_List.get
				//System.out.println(Clicked.getPoint());
				//CB_List.menu
			}
			
		});
		
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	private static void Create_Top_Button_Actions()
	{
		
		
	}
	
	/*********************************************************************************************************
	 * 
	 * Create_Bottom_Button_Actions - Creates the button listener actions for the enter and home page buttons.
	 * 
	*********************************************************************************************************/
	private static void Create_Bottom_Button_Actions(JFrame F_Window, File List_File, File Time_File, JLabel L_Current_Time, JTextField TF_Num_Of, JComboBox CB_List, JButton B_Enter, JButton B_Home)
	{
		
		B_Enter.addMouseListener(new MouseAdapter()
		{
			
			@Override
			public void mouseClicked(MouseEvent Clicked)
			{
				
				if(Correction.Check_Input.Check_Ints(TF_Num_Of.getText()))
				{// Looks to see if the input from the user is valid before proceeding to work with the file.
					
					try
					{
						
						Scanner Read_List = new Scanner(List_File);
						Scanner Read_Time = new Scanner(Time_File);
						
						int Plus_Game_Time = 0;				// This holds the time that the user inputed.
						float Total_Gaming_Time = 0;		// This holds the total time from our saved file.
						
						
						while(Read_List.hasNext())
						{// This looks through all the items in the file that are displayed in the combo box so we can find
						 // the correct value to the item that was selected.
														
							if(Read_List.next().equals(CB_List.getSelectedItem()))
							{// When the correct item was found add the time to the total time using the file that holds the total time.
								
								Plus_Game_Time = Integer.valueOf(Read_List.next());
								Plus_Game_Time *= Integer.valueOf(TF_Num_Of.getText());
								
		
								Total_Gaming_Time = Float.valueOf(Read_Time.next());
								
								
								Read_List.close();
								Read_Time.close();

								
								FileWriter Write_File = new FileWriter(Time_File, false);
								
								Write_File.write(Float.toString(Total_Gaming_Time + Plus_Game_Time));// This updates our saved file.
								
								
								Write_File.close();
								
								
								L_Current_Time.setText("Total Allowed Gaming Time: " + (Total_Gaming_Time + Plus_Game_Time) + " Hours");// Update the label to display the correct time.
								
								
								break;
								
							}
							
						}
						
					}
					catch(Exception E)
					{
						
						System.out.println("Could not read from files " + List_File.getName() + " and " + Time_File.getName());
						
					}
					
				}
				
				
				TF_Num_Of.setText("");// Clear the text field so the user doesn't accidently press enter twice with the same input.
				
			}
			
		});
		
		B_Home.addMouseListener(new MouseAdapter()
		{// This closes the List Of Accountabilities frame and goes back to the Home Page.
			
			@Override
			public void mouseClicked(MouseEvent Clicked)
			{
				
				F_Window.setVisible(false);
				
				
				Start_Program.Start_Up.Home_Page();
				
			}
			
		});
		
	}
	
	/***************************************************************************************
	 * 
	 * Get_Items_In_File - Will get all the items out of our saved file holds all of the items and put them into a list that will then be copied over to an array since the combo box will not accept a list as an argument.
	 * 
	***************************************************************************************/
	private static String[] Get_Items_In_File(File List_File)
	{
		
		List<String> Items = new ArrayList<String>();// The combo box will not accept a list. Im using this to make a dynamic array to hold all the items.

		
		try
		{// Get all the items in the saved file to display in the combo box without their values.
			
			Scanner Read_List = new Scanner(List_File);
			
			
			while(Read_List.hasNext())
			{// Get all the items in the saved file.
				
				Items.add(Read_List.nextLine());
				Read_List.nextLine();// This is to skip the value token in the file.
				
			}
			
			
			Read_List.close();
			
		}
		catch(Exception E)
		{
			
			System.out.println("Could not read from file " + List_File.getName());
			
		}

		
		String Items_String[] = new String[Items.size()];// This is a copy of the list since the combo box will accept this.
		
		int Count = 0;
		
		for (String Item : Items)
		{// Copy the list over to the array.
			
			Items_String[Count] = Item;
		
			Count++;
			
		}
		
		
		return Items_String;
		
	}
	
}
