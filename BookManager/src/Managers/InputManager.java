package Managers;

import java.util.Scanner;

public class InputManager {
	private static InputManager instance = null;
	private InputManager() {}
	public static InputManager getInstance()
	{
		if(instance == null)
			instance = new InputManager();
		return instance;
	}
	
	private Scanner scan;
	
	public void init()
	{
		activeScanner(true);
	}
	
	private void activeScanner(boolean _isActive)
	{
		if(_isActive && scan == null)
			scan = new Scanner(System.in);
		else if(_isActive && scan != null)
			return;
		else if(!_isActive && scan != null)
			scan.close();
		else
			return;
	}
	
	public Scanner getScan()
	{
		activeScanner(true);
		return scan;
	}
	public void closeScan()
	{
		activeScanner(false);
	}
	
	//날짜 데이터가 올바른지 검사해주는 메서드
	public boolean inspectData(String _date)
	{
		return true;
	}
}
