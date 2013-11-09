package vue;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ParserListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ImportCalendar extends JFrame{

	private JPanel panel;
	
	public ImportCalendar(){
		super();
		this.panel = new JPanel();
		
		this.setTitle("Agix"); 
		this.setSize(500,150);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.panel.setLayout(new GridBagLayout());
		this.panel.setBackground(Color.white);
		this.setContentPane(this.panel);
		
		this.buildContent();
	}
	
	private void buildContent() {
		JLabel nomCal = new JLabel("Nom du calendrier pour agix : ");
		nomCal.setName("nomCal");
		GridBagConstraints gbc6 = new GridBagConstraints();
		gbc6.gridx=0;
		gbc6.gridy=0;
		gbc6.anchor=GridBagConstraints.WEST;
		this.panel.add(nomCal,gbc6);
		
		final JTextField nomCalVal = new JTextField();
		nomCalVal.setName("nomCalVal");
		nomCalVal.setText("MyCalendar");
		GridBagConstraints gbc7 = new GridBagConstraints();
		gbc7.gridx=1;
		gbc7.gridy=0;
		gbc7.weightx=1;
		gbc7.fill=GridBagConstraints.HORIZONTAL;
		this.panel.add(nomCalVal,gbc7);
		
		JLabel uriFichier = new JLabel("Lien (http/ftp/local) : ");
		uriFichier.setName("j2_lab");
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridx=0;
		gbc1.gridy=1;
		gbc1.anchor=GridBagConstraints.WEST;
		this.panel.add(uriFichier,gbc1);
		
		final JTextField url = new JTextField();
		url.setName("uri");
		url.setText("");
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx=1;
		gbc2.gridy=1;
		gbc2.weightx=1;
		gbc2.fill=GridBagConstraints.HORIZONTAL;
		this.panel.add(url,gbc2);
		
		JButton button = new JButton("Parcourir...");
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
		        JFileChooser chooser = new JFileChooser();
		        FileFilter filter = new FileNameExtensionFilter("ICS file", "ics");
		        chooser.addChoosableFileFilter(filter);
		        chooser.setFileHidingEnabled(true);
		        chooser.setAcceptAllFileFilterUsed(false);
		        int returnVal = chooser.showDialog(panel, "Choisir");
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		        	url.setText(chooser.getSelectedFile().getPath());
		        }
		    }
		});
		button.setPreferredSize(new Dimension(30,20));
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.gridx=2;
		gbc4.gridy=1;
		gbc4.weightx=0;
		gbc4.fill=GridBagConstraints.HORIZONTAL;
		this.panel.add(button,gbc4);
		
		JButton valider = new JButton("Valider");
		valider.setPreferredSize(new Dimension(100,25));
		valider.addActionListener(new ParserListener(this.panel));
		valider.addActionListener(new FermerFenetre(this));
		//valider.addActionListener(new OuvrirFenetre("CalendarsFrame"));
		//valider.addActionListener(new FermerFenetre(this.getOwner()));
		
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.gridx=2;
		gbc3.gridy=2;
		gbc3.insets=new Insets(45,0,0,20);
		gbc3.anchor=GridBagConstraints.SOUTHEAST;
		this.panel.add(valider,gbc3);
	}

	public void open(){
	    this.setVisible(true);
	}
}
