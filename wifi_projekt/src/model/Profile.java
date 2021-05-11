package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;


@Entity
@NamedQuery(name = "readAllProfiles", query = "select prf from Profile prf")
public class Profile {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	public String accountName;
	public String password;
	
	
	public Profile(String accountName, String password) {
		super();
		
		this.accountName = accountName;
		this.password = password;
	}

	public Profile() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", accountName=" + accountName + ", password=" + password + "]";
	}
	
	
}
