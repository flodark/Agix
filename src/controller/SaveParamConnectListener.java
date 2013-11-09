package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SaveParamConnectListener implements ActionListener {

	private JPanel p;
	
	public SaveParamConnectListener(JPanel p){
		this.p=p;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		for(Component i : this.p.getComponents()){
			if(i!=null && i.getName() != null){
					if(i.getName()=="proxyHTTPText")
						Main.paramConn.setHost(((JTextField)i).getText());
					if(i.getName()=="proxyPortText")
						Main.paramConn.setPort(((JTextField)i).getText());
					if(i.getName()=="loginText")
						Main.paramConn.setUserGoogle(((JTextField)i).getText());
					if(i.getName()=="passText")
						Main.paramConn.setPassGoogle(new String(((JPasswordField)i).getPassword()));
			}
		}
		System.out.println("pass"+Main.paramConn.getPassGoogle());
		System.setProperty("http.proxyHost", Main.paramConn.getHost());
		System.setProperty("http.proxyPort", Main.paramConn.getPort());
		System.setProperty("https.proxyHost", Main.paramConn.getHost());
		System.setProperty("https.proxyPort", Main.paramConn.getPort());
		
	}

}
