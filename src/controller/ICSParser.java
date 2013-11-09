package controller;

import java.awt.Window;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import vue.CalendarsFrame;

import model.CalendarAgix;
import model.Event;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;


public class ICSParser {
   
	//Initialisation des constantes

    public static final String DTSTART = "DTSTART";
    public static final String DTEND = "DTEND";
    public static final String SUMMARY = "SUMMARY";
    public static final String LOCATION = "LOCATION";
    public static final String DESCRIPTION = "DESCRIPTION";
    
    private String uri, nameCal;
    private CalendarAgix cal;

    
    public ICSParser(String uri, String nameCal){
    	this.uri = uri;
    	this.nameCal=nameCal;
    	this.cal= new CalendarAgix(this.nameCal);
    }
    
    public void parse() {
        try {
            //Init
        	CalendarBuilder builder = new CalendarBuilder();
        	Calendar calendar;
            //Mise en place du stream pour la récupération du fichier ICS
            if(uri.startsWith("http") || uri.startsWith("ftp")){
            	final InputStream stream = new URL(uri).openStream();// depuis internet
            	calendar = builder.build(stream);
            }
            else{
            	FileInputStream stream = new FileInputStream(uri);// depuis fichier local
            	calendar = builder.build(stream);
            }
            //Consommation du Stream et remplissage de lobjet calendar
            
            //Parcour du calendar pour récuperer les évenements
            for (Iterator<?> it = calendar.getComponents().iterator(); it.hasNext();) {
                Component component = (Component) it.next();
                //Récupération de la date de levènement
                //à travers la propriété DTSTART
                final String dtStartValue = component.getProperty(DTSTART).getValue();
                final String dtEndValue = component.getProperty(DTEND).getValue();
                //Récupération du déscriptif de levènement
                //à travers la propriété SUMMARY
                final String summary = component.getProperty(SUMMARY).getValue();
                final String location = component.getProperty(LOCATION).getValue();
                final String description = component.getProperty(DESCRIPTION).getValue();
                // Recuperer valeur debut event
                String anneedeb=dtStartValue.substring(0,4);
                String moideb=dtStartValue.substring(4,6);
                String jourdeb=dtStartValue.substring(6,8);                
                String heuredeb = dtStartValue.substring(9,11);
                String mindeb = dtStartValue.substring(11,13);

                /*Date dateEventDeb = (new SimpleDateFormat(pattern)).parse(dtStartValue);
                //Converstion de la date dans un format plus convivial
                String datedeb = (new SimpleDateFormat(DD_MM_YYYY)).format(dateEventDeb);
*/
                // Recuperer valeur fin event
                
                String heurefin = dtEndValue.substring(9,11);
                String minfin = dtEndValue.substring(11,13);

               
                /*Date dateEventFin = (new SimpleDateFormat(pattern)).parse(dtEndValue);
                //Converstion de la date dans un format plus convivial
                String datefin = (new SimpleDateFormat(DD_MM_YYYY)).format(dateEventFin);
                */
                //Affichage de notre message
                Event ev=new Event(jourdeb,moideb,anneedeb,heuredeb,mindeb,heurefin,minfin,summary,location,description);
                cal.addEvent(ev);
            }
            this.validateParsing();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	private void validateParsing() {
		// TODO Auto-generated method stub
		Main.myCals.addCalendar(this.nameCal, this.cal);
		
		JMenuBar jm = new JMenuBar();
		
		JMenu file = new JMenu();
		
		JMenuItem create= new JMenuItem();
		
		Window window = SwingUtilities.windowForComponent(CalendarsFrame.panel);
		JFrame frame = new JFrame();
		if (window instanceof JFrame) {
			frame = (CalendarsFrame) window;
		}
		
		jm = frame.getJMenuBar();
		
		for(java.awt.Component i : jm.getComponents()){
			if(i!=null && i.getName() != null){
				if(i.getName()=="eventMenu")
					file=(JMenu)i;
			}
		}
		
		//manuel....
		create=file.getItem(0);
		create.setEnabled(true);
		
		
        RefreshList rl = new RefreshList(false);
        rl.refresh();
        System.out.println("Parsing de "+this.nameCal+" terminé avec succès !");
	}
}