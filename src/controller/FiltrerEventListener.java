package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import vue.CalendarsFrame;

public class FiltrerEventListener implements ActionListener {

	private String annee;
	private String mois;
	private String jour;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String moisNumero = "";
		
		for(Component i : CalendarsFrame.panel.getComponents()){
			if(i!=null && i.getName() != null){
				if(i.getName()=="spAnnee"){
					this.annee = (String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem();
				}
				if(i.getName()=="spMois"){
					if((String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem() == "Janvier")
						moisNumero="01";
					if((String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem() == "Février")
						moisNumero="02";
					if((String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem() == "Mars")
						moisNumero="03";
					if((String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem() == "Avril")
						moisNumero="04";
					if((String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem() == "Mai")
						moisNumero="05";
					if((String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem() == "Juin")
						moisNumero="06";
					if((String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem() == "Juillet")
						moisNumero="07";
					if((String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem() == "Août")
						moisNumero="08";
					if((String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem() == "Septembre")
						moisNumero="09";
					if((String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem() == "Octobre")
						moisNumero="10";
					if((String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem() == "Novembre")
						moisNumero="11";
					if((String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem() == "Décembre")
						moisNumero="12";
					this.mois=moisNumero;
				}
				if(i.getName()=="spJour"){
					if(((String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem()).length()==1)
						this.jour="0"+(String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem();
					else
						this.jour = (String)((JComboBox)((JScrollPane)i).getViewport().getComponent(0)).getSelectedItem();
				}
			}
		}
		
		RefreshList rl = new RefreshList(this.annee,this.mois,this.jour);
		rl.refresh();
	}

}
