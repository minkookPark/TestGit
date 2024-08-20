package Managers;

public class ShowManager {
	private static ShowManager instance = null;
	private ShowManager() {}
	public static ShowManager getInstance()
	{
		if(instance == null)
			instance = new ShowManager();
		return instance;
	}
	
	public void inputCursor()
	{
		System.out.println("입력 해주세요 : ");
	}
	
	public void menuShow()
	{
		System.out.println("1. 도서 리스트 확인 2. 도서 등록 3. 도서 수정 4. 도서 검색 \n5.나가기");
		inputCursor();
	}
}
