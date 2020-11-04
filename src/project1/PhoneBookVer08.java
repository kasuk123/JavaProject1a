package project1;


import java.util.Scanner;

import project1.ver08.AutoSaverT;
import project1.ver08.MenuItem;
import project1.ver08.PhoneBookManager;

public class PhoneBookVer08  implements MenuItem{
	
	 public static void main(String[] args) {
			
		 int menu;
		 String b;
		 //PhoneInfo ph = new PhoneInfo();		 
		 
		 
		 PhoneBookManager mng = new PhoneBookManager();
	
		 AutoSaverT t = new AutoSaverT(mng);
		 Scanner scanner = new Scanner(System.in);
		 t.setDaemon(true);
		 //b = scanner.nextLine(); 
		 //int c = scanner.nextInt();
	
		while(true) {			
			mng.printMenu();
			
			System.out.print("메뉴를 입력하세요:");
			menu = scanner.nextInt();
			
			switch(menu) {
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
				break;
			case SAVE:
				if(t.getState()==Thread.State.TERMINATED) 
					t = new AutoSaverT(mng);
				mng.autosave(t);
				break;
			case EXIT:
				System.out.println("프로그램을 종료합니다.");
				mng.saveoutput();
				return; //반복문 나가기
			}
		}
	}
}