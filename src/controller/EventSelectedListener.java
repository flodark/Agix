package controller;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Component;
import java.awt.Window;

import vue.CalendarsFrame;
import javax.swing.JFrame;

import model.Event;

public class EventSelectedListener implements ListSelectionListener {

	public static Event currentEventSelected = null;
	@Override
	public void valueChanged(ListSelectionEvent ls) {
		JMenuBar jm = new JMenuBar();
		
		JMenu file = new JMenu();
		
		JMenuItem modify= new JMenuItem();
		JMenuItem delete = new JMenuItem();
		
		Window window = SwingUtilities.windowForComponent(CalendarsFrame.panel);
		JFrame frame = new JFrame();
		if (window instanceof JFrame) {
			frame = (CalendarsFrame) window;
		}
		
		jm = frame.getJMenuBar();
		
		for(Component i : jm.getComponents()){
			if(i!=null && i.getName() != null){
				if(i.getName()=="eventMenu")
					file=(JMenu)i;
			}
		}
		
		//manuel....
		modify=file.getItem(1);
		delete=file.getItem(2);
		
		if(((JList)ls.getSource()).isSelectionEmpty()){
			EventSelectedListener.currentEventSelected=null;
			modify.setEnabled(false);
			delete.setEnabled(false);
		}
		else{
			EventSelectedListener.currentEventSelected=(Event)((JList)ls.getSource()).getSelectedValue();
			modify.setEnabled(true);
			delete.setEnabled(true);
		}
	}

}
