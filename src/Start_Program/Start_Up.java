/************************************************************************
 * 
 * As you may notice not all of the lines are spaced the same. The
 * spacing mainly only makes sense to me on how I wanted to group the
 * lines up. I didn't double space by mistake.
 * 
 * Programmer Notes: All J related objects start with the first letter of
 * 					 each word of what they are followed by a under score
 * 				     and then the name of the variable.
 * 					 THIS IS KIND OF FALSE AS NOT EVERYTHING I DID THIS TO IS A J OBJECT.
 * 
 * 	   						Naming Convention
 * 
 * 							Frames = F_NAME
 * 							Labels = L_NAME
 *							Buttons = B_NAME
 *							Image = I_NAME
 *							IconImage = II_NAME
 *							etc.
 * 
 * 
************************************************************************/


package Start_Program;


import java.awt.GridBagConstraints;			// For GridBagConstraints
import java.awt.GridBagLayout;				// For GridBagLayout
import java.awt.Image;						// For Image
import java.awt.Insets;						// For Insets
import java.awt.Toolkit;					// For ToolKit
import java.awt.event.MouseAdapter;			// For MouseAdapter
import java.awt.event.MouseEvent;			// For MouseEvent

import javax.swing.ImageIcon;				// For ImageIcon
import javax.swing.JButton;					// For Button
import javax.swing.JFrame;					// For JFrame
import javax.swing.JLabel;					// For JLabel
import javax.swing.JLayeredPane;			// For JLayeredPane
import javax.swing.JPanel;					// For JPanel


/****************************************************************
 * 
 * Start_Up - Calls the functions that will start up the program.
 * 
****************************************************************/
public class Start_Up
{
	
	/*********************************************************************
	 * 
	 * main - Is used to call the first function to get the program going.
	 * 
	*********************************************************************/
	public static void main(String[] args) 
	{
		
		Splash_Page();

	}

	/************************************************************************************
	 * 
	 * Create_Window - Creates the JFrame that will be used for the splash and home page.
	 * 
	************************************************************************************/
	private static JFrame Create_Window()
	{
		
		int Screen_Width = (int) Consistent_Variables.Held_Variables.Screen_Size.getWidth();	// Holds the max width of users' screen.
		int Screen_Height = Consistent_Variables.Held_Variables.Screen_Height;					// Holds that screen height to be used for all frames.
		String Title = Consistent_Variables.Held_Variables.Title;								// Holds the title of the program.
		
		JFrame F_Window = new JFrame();	
		F_Window.setSize(Screen_Width, Screen_Height);
		F_Window.setTitle(Title);
		F_Window.setResizable(false);
		F_Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		return F_Window;
		
	}
	
	/***************************************************************************
	 * 
	 * Splash_Page - Creates a frame that will display the title of the program.
	 * 
	***************************************************************************/
	private static void Splash_Page() 
	{
		
		JFrame F_Window = Create_Window();		
		
		
		F_Window.add(Create_Splash_Image(F_Window));
		

		F_Window.setVisible(true);	
		
	}
	
	/************************************************************************
	 * 
	 * Create_Splash_Image - Creates the image to be used on the splash page.
	 * 
	************************************************************************/
	private static JLabel Create_Splash_Image(JFrame F_Window)
	{

		String Image_Path = Consistent_Variables.Held_Variables.Image_Path;// Holds the path for the Image folder.
		
		ImageIcon II_Image = new ImageIcon(Image_Path + "Splash Logo 2.png");
		JLabel L_Splash_Image = new JLabel("", II_Image, JLabel.CENTER);

		
		Splash_Image_Action(F_Window, L_Splash_Image);	
		
		
		return L_Splash_Image;
		
	}
	
	/**********************************************************************************************
	 * 
	 * Splash_Image_Action - Create the action listener for the JLabel that holds the splash image.
	 * 
	**********************************************************************************************/
	private static void Splash_Image_Action(JFrame F_Window, JLabel L_Splash_Image)
	{
		
		L_Splash_Image.addMouseListener(new MouseAdapter()
		{// Adds a mouse listener to change over to the home page when the label is clicked on.
					
			@Override
			public void mouseClicked(MouseEvent Clicked)
			{
				
				F_Window.setVisible(false);
				
				
				Home_Page();
						
			}
					
		});	
		
	}

