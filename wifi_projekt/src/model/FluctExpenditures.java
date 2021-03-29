package model;

import java.time.LocalDate;

public class FluctExpenditures {
	
	private long id;
	private String category;
	private double price;
	private LocalDate date;
	private String comment;
	
	
	public FluctExpenditures(String category, double price, LocalDate date, String comment) {
		super();
		this.category = category;
		this.price = price;
		this.date = date;
		this.comment = comment;
	}
	public FluctExpenditures() {
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "FluctExpenditures [id=" + id + ", category=" + category + ", price=" + price + ", date=" + date
				+ ", comment=" + comment + "]";
	}
	
	
}
