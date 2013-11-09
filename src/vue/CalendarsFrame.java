package vue;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import model.CalendarAgix;

import controller.DeleteCalendarKeyListener;
import controller.DeleteItemListener;
import controller.EventSelectedListener;
import controller.FiltreActivationListener;
import controller.FiltrerEventListener;
import controller.GoogleAgendaSynchroListener;
import controller.Main;
import controller.SaverICS;
import controller.SelectEventFromCalendarListener;
import controller.ThreadAutoSaver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Vector;

@SuppressWarnings("serial")
public class CalendarsFrame extends JFrame {

	public static JPanel panel = new JPanel();
	private JMenuBar jm = new JMenuBar();
	
	public CalendarsFrame(){
		this.setTitle("Agix - Calendrier"); 
		this.setSize(640,810);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CalendarsFrame.panel.setBackground(Color.white);
		CalendarsFrame.panel.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.setContentPane(CalendarsFrame.panel);
		
		this.startThreadSaver();
		this.buildContent();
	}
	
	private void startThreadSaver() {
		// TODO Auto-generated method stub
		Thread threadSaver = new ThreadAutoSaver();
		threadSaver.start();
	}

	private void buildContent() {
		//DEBUT : 

		//MENU
		this.createMenu();
		
		//LIST
		JCheckBox filtrer = new JCheckBox("Filtrer par date : ");
		filtrer.addActionListener(new FiltreActivationListener());
		CalendarsFrame.panel.add(filtrer);
		
		this.createLists();
	}

	private void createLists() {
		
		Vector<String> dataAnnee=new Vector<String>();
		for(int i=2000;i<=2100;i++){
			dataAnnee.add(""+i);
		}
		JComboBox listAnnee = new JComboBox(dataAnnee);
		JScrollPane spAnnee = new JScrollPane(listAnnee);
		listAnnee.setSelectedIndex(0);
		spAnnee.setName("spAnnee");
		spAnnee.getHorizontalScrollBar().setEnabled(false);
		spAnnee.getVerticalScrollBar().setEnabled(false);
		spAnnee.getViewport().getView().setEnabled(false);
		CalendarsFrame.panel.add(spAnnee);
		
		String[] dataMois = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
		JComboBox listMois = new JComboBox(dataMois);
		listMois.setSelectedIndex(0);
		JScrollPane spMois = new JScrollPane(listMois);
		spMois.setName("spMois");
		spMois.getHorizontalScrollBar().setEnabled(false);
		spMois.getVerticalScrollBar().setEnabled(false);
		spMois.getViewport().getView().setEnabled(false);
		CalendarsFrame.panel.add(spMois);
		
		Vector<String> dataJour=new Vector<String>();
		for(int i=1;i<=31;i++){
			dataJour.add(""+i);
		}
		JComboBox listJour = new JComboBox(dataJour);
		listJour.setSelectedIndex(0);
		JScrollPane spJour = new JScrollPane(listJour);
		spJour.setName("spJour");
		spJour.getHorizontalScrollBar().setEnabled(false);
		spJour.getVerticalScrollBar().setEnabled(false);
		spJour.getViewport().getView().setEnabled(false);
		CalendarsFrame.panel.add(spJour);
		
		listAnnee.addActionListener(new FiltrerEventListener());
		listMois.addActionListener(new FiltrerEventListener());
		listJour.addActionListener(new FiltrerEventListener());
		
		JLabel blank = new JLabel("");
		blank.setPreferredSize(new Dimension(200,10));
		CalendarsFrame.panel.add(blank);
		
		Vector<String> data = new Vector<String>();
		for(CalendarAgix c : Main.myCals.getMap().values()){
			data.add(c.getName());
		}
		TitledBorder titleCalendars = BorderFactory.createTitledBorder("Calendars");
		JList listCalendar = new JList(data); //liste calendars
		listCalendar.setVisibleRowCount(25);
		JScrollPane spCal = new JScrollPane(listCalendar);
		spCal.setName("spCal");
		JList listEvents = new JList(); //liste event
		listEvents.setAutoscrolls(true);
		listEvents.setVisibleRowCount(25);
		JScrollPane spEvent = new JScrollPane(listEvents);
		spEvent.setName("spEvent");
		
		listCalendar.setName("listCalendar");
		spCal.setBorder(titleCalendars);
		spCal.setBackground(Color.white);
		listCalendar.addListSelectionListener(new SelectEventFromCalendarListener(listEvents));
		listCalendar.addKeyListener(new DeleteCalendarKeyListener());
		spCal.setPreferredSize(new Dimension(310,690));
		
		TitledBorder titleEvents = BorderFactory.createTitledBorder("Events");
		listEvents.setName("listEvents");
		spEvent.setBorder(titleEvents);
		spEvent.setBackground(Color.white);
		spEvent.setPreferredSize(new Dimension(310,690));
		listEvents.addListSelectionListener(new EventSelectedListener());
		
		CalendarsFrame.panel.add(spCal);
		CalendarsFrame.panel.add(spEvent);
	}

