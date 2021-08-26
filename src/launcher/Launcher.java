package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	
	public static void main(String [] args) {
		
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SimplePresentationScreen frame = new SimplePresentationScreen(new Student(120314, "Ferrante", "Agustin Pedro", "agus_p3@hotmail.com",
						"https://github.com/AgusF22", null));
				frame.setVisible(true);
			}
		});
	}
}