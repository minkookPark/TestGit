package Book;

import java.time.LocalDate;

public class Book {
	public Book(String title, String publicer, int price, LocalDate releaseData) {
		this.title = title;
		this.publicer = publicer;
		this.price = price;
		this.releaseData = releaseData;
	}

	private String title;
	private String publicer;
	private int price;
	private LocalDate releaseData;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublicer() {
		return publicer;
	}

	public void setPublicer(String publicer) {
		this.publicer = publicer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getReleaseData() {
		return releaseData;
	}
	public void setReleaseDate(LocalDate data)
	{
		this.releaseData = data;				
	}
	
	public void showBookInfomation()
	{
		System.out.println("책 제목 : " + title);
		System.out.println("출판사 : " + publicer);
		System.out.println("가격 : " + price);
		System.out.println("출시일 : " + releaseData);
		System.out.println();
	}
}
