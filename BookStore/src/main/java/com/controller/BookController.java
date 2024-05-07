package com.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Book;
import com.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	BookService service;
	  
	@PostMapping("/add")
	public String Addbook(@RequestBody Book book) {
		return service.Addbook(book);
	}
	@GetMapping("/all")
	public List<Book>getRecord(){
		return service.getRecord();
	}
	@PutMapping("/update/{id}")
	public String updatebyid(@PathVariable int id,@RequestBody Book book) {
		return service.updatebyid(id,book);
		
	}
	@DeleteMapping("/delete/{id}")
	public String deletebyid(@PathVariable int id) {
		return service.deletebyid(id);
		
	}
	
	@GetMapping("getbyAuthor/{Author}")
	public Book getbyAuthor(@PathVariable String Author) {
		return service.getbyAuthor(Author);
		
	}
	@GetMapping("getbytype/{type}")
	public Book getbytype(@PathVariable String type) {
		return service.getbytype(type);
		
	}
	@GetMapping("getbyDate/{publishDate}")
	 Object getbypublishDate(@PathVariable LocalDate publishDate ) {
		return service.getbypublishDate(publishDate);
		
		
	}
	@GetMapping("getbyname/{name}")
	public Book getbyname(@PathVariable String name) {
		return service.getbyname(name);
	}
	
}
