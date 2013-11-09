package controller;

import vue.CalendarsFrame;
import vue.ImageIntro;
import model.MyCalendars;
import model.ParamConnect;

public class Main {

	/**
	 * @param args
	 */
	public static MyCalendars myCals = new MyCalendars();
	public static ParamConnect paramConn = new ParamConnect("","","","");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageIntro img = new ImageIntro();
		img.open();
		try {
		    Thread.sleep(3000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		img.close();
		CalendarsFrame mainFrame = new CalendarsFrame();
		mainFrame.open();
	}

}
