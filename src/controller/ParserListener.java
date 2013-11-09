package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;


public class ParserListener implements ActionListener {

	private JPanel jp;
	private String uri, nameCal;
	
	public ParserListener(JPanel panel) {
		// TODO Auto-generated constructor stub
		this.jp=panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		for(Component i : jp.getComponents()){
			if(i!=null && i.getName() != null){
					if(i.getName()=="uri")
						this.uri=((JTextField)i).getText();
					if(i.getName()=="nomCalVal")
						this.nameCal=((JTextField)i).getText();
			}
		}
		while(Main.myCals.getMap().keySet().contains(this.nameCal)){
			this.nameCal += "_bis";
		}
		
		ICSParser parser = new ICSParser(uri,nameCal);
		parser.parse();
	}

}
