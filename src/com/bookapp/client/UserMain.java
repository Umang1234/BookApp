package com.bookapp.client;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImpl;

public class UserMain {

	public static void main(String[] args) {

		BookService service = new BookServiceImpl();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			String author = sc.next();
			String title = sc.next();
			String category = sc.next();
			int bookid = sc.nextInt();
			Book book = new Book(title, author, bookid, category);
			service.addBook(book);
			System.out.println("book added");
		}
		System.out.println("All books");
		for (Book book : service.getAllBooks()) {
			System.out.println(book);
		}
		System.out.println();
		System.out.println("By Author");
		List<Book> bookByAuthor = null;
		String author = sc.next();
		try {
			bookByAuthor = service.getBookByAuthor(author);
			Collections.sort(bookByAuthor,(b1,b2)->b1.getTitle().compareTo(b2.getTitle()));
			for (Book book : bookByAuthor) {
				System.out.println(book);
			}	
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		Book book;
		try {
			book = service.getbyId(10);
			System.out.println(book);
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}	
	}
}