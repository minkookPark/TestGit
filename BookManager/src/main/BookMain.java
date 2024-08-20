package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Book.Book;
import Library.Library;

public class BookMain {

	public static void main(String[] args) {
		Library lib = new Library();
		
		Book b1 = new Book("test1", "tp1", 1000, LocalDate.parse("20221211", DateTimeFormatter.BASIC_ISO_DATE));
		Book b2 = new Book("test2", "tp2", 2000, LocalDate.parse("20221212", DateTimeFormatter.BASIC_ISO_DATE));
		Book b3 = new Book("test3", "tp3", 3000, LocalDate.parse("20221213", DateTimeFormatter.BASIC_ISO_DATE));
		Book b4 = new Book("test4", "tp4", 4000, LocalDate.parse("20221214", DateTimeFormatter.BASIC_ISO_DATE));
		Book b5 = new Book("test5", "tp5", 5000, LocalDate.parse("20221215", DateTimeFormatter.BASIC_ISO_DATE));
		
		lib.addBook(b1);
		lib.addBook(b2);
		lib.addBook(b3);
		lib.addBook(b4);
		lib.addBook(b5);
		
		lib.run();
	}

}
