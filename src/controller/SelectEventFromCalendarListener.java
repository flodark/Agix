package controller;

import java.util.Vector;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Event;

public class SelectEventFromCalendarListener implements ListSelectionListener {

	public static String currentCal;
	private JList evList;
	
	public SelectEventFromCalendarListener(JList listEvents) {
		// TODO Auto-generated constructor stub
		this.evList=listEvents;
		SelectEventFromCalendarListener.currentCal="";
	}

	@Override
	public void valueChanged(ListSelectionEvent ls) {
		// TODO Auto-generated method stub
		
		// Ajouter les evenements du calendrier dans la jlist a droite
		String s = (String)((JList)ls.getSource()).getSelectedValue();
		if(s!=null && !s.isEmpty()){
			if(!SelectEventFromCalendarListener.currentCal.equals(s)){
				SelectEventFromCalendarListener.currentCal = s;
				
				Vector<Event> v = new Vector<Event>();
				for(Event e : Main.myCals.getCalendar(SelectEventFromCalendarListener.currentCal).getAllEvent()){
					v.add(e);
				}
				this.evList.setListData(v);
				RefreshList rl = new RefreshList(false);
				rl.refresh();
			}
		}
		
		//Activer la fonction creer evenement
	}

}
