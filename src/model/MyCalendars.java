package model;

import java.util.HashMap;
import java.util.Map;

public class MyCalendars {

	private Map<String,CalendarAgix> myCals;

	public MyCalendars() {
		super();
		this.myCals = new HashMap<String,CalendarAgix>();
	}
	
	public MyCalendars(HashMap<String,CalendarAgix> myCals) {
		super();
		this.myCals = myCals;
	}
	
	public void addCalendar(String n, CalendarAgix c){
			this.myCals.put(n, c);
	}
	
	public void removeCalendar(String n){
		this.myCals.remove(n);
	}
	
	public CalendarAgix getCalendar(String n){
		return this.myCals.get(n);
	}
	
	public Map<String,CalendarAgix> getMap(){
		return this.myCals;
	}
}
