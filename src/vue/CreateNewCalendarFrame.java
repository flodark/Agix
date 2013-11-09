package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.CalendarAgix;

import controller.Main;
import controller.RefreshList;
import controller.SelectEventFromCalendarListener;

@SuppressWarnings("serial")
public class CreateNewCalendarFrame extends JFrame{
	
	private JPanel panel;
	
	public CreateNewCalendarFrame(){
		super();
		this.panel = new JPanel();
		
		this.setTitle("Agix - Créer Calendrier"); 
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
		// TODO Auto-generated method stub
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
		
		JButton valider = new JButton("Valider");
		valider.setPreferredSize(new Dimension(100,25));
		valider.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(nomCalVal.getText()==null || nomCalVal.getText()==""){
					nomCalVal.setText("MyCalendar");
				}else{
					String nom = nomCalVal.getText();
					while(Main.myCals.getMap().keySet().contains(nom)){
						nom += "_bis";
					}
					CalendarAgix cal = new CalendarAgix(nom);
					Main.myCals.addCalendar(nom,cal);

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
					
					if(SelectEventFromCalendarListener.currentCal=="")
						SelectEventFromCalendarListener.currentCal=nomCalVal.getText();
					
					RefreshList rl = new RefreshList(false);
					rl.refresh();
				}
			}
		});
		valider.addActionListener(new FermerFenetre(this));
		
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.gridx=1;
		gbc3.gridy=1;
		gbc3.insets=new Insets(45,0,0,20);
		gbc3.anchor=GridBagConstraints.SOUTHEAST;
		this.panel.add(valider,gbc3);
	}
	
	public void open(){
	    this.setVisible(true);
	}
}
