package login;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

	private String user;
	private String pass;
	
	
	
	public User(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}
	
	
	




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}






	@Override
	public String toString() {
		return "Usuario: " + user + " Contrasenya: " + pass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
}
