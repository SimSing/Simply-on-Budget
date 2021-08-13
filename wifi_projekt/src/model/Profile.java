package model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="profile")
@NamedQuery(name = "readAllProfiles", query = "select prf from Profile prf")
public class Profile  {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	public String accountName;
	public String password;
	
	@OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="profileId")
	public List<FluctExpenditures> fluctExpendituresListPrf =  new ArrayList<>();
	
	@OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="profileId")
	public List<FixedExpenditures> fixedExpendituresListPrf =  new ArrayList<>();
	
	@OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="profileId")
	public List<Income> incomeListPrf =  new ArrayList<>();
	
	public List<FixedExpenditures> getFixedExpendituresListPrf() {
		return fixedExpendituresListPrf;
	}



	public void setFixedExpendituresListPrf(List<FixedExpenditures> fixedExpendituresListPrf) {
		this.fixedExpendituresListPrf = fixedExpendituresListPrf;
	}



	public List<Income> getIncomeListPrf() {
		return incomeListPrf;
	}



	public void setIncomeListPrf(List<Income> incomeListPrf) {
		this.incomeListPrf = incomeListPrf;
	}



	public Profile(String accountName, String password) {
		
		
		this.accountName = accountName;
		this.password = password;
	}



	public List<FluctExpenditures> getFluctExpendituresListPrf() {
		return fluctExpendituresListPrf;
	}



	public void setFluctExpendituresList(List<FluctExpenditures> fluctExpendituresListPrf) {
		this.fluctExpendituresListPrf = fluctExpendituresListPrf;
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
