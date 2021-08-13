package model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name= "Income")
@NamedQuery(name = "readAllIncome", query = "select inc from Income inc")
public class Income {

	public enum CategoryInc {
		WAGE_SALARY, INTEREST, OTHER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	public CategoryInc categoryInc;
	public double amountInc;
	public LocalDate dateInc = LocalDate.now();
	public String commentInc;
	@ManyToOne(fetch = FetchType.EAGER)//,  cascade = CascadeType.ALL)
//	@JoinColumn(name="profileIdd")
	public Profile profile;


	public Income(CategoryInc categoryInc, double amountInc, LocalDate dateInc, String commentInc, Profile profile) {
		super();

		this.categoryInc = categoryInc;
		this.amountInc = amountInc;
		this.dateInc = dateInc;
		this.commentInc = commentInc;
		this.profile = profile;
	}

public Income (Income copy) {
	this.categoryInc = copy.categoryInc;
	this.amountInc = copy.amountInc;
	this.dateInc = copy.dateInc;
	this.commentInc = copy.commentInc;
	this.profile = copy.profile;
}
	public Income() {
		super();
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CategoryInc getCategoryInc() {
		return categoryInc;
	}

	public void setCategoryInc(CategoryInc categoryInc) {
		this.categoryInc = categoryInc;
	}

	public double getAmountInc() {
		return amountInc;
	}

	public void setAmountInc(double amountInc) {
		this.amountInc = amountInc;
	}

	public LocalDate getDateInc() {
		return dateInc;
	}

	public void setDateInc(LocalDate dateInc) {
		this.dateInc = dateInc;
	}

	public String getCommentInc() {
		return commentInc;
	}

	public void setCommentInc(String commentInc) {
		this.commentInc = commentInc;
	}

	@Override
	public String toString() {
		return "Income [id=" + id + ", categoryInc=" + categoryInc + ", amountInc=" + amountInc + ", dateInc=" + dateInc
				+ ", commentInc=" + commentInc + "]";
	}

}
