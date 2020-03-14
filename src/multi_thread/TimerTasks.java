package multi_thread;

import java.util.TimerTask;


/**
 * 
 * @author Kaish Panjwani
 * @version 30-11-2019
 *
 */


public class TimerTasks extends TimerTask { // Extends TimerTasks Class with TimerTask Class

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

	public void sleep(int runTime) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(runTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
