package com.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Book;
@Repository
public class BookDao {
	@Autowired
	SessionFactory sf;

	public String Addbook(Book book) {
		Session session =sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(book);
		tr.commit();
		return "data added ";
		
	}

	public List<Book> getRecord() {
		Session session =sf.openSession();
		Criteria cri=session.createCriteria(Book.class);
		List<Book> list=cri.list();
		session.close();
		return list;
	}

	public String updatebyid(int id, Book book) {
		Session session =sf.openSession();
		book.setId(id);
		Transaction tr=session.beginTransaction();
		session.update(book);
		tr.commit();
		return "update data";
	}

	public String deletebyid(int id) {
		Session session=sf.openSession();
		Transaction tr =session.beginTransaction();
		session.delete(session.get(Book.class, id));
		tr.commit();
		return "deleted";
		
	}

	
		

	public Book getByAuthor(String author) {
	    Session session = sf.openSession();
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
	    Root<Book> root = criteriaQuery.from(Book.class);

	    Predicate typePredicate = builder.equal(root.get("type"), root);
	    Predicate authorPredicate = builder.equal(root.get("author"), author);

	    criteriaQuery.select(root).where(builder.and(typePredicate, authorPredicate));

	    List<Book> books = session.createQuery(criteriaQuery).getResultList();

	    if (books.isEmpty()) {
	        return null; 
	    } else {
	        return books.get(0);
	    }
	}




	public Book getbytype(String type) {
	    Session session = sf.openSession();
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
	    Root<Book> root = criteriaQuery.from(Book.class);
	    criteriaQuery.select(root).where(builder.equal(root.get("type"), type));
	    
	    List<Book> books = session.createQuery(criteriaQuery).getResultList();
	    
	    if (books.isEmpty()) {
	        return null; 
	    } else {
	        return books.get(0); 
	    }
	}



	public Object getbypublishDate(LocalDate publishDate) {
		
		    Session session = sf.openSession();
		    CriteriaBuilder builder = session.getCriteriaBuilder();
		    CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
		    Root<Book> root = criteriaQuery.from(Book.class);

		    Predicate datePredicate = builder.equal(root.get("date"),publishDate);

		    criteriaQuery.select(root).where(datePredicate);

		    List<Book> books = session.createQuery(criteriaQuery).getResultList();

		    if (books.isEmpty()) {
		        return null; 
		    } else {
		        return books.get(0); 
		    }
		}

	

	public Book getbyname(String name) {
		 Session session = sf.openSession();
		    CriteriaBuilder builder = session.getCriteriaBuilder();
		    CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
		    Root<Book> root = criteriaQuery.from(Book.class);

		    Predicate namePredicate = builder.equal(root.get("name"), name);

		    criteriaQuery.select(root).where(namePredicate);

		    List<Book> books = session.createQuery(criteriaQuery).getResultList();

		    if (books.isEmpty()) {
		        return null; 
		    } else {
		        return books.get(0); 
		    }


	

	
	}}


