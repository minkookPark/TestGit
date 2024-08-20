package Library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Book.Book;
import Managers.InputManager;
import Managers.ShowManager;

public class Library {
	//전체 책을 들고있을 리스트
	private List<Book> bLst = new ArrayList<>();
	//검색을 위해 들고있을 맵
	private Map<String, Book> bMap = new HashMap<>();	
	
	public Library()
	{
		init();
	}
	
	private Scanner scan;
	
	private void init()
	{
		bLst.clear();
		bMap.clear();
		InputManager.getInstance().init();
		scan = InputManager.getInstance().getScan();
	}
	
	public void run()
	{
		boolean loop = true;
		while (loop) {
			ShowManager.getInstance().menuShow();
			
			String select = scan.nextLine();
			
			switch (select) {
			case "1":
				disPlayBook();
				break;
			case "2":
				addBook();
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				loop = false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				
				break;
			}
		}
	}
	
	public void disPlayBook()
	{
		bLst.stream().forEach(x -> x.showBookInfomation());
		System.out.println("총 도서의 갯수 : " + bLst.size() + "권이 있습니다.");
	}
	
	private void addBook()
	{
		System.out.println("책 제목 입력 : ");
		String title = scan.nextLine();
		System.out.println("책 출판사 입력 : ");
		String pub = scan.nextLine();
		System.out.println("가격 입력 : ");
		String price = scan.nextLine();		
		System.out.println("출시일 입력 : ");
		String releaseData = scan.nextLine();
		
		//날짜부분이 너무 위험함
		Book b = new Book(title, pub, Integer.parseInt(price), LocalDate.parse(releaseData, DateTimeFormatter.BASIC_ISO_DATE));
		
		bLst.add(b);
		bMap.put(b.getTitle(), b);
	}
	
	public boolean addBook(Book _book)
	{	
		bLst.add(_book);
		bMap.put(_book.getTitle(), _book);
		return true;
	}
	
	public Book findBook(String _title)
	{
		return bMap.get(_title);
	}
	
	public void modifyBook()
	{
		
	}
	
}
