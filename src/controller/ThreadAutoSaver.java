package controller;

import javax.swing.JButton;

public class ThreadAutoSaver extends Thread {

	public void run(){
		JButton save = new JButton();
		save.addActionListener(new SaverICS());
		while(true){
			try {
				Thread.sleep(60000);
				save.doClick();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Echec sauvegarde automatique");
			}
		}
	}
}
