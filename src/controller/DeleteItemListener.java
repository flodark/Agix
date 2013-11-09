package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import model.Event;

import vue.CalendarsFrame;

public class DeleteItemListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		int n = JOptionPane.showConfirmDialog(
	            CalendarsFrame.panel,
	            "Delete this event?",
	            "Delete",
	            JOptionPane.YES_NO_OPTION //Button appearing on JOptionpane
	            );
		if(n==0){
			JList le = null;
			
			for(Component i : CalendarsFrame.panel.getComponents()){
				if(i!=null && i.getName() != null){
					if(i.getName()=="spEvent"){
						for(Component j : ((JScrollPane)i).getViewport().getComponents()){
							if(j!=null && j.getName() != null){
								if(j.getName()=="listEvents"){
									le=(JList)j;
								}
							}
						}
					}
				}
			}
			
			Main.myCals.getCalendar(SelectEventFromCalendarListener.currentCal).removeEvent(((Event)le.getSelectedValue()));
			RefreshList rl = new RefreshList(false);
			rl.refresh();
		}
	}

}
