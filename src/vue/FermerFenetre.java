package vue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FermerFenetre implements ActionListener{
	
	private Window j;

	public FermerFenetre(Window j){
		this.j=j;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.j.dispose();
	}

}
