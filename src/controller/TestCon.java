package controller;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestCon {

	/**
	 * @param args
	 */
	public static boolean test() {
		// TODO Auto-generated method stub
		boolean ok = false;
	    HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) new URL("https://www.google.com").openConnection();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	conn.setConnectTimeout(7000);
			try {
				conn.connect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				conn.disconnect();
				return ok;
			}
			conn.disconnect();
			return !ok;
	   }
}
