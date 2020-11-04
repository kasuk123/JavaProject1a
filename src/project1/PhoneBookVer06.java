package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.PhoneBookManager;
import project1.ver06.MenuItem;
import project1.ver06.MenuSelectExeption;
import project1.ver06.PhoneInfo;

public class PhoneBookVer06 implements MenuItem {
	
	 public static void main(String[] args)throws MenuSelectExeption {
		 
		 
		 int cnt =0;
		 int a= 0;
		 String b;
		// PhoneInfo ph = new PhoneInfo();
		 PhoneBookManager mng = new PhoneBookManager();
	
	
	Scanner scanner = new Scanner(System.in);
	
	while(true) { 
		try {
			mng.printMenu();
			
			
		
		try {
		a = scanner.nextInt();
		
		if(a>5 || a<1) {
			MenuSelectExeption menu = new MenuSelectExeption();
			throw menu ;

		}
		}catch(InputMismatchException e) {
			System.err.println(e.getMessage());
		scanner.nextLine();
		
	}	
		switch(a) {
		case 1:
			mng.datainput();
			break;
		case 2:
			mng.dataSearch();
			break;
		case 3:
			mng.dataDelete();
			break;
		case 4:
			mng.dataAllShow();
		case 5:
			System.out.println("프로그램을 종료합니다.");
			return; //반복문 나가기
		}
		
}
	catch (MenuSelectExeption e) {
			System.err.println(e.getMessage());
		

	
		}  
}	
	 }
}


