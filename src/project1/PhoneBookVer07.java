package project1;


import java.util.Scanner;


import project1.ver07.PhoneBookManager;

public class PhoneBookVer07 {
	
	 public static void main(String[] args) {
			
		 int menu;
		 String b;
		 //PhoneInfo ph = new PhoneInfo();		 
		 
		 
		 PhoneBookManager mng = new PhoneBookManager();
	
		 Scanner scanner = new Scanner(System.in);
		 //
		 //b = scanner.nextLine(); 
		 //int c = scanner.nextInt();
	
		while(true) {			
			mng.printMenu();
			
			System.out.print("메뉴를 입력하세요:");
			menu = scanner.nextInt();
			
			switch(menu) {
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