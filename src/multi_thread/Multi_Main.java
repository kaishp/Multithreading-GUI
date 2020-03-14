package multi_thread;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
//import java.awt.Dimension;

/**
 * 
 * @author Kaish Panjwani
 * @version 30-11-2019
 *
 */

public class Multi_Main {
	
	
	// Making instances below Public and Static to make it accessible from other Classes
	
	public static Panels tpanel = new Panels("Thread(s) Panel"); // Creating Panels Instance for Thread(s) Panel
	public static Labels num = new Labels("Number of Threads: " + 0); // Creating Labels Instance for displaying Number of Threads
	
	
	// Main Method
	
	public static void main(String[] args) {		
		
		generate_GUI();
		
	}
	
	
	// Private Method to Generate the GUI
	
	private static void generate_GUI() {
		
		// Creating the Main Panel
		Panels mpanel = new Panels("Main Panel");
		mpanel.setLayout(new GridLayout(1,2));
//		mpanel.setPreferredSize(new Dimension(1000,500));
		
		// Creating a Button Panel
		Panels bpanel = new Panels("Button Panel");
		bpanel.setLayout(new GridLayout(6,2,10,10));
		bpanel.setBorder(BorderFactory.createEmptyBorder(90, 40, 0, 40));
//		bpanel.setPreferredSize(new Dimension(300,500));
		
		
		// Creating a Thread(s) Panel
//		Panels tpanel = new Panels("Thread(s) Panel");
		tpanel.setLayout(new GridLayout(6,1,5,5));
		tpanel.setBorder(BorderFactory.createEmptyBorder(150, 40, 40, 40));
//		tpanel.setPreferredSize(new Dimension(700,500));
				
			
		// Creating Buttons Instances
		Buttons add = new Buttons("Add a Thread");
		add.setBounds(100, 100, 100, 80);
		Buttons delete = new Buttons("Delete a Thread");
		
				
		// Declaring Listeners Object
		Listeners add_li = new Listeners();
		Listeners.DeleteButtonListener delete_li = add_li.new DeleteButtonListener();
			
				
		// Adding ActionListeners to Buttons		
		add.addActionListener(add_li);
		delete.addActionListener(delete_li);
			
				
		// Adding Instances on Button Panel
		bpanel.add(num);
		bpanel.add(add);
		bpanel.add(delete);
			
				
		// Adding Sub-Panels on Main Panel
		mpanel.add(bpanel, BorderLayout.WEST);
		mpanel.add(tpanel, BorderLayout.EAST);
			
				
		// Setting up the Main Frame
		Frames thread = new Frames("Thread Tester"); // Creating a Frames Object
		thread.setContentPane(mpanel); // Adding Main Panel to Frames as Content Pane
		thread.setSize(1000, 500); // Setting Size of Frame
		thread.setDefaultCloseOperation(Frames.EXIT_ON_CLOSE); // Setting up default action when exit button is clicked
		thread.setVisible(true); // Frame is now Visible
	}	
}
