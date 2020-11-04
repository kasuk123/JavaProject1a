package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

/*
 * 2단계[콘솔입출력] : PhoneBookVer02.java
프로그램 사용자로부터 데이터를 입력받는 형태로 변경하시오.
단 반복문을 이용해서 프로그램의 흐름이 계속 유지되도록 해야한다. 사용자가 종료를 명령하지 않으면 다음과 같은 과정이 반복적으로 이루어진다.
키보드를 통한 데이터입력 -> 생성자를 통한 인스턴스생성 -> showPhoneInfo() 메소드호출
매 실행시 마다 기존 생성된 인스턴스는 유지되지 않아도 된다.(다음단계에서 진행)

실행결과>
선택하세요...
1. 데이터 입력
2. 프로그램 종료
선택: 1
이름: 성낙현
전화번호: 010-7906-3600
생년월일: 75.11.30
 
입력된 정보 출력...
name: 성낙현
phone: 010-7906-3600
birth: 75.11.30
 
선택하세요...
1. 데이터 입력
2. 프로그램 종료
선택: 2
프로그램을 종료합니다.
 */

public class PhoneBookVer02 {

	public static void main(String[] args) {

		PhoneInfo ph = new PhoneInfo();

		int cnt = 0;
		String b;

		Scanner keyboard = new Scanner(System.in);
		while (true) {

			System.out.println("선택하세요...");
			System.out.println("1.데이터 입력");
			System.out.println("2.프로그램종료");
			System.out.print("선택");
			cnt = keyboard.nextInt();
			if (cnt == 2) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			b = keyboard.nextLine();
			System.out.print("이름");
			String name = keyboard.nextLine();
			System.out.print("전화번호");
			String phoneNumber = keyboard.nextLine();
			System.out.print("생년월일");
			String birthday = keyboard.nextLine();
			System.out.println();

			System.out.println("name:" + name);
			System.out.println("phone:" + phoneNumber);
			System.out.println("birth:" + birthday);
			System.out.println();
		}

	}
}
