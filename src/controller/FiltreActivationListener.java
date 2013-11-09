package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

import vue.CalendarsFrame;

public class FiltreActivationListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(Component i : CalendarsFrame.panel.getComponents()){
			if(i!=null && i.getName() != null){
				if(i.getName()=="spAnnee"){
					((JScrollPane)i).getHorizontalScrollBar().setEnabled(((JCheckBox)e.getSource()).isSelected());
					((JScrollPane)i).getVerticalScrollBar().setEnabled(((JCheckBox)e.getSource()).isSelected());
					((JScrollPane)i).getViewport().getView().setEnabled(((JCheckBox)e.getSource()).isSelected());
				}
				if(i.getName()=="spMois"){
					((JScrollPane)i).getHorizontalScrollBar().setEnabled(((JCheckBox)e.getSource()).isSelected());
					((JScrollPane)i).getVerticalScrollBar().setEnabled(((JCheckBox)e.getSource()).isSelected());
					((JScrollPane)i).getViewport().getView().setEnabled(((JCheckBox)e.getSource()).isSelected());
				}
				if(i.getName()=="spJour"){
					((JScrollPane)i).getHorizontalScrollBar().setEnabled(((JCheckBox)e.getSource()).isSelected());
					((JScrollPane)i).getVerticalScrollBar().setEnabled(((JCheckBox)e.getSource()).isSelected());
					((JScrollPane)i).getViewport().getView().setEnabled(((JCheckBox)e.getSource()).isSelected());
				}
			}
		}
		
		if(!((JCheckBox)e.getSource()).isSelected()){
			RefreshList rl = new RefreshList(false);
			rl.refresh();
		}
		else{
			FiltrerEventListener fe = new FiltrerEventListener();
			fe.actionPerformed(e);
		}
	}

}
