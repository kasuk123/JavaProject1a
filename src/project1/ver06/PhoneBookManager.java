package project1.ver06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem {
	
	
	 
	final int MAX = 100;
	PhoneInfo[] registPhone = new PhoneInfo[MAX];
	int cnt = 0;
	int a;
	String b;
	Scanner scanner = new Scanner(System.in);
	
	public static void printMenu() {
			
		System.out.println("선택하세요...");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.print("선택");
		}
	public void datainput() {
		
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1.일반,2.동창,3.회사");
		System.out.print("선택");
		a = scanner.nextInt();
		
		if(a==1) {
			b= scanner.nextLine();
			System.out.println("이름:");
			String name = scanner.nextLine();
			System.out.print("전화번호:");
			String phoneNumber = scanner.nextLine();
			
			registPhone[cnt] = new PhoneInfo(name,phoneNumber);
			cnt++;
		}
		if(a==2) {
			b= scanner.nextLine();
			System.out.println("이름:");
			String name = scanner.nextLine();
			System.out.print("전화번호:");
			String phoneNumber = scanner.nextLine();
			System.out.println("전공:");
			String major = scanner.nextLine();
			System.out.println("학년:");
			int grade = scanner.nextInt();
			
			registPhone[cnt] = new PhoneSchoolInfo(name,phoneNumber,major,grade);
			cnt++;
		}
		if(a==3) {
			b= scanner.nextLine();
			System.out.println("이름:");
			String name = scanner.nextLine();
			System.out.print("전화번호:");
			String phoneNumber = scanner.nextLine();
			System.out.println("회사:");
			String companyName = scanner.nextLine();
			
			registPhone[cnt] = new PhoneCompanyInfo(name,phoneNumber,companyName);
		}
		
		
		System.out.println("데이터 입력이 완료되었습니다.\n");
		
		
	}
	public void dataSearch() {
		
		System.out.print("데이터 검색을 시작합니다..");
		System.out.println("이름:");			
		String name = scanner.nextLine();
		
		int i = search(name);
		if(i<0) {
			System.out.println("이름이 없습니다.\n");
		}
		else {
			registPhone[i].showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다.\n");
		}
								
	}
	public void dataAllShow() {
		for(int i=0 ; i<cnt ; i++) {
			registPhone[i].showPhoneInfo();	      }
	      System.out.println("==주소록을 출력함==");
	}
		
	public void dataDelete() {
		System.out.print("데이터 삭제를 시작합니다.:");
		String name = scanner.nextLine();
		int i =search(name);//검색 메소드 이용.
		if(i<0) {
			System.out.println("해당 이름의 자료가 없습니다.");
		}
		else {
			for(int j=i; j<(cnt-1); j++)
				registPhone[j]= registPhone[j+1];
			cnt--;
		}
		System.out.println("데이터 삭제가 완료되었습니다./n");
	}
	private int search(String name) {
		for(int j=0; j<cnt; j++) {
			PhoneInfo pointInfo = registPhone[j];
			if(name.compareTo(pointInfo.name)==0)
				return j;
		}
		return -1; //못 찾았을 경우
	
	
	
	}	
		
		
}

