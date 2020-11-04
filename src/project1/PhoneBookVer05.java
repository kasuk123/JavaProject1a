package project1;

import java.util.Scanner;

import project1.ver05.PhoneBookManager;
import project1.ver05.MenuItem;
import project1.ver05.PhoneInfo;

public class PhoneBookVer05 implements MenuItem {
	
	 public static void main(String[] args) {
		
		 int cnt =0;
		 int a= 0;
		 String b;
		 //PhoneInfo ph = new PhoneInfo();
		 PhoneBookManager mng = new PhoneBookManager();
	
	
	Scanner scanner = new Scanner(System.in);
	while(true) { 
		mng.printMenu();
		
		a = scanner.nextInt();
		b = scanner.nextLine(); 
		switch(a) {
		case DATA:
			mng.datainput();
			break;
		case SEARCH:
			mng.dataSearch();
			break;
		case DELETE:
			mng.dataDelete();
			break;
		case OUTPUT:
			mng.dataAllShow();
		case EXIT:
			System.out.println("프로그램을 종료합니다.");
			return; //반복문 나가기
			
			
			}
			
		}
		
		
	 }
   
}
	 
