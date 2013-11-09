package vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class OuvrirFenetre implements ActionListener {
	
	private String fen;
	
	
	public OuvrirFenetre(String fen){
		this.fen=fen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object fenetreAOuvrir = new Object();
		try {
			fenetreAOuvrir = Class.forName("vue."+this.fen).newInstance();
			java.lang.reflect.Method[] m = fenetreAOuvrir.getClass().getDeclaredMethods();
			for(java.lang.reflect.Method i : m){
				if (i.getName() == "open"){
					i.invoke(fenetreAOuvrir);
				}
			}
			
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InvocationTargetException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}
}
