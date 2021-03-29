package model;

import java.time.LocalDate;

public class FixedExpenditures {
	
	private long id;
	private String category;
	private Double amount;
	private LocalDate date;
	
	
	public FixedExpenditures(long id, String category, Double amount, LocalDate date) {
		super();
		this.category = category;
		this.amount = amount;
		this.date = date;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
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
		return "FixedExpenditures [id=" + id + ", category=" + category + ", amount=" + amount + ", date=" + date + "]";
	}
	
	

}