	/************************************************************************************************
	 * 
	 * Home_Page - Displays a JFrame that gives the user buttons to click on to navigate through the
	 *             program.
	 * 
	************************************************************************************************/
	public static void Home_Page()
	{
		
		int Screen_Width = (int) Consistent_Variables.Held_Variables.Screen_Size.getWidth();	// Holds the max width of users' screen.
		int Screen_Height = Consistent_Variables.Held_Variables.Screen_Height;					// Holds that screen height to be used for all frames.
	

		JFrame F_Window = Create_Window();

		
		JLayeredPane LP_Layered_Pane = new JLayeredPane();// This helps so multiple panels can be in the same location.

		
		LP_Layered_Pane.add(Create_Background(Screen_Width, Screen_Height), new Integer(0), 0);
		
		
		JButton B_Option_1 = new JButton("Input Time");
		JButton B_Option_2 = new JButton("List of Accountabilites");
		JButton B_Option_3 = new JButton("Display Averages");
		JButton B_Option_4 = new JButton("Apply Interest (" + "Num" + ")");// THIS WILL DISAPER ON CERTAIN OCCASIONS. Im bebating on how this will be done. Im thinking I dont want this button to be created if im not even going to have this displayed as that would waste time.

		Create_Button_Actions(F_Window, B_Option_1, B_Option_2, B_Option_3, B_Option_4);
		
		
		JPanel P_Button_Panel = new JPanel(new GridBagLayout());
		P_Button_Panel.setBounds(0, 0, Screen_Width, Screen_Height);
		P_Button_Panel.setOpaque(false);// This prevents the button panel from covering the background image.
		
        GridBagConstraints GBC_Grid_Bag = new GridBagConstraints();// This helps center the button panel on the screen.
        
        GBC_Grid_Bag.insets = new Insets(0,10,0,0);		// Left padding
        GBC_Grid_Bag.ipady = 10;						// This makes the buttons taller
        
        P_Button_Panel.add(B_Option_1, GBC_Grid_Bag);        
        P_Button_Panel.add(B_Option_2, GBC_Grid_Bag);
        P_Button_Panel.add(B_Option_3, GBC_Grid_Bag);
        P_Button_Panel.add(B_Option_4, GBC_Grid_Bag);
		
		
		LP_Layered_Pane.add(P_Button_Panel, new Integer(1), 0);
		
		F_Window.add(LP_Layered_Pane);

		
		F_Window.setVisible(true);
		
	}

	/**********************************************************************************************
	 * 
	 * Create_Background - Scales the background to be used on the entire JFrame for the home page.
	 * 
	**********************************************************************************************/
	private static JLabel Create_Background(int Screen_Width, int Screen_Height)
	{
	
		String Image_Path = Consistent_Variables.Held_Variables.Image_Path;// Holds the path for the Image folder.
		
		
		Toolkit T_Tools = Toolkit.getDefaultToolkit();
		Image I_Small_BG = T_Tools.getImage(Image_Path + "Background 4.jpg");
	
		I_Small_BG = I_Small_BG.getScaledInstance(Screen_Width, Screen_Height, Image.SCALE_DEFAULT);   
	
		ImageIcon II_Icon = new ImageIcon(I_Small_BG);
		JLabel L_Scaled_BG = new JLabel("", II_Icon, JLabel.CENTER);
		L_Scaled_BG.setBounds(0, 0, Screen_Width, Screen_Height);
	
	
		return L_Scaled_BG;
	
	}
	
	/****************************************************************************************************
	 * 
	 * Create_Button_Actions - Will give the buttons used in the home page their button listener actions.
	 * 
	****************************************************************************************************/
	private static void Create_Button_Actions(JFrame F_Window, JButton B_One, JButton B_Two, JButton B_Three, JButton B_Four)
	{
		
		B_One.addMouseListener(new MouseAdapter()
		{// Adds a mouse listener to change over to the input time frame.
			
			@Override
			public void mouseClicked(MouseEvent Clicked)
			{
				
				F_Window.setVisible(false);
				
				
				Options.Option_1.Input_Time();
				
			}
		
			
		});
		
		B_Two.addMouseListener(new MouseAdapter()
		{// Adds a mouse listener to change over to the list of accountabilities frame.
			
			@Override
			public void mouseClicked(MouseEvent Clicked)
			{
				
				F_Window.setVisible(false);
				
				
				Options.Option_2.List_Of_Accountabilities();
				
			}
			
		});
		
		B_Three.addMouseListener(new MouseAdapter()
		{// Adds a mouse listener to change over to the displayed averages frame.
			
			@Override
			public void mouseClicked(MouseEvent Clicked)
			{
				
				F_Window.setVisible(false);
				
				
				//Options.Option_3.main(null); //THIS IS FOR TESTING
				
			}
			
		});
		
		B_Four.addMouseListener(new MouseAdapter()
		{// Adds a mouse listener to change over to the applying interest frame.
			
			@Override
			public void mouseClicked(MouseEvent Clicked)
			{
				
				F_Window.setVisible(false);
				
				
				//Options.Option_4.main(null); //THIS IS FOR TESTING
				
			}
			
		});
		
	}

}