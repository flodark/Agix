package model;

import java.util.ArrayList;
import java.util.List;

public class CalendarAgix {

	private String name;
	private List<Event> listEvent; 
	
	public CalendarAgix(String name){
		this.name = name;
		this.listEvent = new ArrayList<Event>();
	}
	
	public CalendarAgix(String name,ArrayList<Event> l){
		this.name = name;
		this.listEvent = l;
	}
	
	@Override
	public String toString(){
		String icsfile = "";
		String entete = "BEGIN:VCALENDAR\nVERSION:2.0\n";
		icsfile += entete;
		for(Event e : this.listEvent){
			icsfile += e.toSave();
		}
		String footer = "END:VCALENDAR";
		icsfile += footer;
		return icsfile;
	}

	public void addEvent(Event ev) {
		// TODO Auto-generated method stub
		this.listEvent.add(ev);
	}
	
	public void removeEvent(Event ev){
		this.listEvent.remove(ev);
	}
	
	public ArrayList<Event> getAllEvent(){
		return (ArrayList<Event>) this.listEvent;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
