package model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
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

	public Income(CategoryInc categoryInc, double amountInc, LocalDate dateInc, String commentInc) {
		super();

		this.categoryInc = categoryInc;
		this.amountInc = amountInc;
		this.dateInc = dateInc;
		this.commentInc = commentInc;
	}

	public Income(long id, CategoryInc categoryInc, double amountInc, LocalDate dateInc, String commentInc) {
		super();
		this.id = id;
		this.categoryInc = categoryInc;
		this.amountInc = amountInc;
		this.dateInc = dateInc;
		this.commentInc = commentInc;
	}

	public Income() {
		super();
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
