package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EventSelectedListener;
import controller.ManageEventListener;

@SuppressWarnings("serial")
public class EventFrame extends JFrame{

	public static final int CREATE = 0;
	public static final int MODIFY = 1;
	public static int mode = 0;
	private JPanel panel = new JPanel();
	
	public EventFrame(int m){
		
		super();
		EventFrame.mode=m;
		this.setTitle("Agix"); 
		this.setSize(500,200);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.panel.setLayout(new GridBagLayout());
		this.panel.setBackground(Color.white);
		this.setContentPane(this.panel);
		
		this.buildContent();
	}


	private void buildContent() {

		JLabel dateDeb = new JLabel("Date début (JJ - MM - AAAA) :");
		dateDeb.setName("dateDeb");
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridx=0;
		gbc1.gridy=0;
		gbc1.anchor=GridBagConstraints.WEST;
		this.panel.add(dateDeb,gbc1);
		
		JTextField jourDebVal = new JTextField();
		jourDebVal.setName("jourDebVal");
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx=1;
		gbc2.gridy=0;
		gbc2.weightx=1;
		gbc2.fill=GridBagConstraints.HORIZONTAL;
		this.panel.add(jourDebVal,gbc2);
		
		JTextField moisDebVal = new JTextField();
		moisDebVal.setName("moisDebVal");
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.gridx=2;
		gbc3.gridy=0;
		gbc3.weightx=1;
		gbc3.fill=GridBagConstraints.HORIZONTAL;
		this.panel.add(moisDebVal,gbc3);
		
		JTextField anneeDebVal = new JTextField();
		anneeDebVal.setName("anneeDebVal");
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.gridx=3;
		gbc4.gridy=0;
		gbc4.weightx=1;
		gbc4.fill=GridBagConstraints.HORIZONTAL;
		this.panel.add(anneeDebVal,gbc4);
		
		JLabel heureDeb = new JLabel("Heure de début (HH - MM) :");
		heureDeb.setName("heureDeb");
		GridBagConstraints gbc5 = new GridBagConstraints();
		gbc5.gridx=0;
		gbc5.gridy=1;
		gbc5.anchor=GridBagConstraints.WEST;
		this.panel.add(heureDeb,gbc5);
		
		JTextField heureDebVal = new JTextField();
		heureDebVal.setName("heureDebVal");
		GridBagConstraints gbc6 = new GridBagConstraints();
		gbc6.gridx=1;
		gbc6.gridy=1;
		gbc6.weightx=1;
		gbc6.fill=GridBagConstraints.HORIZONTAL;
		this.panel.add(heureDebVal,gbc6);
		
		JTextField minuteDebVal = new JTextField();
		minuteDebVal.setName("minuteDebVal");
		GridBagConstraints gbc7 = new GridBagConstraints();
		gbc7.gridx=2;
		gbc7.gridy=1;
		gbc7.weightx=1;
		gbc7.fill=GridBagConstraints.HORIZONTAL;
		this.panel.add(minuteDebVal,gbc7);
		
		JLabel heureFin = new JLabel("Heure de fin (HH - MM) :");
		heureFin.setName("heureFin");
		GridBagConstraints gbc8 = new GridBagConstraints();
		gbc8.gridx=0;
		gbc8.gridy=2;
		gbc8.anchor=GridBagConstraints.WEST;
		this.panel.add(heureFin,gbc8);
		
		JTextField heureFinVal = new JTextField();
		heureFinVal.setName("heureFinVal");
		GridBagConstraints gbc9 = new GridBagConstraints();
		gbc9.gridx=1;
		gbc9.gridy=2;
		gbc9.weightx=1;
		gbc9.fill=GridBagConstraints.HORIZONTAL;
		this.panel.add(heureFinVal,gbc9);
		
		JTextField minuteFinVal = new JTextField();
		minuteFinVal.setName("minuteFinVal");
		GridBagConstraints gbc10 = new GridBagConstraints();
		gbc10.gridx=2;
		gbc10.gridy=2;
		gbc10.weightx=1;
		gbc10.fill=GridBagConstraints.HORIZONTAL;
		this.panel.add(minuteFinVal,gbc10);
		
		JLabel sum = new JLabel("Titre : ");
		sum.setName("sum");
		GridBagConstraints gbc11 = new GridBagConstraints();
		gbc11.gridx=0;
		gbc11.gridy=3;
		gbc11.anchor=GridBagConstraints.WEST;
		this.panel.add(sum,gbc11);
		
		JTextField sumVal = new JTextField();
		sumVal.setName("sumVal");
		GridBagConstraints gbc12 = new GridBagConstraints();
		gbc12.gridx=1;
		gbc12.gridy=3;
		gbc12.weightx=1;
		gbc12.gridwidth=3;
		gbc12.fill=GridBagConstraints.HORIZONTAL;
		this.panel.add(sumVal,gbc12);
		
		JLabel desc = new JLabel("Description : ");
		desc.setName("desc");
		GridBagConstraints gbc13 = new GridBagConstraints();
		gbc13.gridx=0;
		gbc13.gridy=4;
		gbc13.anchor=GridBagConstraints.WEST;
		this.panel.add(desc,gbc13);
		
		JTextField descVal = new JTextField();
		descVal.setName("descVal");
		GridBagConstraints gbc14 = new GridBagConstraints();
		gbc14.gridx=1;
		gbc14.gridy=4;
		gbc14.weightx=1;
		gbc14.gridwidth=3;
		gbc14.fill=GridBagConstraints.HORIZONTAL;
		this.panel.add(descVal,gbc14);
		
		JLabel loc = new JLabel("Localisation : ");
		loc.setName("loc");
		GridBagConstraints gbc15 = new GridBagConstraints();
		gbc15.gridx=0;
		gbc15.gridy=5;
		gbc15.anchor=GridBagConstraints.WEST;
		this.panel.add(loc,gbc15);
		
		JTextField locVal = new JTextField();
		locVal.setName("locVal");
		GridBagConstraints gbc16 = new GridBagConstraints();
		gbc16.gridx=1;
		gbc16.gridy=5;
		gbc16.weightx=1;
		gbc16.gridwidth=3;
		gbc16.fill=GridBagConstraints.HORIZONTAL;
		this.panel.add(locVal,gbc16);
		
		JButton valider = new JButton("Créer");
		
		//INITIALISATION DES JTEXTFIELDS
		if(EventSelectedListener.currentEventSelected!=null && EventFrame.mode==1){
			jourDebVal.setText(EventSelectedListener.currentEventSelected.getDayS());
			moisDebVal.setText(EventSelectedListener.currentEventSelected.getMonthS());
			anneeDebVal.setText(EventSelectedListener.currentEventSelected.getYearS());
			heureDebVal.setText(EventSelectedListener.currentEventSelected.getHourS());
			minuteDebVal.setText(EventSelectedListener.currentEventSelected.getMinuteS());
			heureFinVal.setText(EventSelectedListener.currentEventSelected.getHourE());
			minuteFinVal.setText(EventSelectedListener.currentEventSelected.getMinuteE());
			sumVal.setText(EventSelectedListener.currentEventSelected.getSummary());
			descVal.setText(EventSelectedListener.currentEventSelected.getDescription());
			locVal.setText(EventSelectedListener.currentEventSelected.getLocation());
			valider.setText("Modifier");
		}else{
			jourDebVal.setText("");
			moisDebVal.setText("");
			anneeDebVal.setText("");
			heureDebVal.setText("");
			minuteDebVal.setText("");
			heureFinVal.setText("");
			minuteFinVal.setText("");
			sumVal.setText("");
			descVal.setText("");
			locVal.setText("");
		}
		valider.addActionListener(new ManageEventListener(this.panel));
		valider.addActionListener(new FermerFenetre(this));
		valider.setPreferredSize(new Dimension(100,25));
		GridBagConstraints gbc20 = new GridBagConstraints();
		gbc20.gridx=4;
		gbc20.gridy=6;
		//gbc20.insets=new Insets(45,0,0,20);
		gbc20.anchor=GridBagConstraints.SOUTHEAST;
		this.panel.add(valider,gbc20);
	}

	public void open(){
	    this.setVisible(true);
	}
}
