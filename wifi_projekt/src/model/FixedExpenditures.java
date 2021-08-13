package model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name= "FixedExpenditures")
@NamedQuery(name ="readAllFixedExpenditures", query = "select fxe from FixedExpenditures fxe")
//@NamedQuery(name ="readAllFixedExpendituresYears", query = "select dateFixedExpenditures from FixedExpenditures")
public class FixedExpenditures {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	public String category;
	public Double amount;
	public LocalDate dateFixedExpenditures = LocalDate.now();
	@ManyToOne(fetch = FetchType.EAGER)//,  cascade = CascadeType.ALL)
	@JoinColumn(name="profileId")
	public Profile profile;
	
	public FixedExpenditures(String category, double amount, LocalDate dateFixedExpenditures,Profile profile) {
		super();
		this.category = category;
		this.amount = amount;
		this.dateFixedExpenditures = dateFixedExpenditures;
		this.profile = profile;
	}
	
	public FixedExpenditures(FixedExpenditures copy) {
		this.category = copy.category;
		this.amount = copy.amount;
		this.dateFixedExpenditures = copy.dateFixedExpenditures;
		this.profile = copy.profile;
	
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public FixedExpenditures() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDateFixedExpenditures() {
		return dateFixedExpenditures;
	}

	public void setDateFixedExpenditure(LocalDate dateFixedExpenditures) {
		this.dateFixedExpenditures = dateFixedExpenditures;
	}

	@Override
	public String toString() {
		return "FixedExpenditures [id=" + id + ", category=" + category + ", amount=" + amount + ", date=" + dateFixedExpenditures + "]";
	}
	



}
