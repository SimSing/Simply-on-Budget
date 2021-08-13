package model;

import java.time.LocalDate;


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
@Table(name = "FluctExpenditures")
@NamedQuery(name ="readAllFluctExpenditures", query = "SELECT fe FROM FluctExpenditures fe")// WHERE fe.profile.accountName= :idPrf")



public class FluctExpenditures {
	
	
	
	public enum Category {DAILY_NECESSITIES,ALCOHOL_TOBACCO, WORK_EDUCATION, TRAFFIC_CAR, RESTAURANT_HOTELS, CLOTHES_SHOES, 
				   LEASURE_SPORT_CULTURE, OTHER, ALL}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	public Category category;
	public double price;
	public LocalDate date;
	public String comment;
	public String path;
	@ManyToOne(fetch = FetchType.EAGER)//,  cascade = CascadeType.ALL)
	@JoinColumn(name="profileId")
	public Profile profile;
	
 	public FluctExpenditures() {
 		super();
 	}
	
public FluctExpenditures(FluctExpenditures copy) {
	this.category = copy.category;
	this.price = copy.price;
	this.date = copy.date;
	this.comment = copy.comment;
	this.path = copy.path;
	this.profile = copy.profile;
}
	
	
	public FluctExpenditures(Category category, double price, LocalDate date, String comment, String path, Profile profile) {
		super();
		
		this.category = category;
		this.price = price;
		this.date = date;
		this.comment = comment;
		this.path = path;
		this.profile = profile;
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
	public void setId(Integer id) {
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
				+ ", comment=" + comment + ", path=" + path + ", profile=" + profile + "]";
	}

	public Object getCategoryIndex(int i) {
		// TODO Auto-generated method stub
		return category.ordinal();
	}
	


	
}
	
	

