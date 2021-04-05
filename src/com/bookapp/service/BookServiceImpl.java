package com.bookapp.service;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements BookService {
	List<Book> bookList = new ArrayList<>();

	@Override
	public void addBook(Book book) {
		bookList.add(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookList;
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws BookNotFoundException {
		List<Book> booksByAuthor = new ArrayList<>();
		for (Book book : bookList) {
			if (book.getAuthor().equals(author))
				booksByAuthor.add(book);
		}
		if (booksByAuthor.isEmpty())
			throw new BookNotFoundException("Book by author not available");
		return booksByAuthor;
	}

	@Override
	public Book getbyId(int id) throws BookNotFoundException {
		for (Book book : bookList) {
			if(book.getBookid()==id)
				return book;
		}
		throw new BookNotFoundException("Book by this id not available");
	}

}