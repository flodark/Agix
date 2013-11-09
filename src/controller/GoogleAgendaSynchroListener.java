package controller;
/* Copyright (c) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.data.extensions.Recurrence;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.InvalidEntryException;
import com.google.gdata.util.ServiceException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

import vue.CalendarsFrame;
import vue.WaitSynchroFrame;

import model.CalendarAgix;
import model.Event;

public class GoogleAgendaSynchroListener implements ActionListener{

// The base URL for a user's calendar metafeed (needs a username appended).
private static final String METAFEED_URL_BASE = 
	"https://www.google.com/calendar/feeds/";
  
// The string to add to the user's metafeedUrl to access the event feed for
// their primary calendar.
private static final String EVENT_FEED_URL_SUFFIX = "/private/full";

// The URL for the metafeed of the specified user.
// (e.g. http://www.google.com/feeds/calendar/jdoe@gmail.com)
@SuppressWarnings("unused")
private static URL metafeedUrl = null;

// The URL for the event feed of the specified user's primary calendar.
// (e.g. http://www.googe.com/feeds/calendar/jdoe@gmail.com/private/full)
private static URL eventFeedUrl = null;

	private static CalendarEventEntry createEvent(CalendarService service, Event e)
			throws ServiceException, IOException {
		CalendarEventEntry myEntry = new CalendarEventEntry();
		
		myEntry.setTitle(new PlainTextConstruct(e.getSummary()));
		myEntry.setContent(new PlainTextConstruct(e.getDescription()));
		myEntry.setQuickAdd(false);
		
		String recurData = "DTSTART:"+e.getYearS()+e.getMonthS()+e.getDayS()+"T"+e.getHourS()+e.getMinuteS()+e.getSecondS()+"Z\r\n" 
				+ "DTEND:"+e.getYearS()+e.getMonthS()+e.getDayS()+"T"+e.getHourE()+e.getMinuteE()+e.getSecondE()+"Z\r\n";
		
		// If a recurrence was requested, add it. Otherwise, set the
		// time (the current date and time) and duration (30 minutes)
		// of the event.
	
		Recurrence recur = new Recurrence();
		recur.setValue(recurData);
		myEntry.setRecurrence(recur);
		
		// Send the request and receive the response:
		return service.insert(eventFeedUrl, myEntry);
	}
  
  	@Override
	public void actionPerformed(ActionEvent arg0) {
	
  		if(!Main.myCals.getMap().isEmpty()){
  		
  			WaitSynchroFrame wsf = new WaitSynchroFrame();
			wsf.open();
			wsf.setAlwaysOnTop(true);
  			if(!TestCon.test()){
  				wsf.close();
  				JOptionPane.showMessageDialog(
			            CalendarsFrame.panel,
			            "Check your proxy parameters. (Time out)",
			            "Bad Proxy Parameters.",
			            JOptionPane.ERROR_MESSAGE //Button appearing on JOptionpane
			            );
  				return;
  			}
			CalendarService myService = new CalendarService("");
			
			try {
				metafeedUrl = new URL(METAFEED_URL_BASE + Main.paramConn.getUserGoogle());
				eventFeedUrl = new URL(METAFEED_URL_BASE + Main.paramConn.getUserGoogle()+EVENT_FEED_URL_SUFFIX);
			} catch (MalformedURLException e) {
				// Bad URL
				System.err.println("Uh oh - you've got an invalid URL.");
				e.printStackTrace();
				return;
			}
			
			try {
				myService.setUserCredentials(Main.paramConn.getUserGoogle(), Main.paramConn.getPassGoogle());
				// Demonstrate retrieving a list of the user's calendars.
				/*
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
				for(CalendarAgix c : Main.myCals.getMap().values()){
					for(Event e : c.getAllEvent()){
						createEvent(myService,e);
					}
				}
				wsf.close();
				JOptionPane.showMessageDialog(
			            CalendarsFrame.panel,
			            "Synchronization ended with no error.",
			            "OK",
			            JOptionPane.INFORMATION_MESSAGE //Button appearing on JOptionpane
			            );
				
			} catch (IOException e) {
				// Communications error
				wsf.close();
				JOptionPane.showMessageDialog(
			            CalendarsFrame.panel,
			            "Connection to Google Agenda failed, check your internet connection or proxy parameters.",
			            "Connection failed.",
			            JOptionPane.ERROR_MESSAGE //Button appearing on JOptionpane
			            );
			} catch (AuthenticationException e){
				wsf.close();
				JOptionPane.showMessageDialog(
			            CalendarsFrame.panel,
			            "Google login and/or password incorrect(s).",
			            "Bad identifiants",
			            JOptionPane.ERROR_MESSAGE //Button appearing on JOptionpane
			            );
			} catch (InvalidEntryException e){
				wsf.close();
				JOptionPane.showMessageDialog(
			            CalendarsFrame.panel,
			            "There are some malformed events in the eventdata set.",
			            "Bad Event",
			            JOptionPane.ERROR_MESSAGE //Button appearing on JOptionpane
			            );
			} catch (ServiceException e) {
				// Server side error
				wsf.close();
				JOptionPane.showMessageDialog(
			            CalendarsFrame.panel,
			            "The server had a problem handling your request.",
			            "Server failure",
			            JOptionPane.ERROR_MESSAGE //Button appearing on JOptionpane
			            );
			}
		}
  	}
}