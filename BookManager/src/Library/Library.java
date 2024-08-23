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
				//도서목록 열람
				disPlayBook();
				break;
			case "2":
				//책 추가
				addBook();
				break;
			case "3":
				//책 수정
				break;
			case "4":
				//책 검색
				break;
			case "5":
				//종료
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
		
		LocalDate releaseDate = checkLocalDate();		
		
		Book b = new Book(title, pub, Integer.parseInt(price), releaseDate);
		
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
	
	private LocalDate checkLocalDate()
	{
		int releaseDateYear;
		int releaseDateMonth;
		int releaseDateDay;
		
		while (true) 
		{
			System.out.println("출시 연도 : ");
			String year = scan.nextLine();
			int releaseYear = Integer.parseInt(year);
			if (releaseYear >= 1900 && releaseYear <= 2024) 
			{
				releaseDateYear = releaseYear;
				break;
			}
			else
				System.out.println("올바른 정보를 입력해주세요 (1900~ 2024)");
		}
		
		while (true) 
		{
			System.out.println("출시 월 : ");
			String month = scan.nextLine();
			int releaseMonth = Integer.parseInt(month);
			if (releaseMonth >= 1 && releaseMonth <= 12) 
			{
				releaseDateMonth = releaseMonth;
				break;
			}
			else
				System.out.println("올바른 정보를 입력해주세요 (1~ 12)");
		}

		while (true) 
		{
			System.out.println("출시 일 : ");
			String day = scan.nextLine();
			int releaseDay = Integer.parseInt(day);
			if (releaseDay >= 1 && releaseDay <= 31) 
			{
				releaseDateDay = releaseDay;
				break;
			}
			else
				System.out.println("올바른 정보를 입력해주세요 (1~ 31)");
		}
		
		LocalDate date = LocalDate.of(releaseDateYear, releaseDateMonth, releaseDateDay);		
		
		return date;
	}
	
	public void modifyBook()
	{
		
	}
	
}
