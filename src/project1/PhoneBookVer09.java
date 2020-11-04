package project1;

import java.util.Scanner;

import project1.ver09.PhoneInfo;
import project1.ver09.DBConnect;
import project1.ver09.PhoneBookManager;

public class PhoneBookVer09 {
	static PhoneBookManager mng = new PhoneBookManager();
	 public static void main(String[] args) {
			
		 int cnt =0;
		 int a= 0;
		 String b;
		 //PhoneInfo ph = new PhoneInfo();
		 
	
	
	Scanner scanner = new Scanner(System.in);
	while(true) { 
		mng.printMenu();
		
		a = scanner.nextInt();
		b = scanner.nextLine(); 
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
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			return; //반복문 나가기
			
			
			}
			
		}
		
		
	 }
   

	 
		
		}
    
		 
	
	 
