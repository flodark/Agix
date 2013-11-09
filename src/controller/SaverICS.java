package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;

import model.CalendarAgix;

public class SaverICS implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Writer fstream, out;
		Calendar cal = Calendar.getInstance();
		for(CalendarAgix c : Main.myCals.getMap().values()){
			try {
				fstream = new FileWriter("["+cal.get(Calendar.DAY_OF_MONTH)+"-"+(cal.get(Calendar.MONTH)+1)+"]_"+c.getName()+".ics");
				out = new BufferedWriter(fstream);
				out.write(c.toString());
				out.close();
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
	}

}
