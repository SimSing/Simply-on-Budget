package model;

import java.time.LocalDate;

public class Income {
	
	private long id;
	private String category;
	private double amount;
	private LocalDate date;
	
	public Income(long id, String category, double amount, LocalDate date) {
		super();
		this.id = id;
		this.category = category;
		this.amount = amount;
		this.date = date;
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
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
@Override
public String toString() {
	return "Income [id=" + id + ", category=" + category + ", amount=" + amount + ", date=" + date + "]";
}



}
