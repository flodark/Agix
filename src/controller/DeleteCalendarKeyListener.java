package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import vue.CalendarsFrame;

public class DeleteCalendarKeyListener implements KeyListener {
	@Override
	public void keyPressed(KeyEvent k) {
		
		if(k.getKeyCode()==KeyEvent.VK_DELETE){
			int n = JOptionPane.showConfirmDialog(
		            CalendarsFrame.panel,
		            "Delete this calendar?",
		            "Delete",
		            JOptionPane.YES_NO_OPTION //Button appearing on JOptionpane
		            );
			if(n==0){
				if(SelectEventFromCalendarListener.currentCal!=null && !SelectEventFromCalendarListener.currentCal.equals("")){
					Main.myCals.removeCalendar(SelectEventFromCalendarListener.currentCal);
					RefreshList rl = new RefreshList(true);
					rl.refresh();
				}
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
	}
	@Override
	public void keyTyped(KeyEvent k) {
		
	}
}
