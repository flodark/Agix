package vue;

import javax.swing.*;

import controller.Main;
import controller.SaveParamConnectListener;

import java.awt.*;

@SuppressWarnings("serial")
public class ParametreConnexion extends JFrame{
	
	private JPanel panel = new JPanel();
	private GridLayout gl = new GridLayout(0,2);
	
	public ParametreConnexion(){
		
		super();
		
		this.setTitle("Agix - Paramètres de connexion"); 
		this.setSize(300,350);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.panel.setLayout(gl);
		this.panel.setBackground(Color.white);
		this.setContentPane(this.panel);
		
		this.buildContent();
	}
	
	private void buildContent() {
		
		gl.setRows(10);
		// TODO Auto-generated method stub
		JLabel proxyHTTP = new JLabel("Proxy HTTP : ");
		proxyHTTP.setName("proxyHTTP");
		this.panel.add(proxyHTTP);
		
		JTextField proxyHTTPText = new JTextField();
		proxyHTTPText.setName("proxyHTTPText");
		proxyHTTPText.setText(Main.paramConn.getHost());
		this.panel.add(proxyHTTPText);
		
		JLabel proxyPort = new JLabel("Proxy Port : ");
		proxyPort.setName("proxyPort");
		this.panel.add(proxyPort);
		
		JTextField proxyPortText = new JTextField();
		proxyPortText.setName("proxyPortText");
		proxyPortText.setText(""+Main.paramConn.getPort());
		this.panel.add(proxyPortText);
		
		JLabel login = new JLabel("Login Google : ");
		login.setName("login");
		this.panel.add(login);
		
		JTextField loginText = new JTextField();
		loginText.setName("loginText");
		loginText.setText(Main.paramConn.getUserGoogle());
		this.panel.add(loginText);
		
		JLabel pass = new JLabel("Password Google : ");
		pass.setName("pass");
		this.panel.add(pass);
		
		JPasswordField pw = new JPasswordField();
		pw.setName("passText");
		pw.setText(Main.paramConn.getPassGoogle());
		this.panel.add(pw);
		
		gl.setVgap(3);
		
		JButton save = new JButton("Save");
		save.addActionListener(new SaveParamConnectListener(this.panel));
		save.addActionListener(new FermerFenetre(this));
		this.panel.add(save);
	}

	public void open(){
	    this.setVisible(true);
	}
}
