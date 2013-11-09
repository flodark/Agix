package vue;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class WaitSynchroFrame extends JFrame{

	public WaitSynchroFrame(){
		super();
		this.setTitle("Synchronization in progress..."); 
		this.setSize(300,0);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void open(){
	    this.setVisible(true);
	}

	public void close() {
		this.dispose();
	}
}
