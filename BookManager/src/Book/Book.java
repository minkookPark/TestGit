package Book;

import java.time.LocalDate;

public class Book {
	public Book(String title, String publicer, int price, LocalDate releaseData) {
		this.title = title;
		this.publicer = publicer;
		this.price = price;
		this.releaseData = releaseData;
		this.discountRate = 0;
		this.isDiscount = false;
	}

	private String title;
	private String publicer;
	private int price;
	private LocalDate releaseData;

	private int discountRate;
	private boolean isDiscount;

	public String getTitle() {
		return title;
	}

	public String getPublicer() {
		return publicer;
	}

	public int getPrice() {
		if (discountRate == 0)
			return price;
		else
			return price * (100 - discountRate);
	}

	public void setDiscountRate(int discount) 
	{
		if(discount != 0)
		{
			discountRate = discount;
			isDiscount = true;
		}
		else if (discount == 0)
			isDiscount = false;
	}

	public LocalDate getReleaseData() 
	{
		return releaseData;
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
