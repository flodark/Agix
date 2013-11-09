package vue;

import java.awt.Image;

import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class ImageIntro extends JFrame{

	
	public ImageIntro(){
		
		super();
		this.setTitle("Agix"); 
		this.setSize(392,274);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
	}
	
	public void paint(Graphics g)
	{
		super.paintComponents(g);
		Image image = getToolkit().getImage("images/agix.png");
		if(image != null) // Si l'image existe, ...
			g.drawImage(image, 0, 0, this); // ... on la dessine
	}
	
	public void open(){
	    this.setVisible(true);
	}

	public void close() {
		// TODO Auto-generated method stub
		this.dispose();
	}

}
