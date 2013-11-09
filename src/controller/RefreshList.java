package controller;

import java.awt.Component;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JScrollPane;

import model.CalendarAgix;
import model.Event;

import vue.CalendarsFrame;

public class RefreshList {

	private boolean delete;
	private String annee,mois,jour;
	
	public RefreshList(boolean del){
		this.delete=del;
	}
	
	public RefreshList(String annee, String mois, String jour) {
		this.annee=annee;
		this.mois=mois;
		this.jour=jour;
	}

	public void refresh() {
		Vector<String> listDataCal = new Vector<String>();
		for(CalendarAgix c : Main.myCals.getMap().values()){
			listDataCal.add(c.getName());
		}
		
		Vector<Event> listDataEvent = new Vector<Event>();
		if(!this.delete && !Main.myCals.getMap().isEmpty() && SelectEventFromCalendarListener.currentCal!=null && SelectEventFromCalendarListener.currentCal!="" && !Main.myCals.getCalendar(SelectEventFromCalendarListener.currentCal).getAllEvent().isEmpty()){
			for(Event e : Main.myCals.getCalendar(SelectEventFromCalendarListener.currentCal).getAllEvent()){
				if(this.annee==null || this.annee.equals("") || this.mois==null || this.mois.equals("") || this.jour==null || this.jour.equals(""))
					listDataEvent.add(e);
				else{
					if(e.getDayS().equals(this.jour) && e.getMonthS().equals(this.mois) && e.getYearS().equals(this.annee))
						listDataEvent.add(e);
				}
			}
		}
	
		JList l = null;
		
		for(Component i : CalendarsFrame.panel.getComponents()){
			if(i!=null && i.getName() != null){
				if(i.getName()=="spCal"){
					for(Component j : ((JScrollPane)i).getViewport().getComponents()){
						if(j!=null && j.getName() != null){
							if(j.getName()=="listCalendar"){
								l = ((JList)j);
								l.setListData(listDataCal);
								((JScrollPane)i).setViewportView(l);
							}
						}
					}
				}
				
				if(i.getName()=="spEvent"){
					for(Component j : ((JScrollPane)i).getViewport().getComponents()){
						if(j.getName()=="listEvents"){
							l = ((JList)j);
							l.setListData(listDataEvent);
							((JScrollPane)i).setViewportView(l);
						}
					}
				}
			}
		}
		
	}
}
