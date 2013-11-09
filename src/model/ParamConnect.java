package model;

public class ParamConnect {

	private String host = "";
	private String userGoogle = "";
	private String passGoogle = "";
	private String port = "";
	
	public ParamConnect(String host, String port, String user, String pass) {
		super();
		this.userGoogle = user;
		this.passGoogle = pass;
		this.host = host;
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String link) {
		this.host = link;
	}

	public String getUserGoogle() {
		return userGoogle;
	}

	public void setUserGoogle(String user) {
		this.userGoogle = user;
	}

	public String getPassGoogle() {
		return passGoogle;
	}

	public void setPassGoogle(String pass) {
		this.passGoogle = pass;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}