	private void createMenu() {
		// TODO Auto-generated method stub
		this.jm.setName("jm");
		this.setJMenuBar(this.jm);
		
		JMenu fichier = new JMenu("Fichier");
		fichier.setName("fichier");
		
		JMenuItem newCal = new JMenuItem("Nouveau calendrier");
		newCal.addActionListener(new OuvrirFenetre("CreateNewCalendarFrame"));
		
		JMenuItem importCal = new JMenuItem("Importer un calendrier");
		importCal.addActionListener(new OuvrirFenetre("ImportCalendar"));
		
		JMenuItem save = new JMenuItem("Sauvegarder");
		save.addActionListener(new SaverICS());
		
		JMenuItem sync = new JMenuItem("Synchroniser");
		sync.addActionListener(new GoogleAgendaSynchroListener());
		
		JMenuItem quit = new JMenuItem("Quitter");
		quit.addActionListener(new FermerFenetre(this));
		
		fichier.add(newCal);
		fichier.add(importCal);
		fichier.add(sync);
		fichier.add(save);
		fichier.add(quit);
		jm.add(fichier);
		
		JMenu event = new JMenu("Evènement");
		event.setName("eventMenu");
		JMenuItem createEvent = new JMenuItem("Créer un évènement");
		createEvent.setName("createEvent");
		createEvent.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EventFrame ef = new EventFrame(EventFrame.CREATE);
				ef.open();
			}
		});
		//createEvent.addActionListener(new OuvrirFenetre("EventFrame"));
		createEvent.setEnabled(false);
		
		JMenuItem modifyEvent = new JMenuItem("Modifier l'évènement sélectionné");
		modifyEvent.setName("modifyEvent");
		modifyEvent.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EventFrame ef = new EventFrame(EventFrame.MODIFY);
				ef.open();
			}
		});
		modifyEvent.setEnabled(false);
		
		JMenuItem deleteEvent = new JMenuItem("Supprimer l'évènement sélectionné");
		deleteEvent.setName("deleteEvent");
		deleteEvent.addActionListener(new DeleteItemListener());
		deleteEvent.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_DELETE));
		deleteEvent.setEnabled(false);
		
		event.add(createEvent);
		event.add(modifyEvent);
		event.add(deleteEvent);
		jm.add(event);
		
		JMenu param = new JMenu("Paramètres de connexion");
		param.setName("param");
		
		JMenuItem definirParam = new JMenuItem("Définir les paramètres");
		definirParam.setName("definirParam");
		definirParam.addActionListener(new OuvrirFenetre("ParametreConnexion"));
		param.add(definirParam);
		
		jm.add(param);
	}

	public JMenuBar getJMenuBar(){
		return this.jm;
	}
	
	public void open(){
	    this.setVisible(true);
	}
}
