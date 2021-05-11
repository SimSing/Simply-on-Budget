package model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name ="readAllFluctExpenditures", query = "select fe from FluctExpenditures fe")

public class FluctExpenditures {
	
	
	
	public enum Category {DAILY_NECESSITIES,ALCOHOL_TOBACCO, WORK_EDUCATION, TRAFFIC_CAR, RESTAURANT_HOTELS, CLOTHES_SHOES, 
				   LEASURE_SPORT_CULTURE, OTHER, ALL}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	public Category category;
	public double price;
	public LocalDate date;
	public String comment;
	public String path;
	
	public FluctExpenditures() {
		super();
	}
	
	public FluctExpenditures(Category category, double price, LocalDate date, String comment, String path) {
		super();
		
		this.category = category;
		this.price = price;
		this.date = date;
		this.comment = comment;
		this.path = path;
	}

			
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
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
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "FluctExpenditures [id=" + id + ", category=" + category + ", price=" + price + ", date=" + date
				+ ", comment=" + comment + ", path=" + path + "]";
	}

	public Object getCategoryIndex(int i) {
		// TODO Auto-generated method stub
		return category.ordinal();
	}

	
	
}
