package multi_thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 
 * @author Kaish Panjwani
 * @version 30-11-2019
 *
 */


public class Listeners implements ActionListener {
	
	private int i;	// Private counter for Labels for Number of Thread count
	public static int counter; // Public Static counter for Threads Class
	
	//ActionListener for Add New Thread Button
	@Override
	public void actionPerformed(ActionEvent e) {
		i++; // Incrementing to Number of Threads
		Multi_Main.num.setText("Number of Threads: " + i); // Updating Number of Threads Active Labels
		Threads x = new Threads(); // Creating a new Threads Instance
		Multi_Main.tpanel.revalidate(); // Updating Validation(s) for Thread(s) Panel
		Multi_Main.tpanel.repaint(); // Updating Paint for Thread(s) Panel
		x.start(); // Starting the Thread
		
	}
	
	
	class DeleteButtonListener implements ActionListener {
		
		//ActionListener for Delete Thread Button
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (i > 0) { // Will only run if more than 0 thread exists
				Threads.will_run = false; // Stopping Thread by changing value of Volatile Boolean value
				i--; // Decrementing to Number of Threads
				Multi_Main.tpanel.remove(0); // Removing the oldest A Panel from the Thread(s) Panel
				Multi_Main.tpanel.revalidate(); // Updating Validation(s) for Thread(s) Panel
				Multi_Main.tpanel.repaint(); // Updating Paint for Thread(s) Panel
				Multi_Main.num.setText("Number of Threads: " + i); // Updating Number of Threads Active Labels
				
				
				// Pausing Threads for 50 milliseconds to avoid glitches
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				Threads.will_run = true; // Restarting run() for Threads after deletion of one Thread
			}
		}
	}
}