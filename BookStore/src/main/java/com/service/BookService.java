package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import com.dao.BookDao;
import com.entity.Book;
@Service
public class BookService {
	@Autowired 
	BookDao dao;

	public String Addbook(Book book) {
		return dao.Addbook(book);
	}

	public List<Book> getRecord() {
		return dao.getRecord();
		
	}

	public String updatebyid(int id, Book book) {
		return dao.updatebyid(id,book);
	}

	public String deletebyid(int id) {
		return dao.deletebyid(id);
		
	}

	
		
	

	public Book getbyAuthor(String Author) {
		return dao.getByAuthor(Author);
		
	}

	public Book getbytype(String type) {
		return dao.getbytype(type);
		
		
	}

	public Object getbypublishDate(LocalDate publishDate) {
		return dao.getbypublishDate(publishDate);
	}

	public Book getbyname(String name) {
		return dao.getbyname(name);
	}

}