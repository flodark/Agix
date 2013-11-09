package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import vue.EventFrame;

import model.Event;

public class ManageEventListener implements ActionListener {

	private JPanel j;
	private String dayS, monthS, yearS;
	private String hourS, minuteS, hourE, minuteE;
	private String summary, location, description;
	
	public ManageEventListener(JPanel jp){
		this.j=jp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for(Component i : j.getComponents()){
			if(i!=null && i.getName() != null){
					if(i.getName()=="jourDebVal"){
						if(((JTextField)i).getText().length()==1)
							this.dayS="0"+((JTextField)i).getText();
						else
							this.dayS=((JTextField)i).getText();
					}
					if(i.getName()=="moisDebVal"){
						if(((JTextField)i).getText().length()==1)
							this.monthS="0"+((JTextField)i).getText();
						else
							this.monthS=((JTextField)i).getText();
					}
					if(i.getName()=="anneeDebVal")
						this.yearS=((JTextField)i).getText();
					if(i.getName()=="heureDebVal"){
						if(((JTextField)i).getText().length()==1)
							this.hourS="0"+((JTextField)i).getText();
						else
							this.hourS=((JTextField)i).getText();
					}
					if(i.getName()=="minuteDebVal"){
						if(((JTextField)i).getText().length()==1)
							this.minuteS="0"+((JTextField)i).getText();
						else
							this.minuteS=((JTextField)i).getText();
					}
					if(i.getName()=="heureFinVal"){
						if(((JTextField)i).getText().length()==1)
							this.hourE="0"+((JTextField)i).getText();
						else
							this.hourE=((JTextField)i).getText();
					}
					if(i.getName()=="minuteFinVal"){
						if(((JTextField)i).getText().length()==1)
							this.minuteE="0"+((JTextField)i).getText();
						else
							this.minuteE=((JTextField)i).getText();
					}
					if(i.getName()=="sumVal")
						this.summary=((JTextField)i).getText();
					if(i.getName()=="locVal")
						this.location=((JTextField)i).getText();
					if(i.getName()=="descVal")
						this.description=((JTextField)i).getText();
			}
		}
		
		if(this.summary==null || this.summary.equals("")){
			this.summary="Event";
		}
		Event ev = new Event(this.dayS,this.monthS,this.yearS,this.hourS,this.minuteS,this.hourE,this.minuteE,this.summary,this.location,this.description);
		if(EventSelectedListener.currentEventSelected==null || EventFrame.mode==EventFrame.CREATE){
			Main.myCals.getCalendar(SelectEventFromCalendarListener.currentCal).addEvent(ev);
		}else{
			Main.myCals.getCalendar(SelectEventFromCalendarListener.currentCal).removeEvent(EventSelectedListener.currentEventSelected);
			Main.myCals.getCalendar(SelectEventFromCalendarListener.currentCal).addEvent(ev);
		}
		RefreshList rl = new RefreshList(false);
		rl.refresh();
	}

}
