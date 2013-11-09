package model;

public class Event {
	
	private String dayS, monthS, yearS;
	private String hourS, minuteS, secondS, hourE, minuteE, secondE;
	private String summary, location, description;
	
	public Event(String dayS, String monthS, String yearS, String hourS, String minuteS, String hourE,
			String minuteE, String summary, String location,
			String description) {
		super();
		this.dayS = dayS;
		this.monthS = monthS;
		this.yearS = yearS;
		this.hourS = hourS;
		this.minuteS = minuteS;
		this.secondS = "00";
		this.hourE = hourE;
		this.minuteE = minuteE;
		this.secondE = "00";
		this.summary = summary;
		this.location = location;
		this.description = description;
	}

	public String getDayS() {
		return dayS;
	}

	public void setDayS(String dayS) {
		this.dayS = dayS;
	}

	public String getMonthS() {
		return monthS;
	}

	public void setMonthS(String monthS) {
		this.monthS = monthS;
	}

	public String getHourS() {
		return hourS;
	}

	public void setHourS(String hourS) {
		this.hourS = hourS;
	}

	public String getMinuteS() {
		return minuteS;
	}

	public void setMinuteS(String minuteS) {
		this.minuteS = minuteS;
	}

	public String getSecondS() {
		return secondS;
	}

	public void setSecondS(String secondS) {
		this.secondS = secondS;
	}

	public String getHourE() {
		return hourE;
	}

	public void setHourE(String hourE) {
		this.hourE = hourE;
	}

	public String getMinuteE() {
		return minuteE;
	}

	public void setMinuteE(String minuteE) {
		this.minuteE = minuteE;
	}

	public String getSecondE() {
		return secondE;
	}

	public void setSecondE(String secondE) {
		this.secondE = secondE;
	}

	public String getYearS() {
		return yearS;
	}

	public void setYearS(String yearS) {
		this.yearS = yearS;
	}
	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString(){
		return this.summary;
	}
	
	public String toSave(){
		String event = "";
		String entete = "BEGIN:VEVENT\n";
		event += entete;
		
		String infos = 		
		"DTSTART:"+this.yearS+this.monthS+this.dayS+"T"+this.hourS+this.minuteS+this.secondS+"Z\n"+
		"DTEND:"+this.yearS+this.monthS+this.dayS+"T"+this.hourE+this.minuteE+this.secondE+"Z\n"+
		"SUMMARY:"+this.summary+"\n"+
		"LOCATION:"+this.location+"\n"+
		"DESCRIPTION:"+this.description+"\n";
		event += infos;
		
		String footer = "END:VEVENT\n";
		event += footer;
		
		return event;
	}
}