package multi_thread;

import java.awt.Color;
import java.util.Timer;


/**
 * 
 * @author Kaish Panjwani
 * @version 30-11-2019
 *
 */


public class Threads extends Thread {
	
	public volatile static boolean will_run; // Public Static Volatile Boolean for controlling the Thread(s) execution(s) from other Classes
	private String status = "Active";
	
	int runTime = (int) ((Math.random()*((5000-1000)+1))+1000); // Random Number Generator for runTime
	int sleepTime = (int) ((Math.random()*((5000-1000)+1))+1000); // Random Number Generator for sleepTime
	Panels a = new Panels(""); // Creating Panels Instance for Every New Threads Instance
    
	Labels stat = new Labels("Status: " + status + " | "); // Creating Labels instance for displaying Thread's Status
	
	
	// Constructor for Threads Instance
	public Threads() {
		
		will_run = true;
		Listeners.counter++;	
		
		Labels num = new Labels("Thread # " + Listeners.counter + " | ");
		Labels run = new Labels("RunTime: " + runTime + " | ");
		Labels sleep = new Labels("SleepTime: " + sleepTime);
		
		a.add(num);
		a.add(stat);
		a.add(run);
		a.add(sleep);
		
		a.setBackground(Color.GREEN);
		Multi_Main.tpanel.add(a);
		
		Multi_Main.tpanel.repaint();
		Multi_Main.tpanel.validate();
		
	}
	
	
	// Overriding run() Method for Extended Threads Class
	
	@Override
	public void run() {
		
		will_run = true;
		
		while (will_run) {
			
			Timer timer = new Timer();
			
			
			// Tasks to execute when the Thread is Active
			status = "Running";
			a.setBackground(Color.GREEN);
			stat.setText("Status: " + status + " | ");
			Multi_Main.tpanel.repaint();
			Multi_Main.tpanel.validate();
			
			
			// TimerTask and Timer initialization for next Loop
			TimerTasks timerTask = new TimerTasks(); // Creating a new TimerTask
			timer.schedule(timerTask,runTime); // Scheduling - Rescheduling Timer
			timerTask.sleep(runTime); // Making the TimerTask Thread sleep
			timer.cancel(); // Canceling or Stopping Timer Instance
			
			
			// Tasks to execute when the Thread Sleeps
			try {
				status = "Paused";
				a.setBackground(Color.RED);
				stat.setText("Status: " + status + " | ");
				Multi_Main.tpanel.repaint();
				Multi_Main.tpanel.validate();
				Threads.sleep(sleepTime);
			} 
			
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
		// When the Thread Exits the Infinite Loop
		status = "Not Active";
		stat.setText("Status: " + status + " | ");
		a.setBackground(Color.GRAY);
		Multi_Main.tpanel.repaint();
		Multi_Main.tpanel.validate();
	}
}
