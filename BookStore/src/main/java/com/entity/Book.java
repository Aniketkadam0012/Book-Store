package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	private int id;
	private String name;
	private String title;
	private int price;
	private String Author;
	private String type;
	private LocalDate publishDate;
     
	public Book() {
		
		
	}
  @Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
		
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", title=" + title + ", price=" + price + ", Author=" + Author
				+ ", type=" + type + ", publishDate=" + publishDate + "]";
	}

}