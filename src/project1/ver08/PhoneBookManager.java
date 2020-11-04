package project1.ver08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem {

	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();

	public PhoneBookManager() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/project1/ver08/PhoneBook.obj"));
			set = (HashSet<PhoneInfo>) in.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("파일없음");
		} catch (IOException e) {
			System.out.println("뭔가없음");
		} catch (Exception e) {
			System.out.println("다없음");
		}
	}

	public void autosave(AutoSaverT ast) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.자동저장On,2.자동저장Off");
		int c = scanner.nextInt();
		scanner.nextLine();
		if (c == 1) {
			if (ast.getState() == Thread.State.NEW) {
				ast.start();
				System.out.println("자동저장을 시작합니다.");
			} else {
				System.out.println("이미 자동저장이 실행중입니다.");
			}
		} else if (c == 2) {
			ast.interrupt();
			System.out.println("자동저장을 종료합니다.");
		}
	}

	public void save() {

		try {
			PrintWriter out = new PrintWriter(new FileWriter("src/project1/ver08/PhoneBook.txt"));
			Iterator<PhoneInfo> it = set.iterator();
			while (it.hasNext()) {
				PhoneInfo pi = it.next();
				if (pi instanceof PhoneInfo) {
					out.printf("이름:%s", pi.name);

					out.print(" 전화번호:" + pi.phoneNumber);
					out.println();
				} else if (pi instanceof PhoneSchoolInfo) {
					out.print("이름:" + pi.name);
					out.print(" 전화번호:" + pi.phoneNumber);
					out.print(" 전공과목:" + pi.major);
					out.print(" 학년:" + pi.grade);
				} else if (pi instanceof PhoneCompanyInfo) {
					out.print("직장명:" + pi.getter1());
					
				}
				
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveoutput() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/project1/ver08/PhoneBook.obj"));
			out.writeObject(set);
		} catch (FileNotFoundException e) {
			System.out.println("파일없음");
		} catch (IOException e) {
			System.out.println("뭔가없음");
		} catch (Exception e) {
			System.out.println("다없음");
		}
	}

	int a;
	String b;
	Scanner scanner = new Scanner(System.in);

	public void printMenu() {

		System.out.println("선택하세요...");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.저장 옵션");
		System.out.println("6.프로그램 종료");
		System.out.print("선택");
	}

	public void datainput() {

		String name, phoneNumber, major, companyName;
		int grade;

		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1.일반,2.동창,3.직장동료");
		System.out.print("선택");
		a = scanner.nextInt();
		b = scanner.nextLine();

		if (a == 1) {
			System.out.println("이름:");
			name = scanner.nextLine();
			System.out.print("전화번호:");
			phoneNumber = scanner.nextLine();

			PhoneInfo phinfo = new PhoneInfo(name, phoneNumber);

			boolean normal = set.add(phinfo);
			if (normal == false) {
				System.out.println("이미 저장된 데이터입니다.\n덮어쓸까요?Y(y)/N(n)");
				Scanner scan = new Scanner(System.in);
				String str = scan.nextLine();

				if (str.equalsIgnoreCase("y")) {
					set.remove(phinfo);
					set.add(phinfo);

					System.out.println("덮어쓰기 완료되었습니다.");

				} else if (str.equalsIgnoreCase("n")) {
					System.out.println("덮어쓰기 실패하였습니다.");

				}
			}
		}
		if (a == 2) {
			System.out.println("이름:");
			name = scanner.nextLine();
			System.out.print("전화번호:");
			phoneNumber = scanner.nextLine();
			System.out.println("전공:");
			major = scanner.nextLine();
			System.out.println("학년:");
			grade = scanner.nextInt();
			scanner.nextLine();
			
			PhoneInfo school = new PhoneSchoolInfo(name, phoneNumber, major, grade);
			boolean sc = set.add(school);

			if (sc == false) {
				System.out.println("이미 저장된 데이터입니다.\n덮어쓸까요?Y(y)/N(n)");
				Scanner scan = new Scanner(System.in);
				String str = scan.next();

				if (str.equalsIgnoreCase("y")) {

					set.remove(school);
					set.add(school);

					set.add(new PhoneSchoolInfo(name, phoneNumber, major, grade));
					System.out.println("덮어쓰기 완료되었습니다.");
				} else if (str.equalsIgnoreCase("n")) {
					System.out.println("덮어쓰기 실패하였습니다.");
				}
			}

		}
		if (a == 3) {
			// b = scanner.next();
			System.out.println("이름:");
			name = scanner.nextLine();
			System.out.print("전화번호:");
			phoneNumber = scanner.nextLine();
			System.out.println("회사:");
			companyName = scanner.nextLine();

			PhoneInfo company = new PhoneCompanyInfo(name, phoneNumber, companyName);
			boolean cp = set.add(company);
			if (cp == false) {
				Scanner scan = new Scanner(System.in);
				String str = scan.next();

				if (str.equalsIgnoreCase("y")) {
					set.remove(company);
					set.add(company);

					set.add(new PhoneCompanyInfo(name, phoneNumber, companyName));
					System.out.println("덮어쓰기 완료되었습니다.");
				}
				if (str.equalsIgnoreCase("n")) {
					System.out.println("덮어쓰기 실패하였습니다");
				}
			}

		}
		System.out.println("입력한 정보가 저장되었습니다.\n");
	}

	public void dataSearch() {
		System.out.println("데이터를 검색합니다.");
		boolean isFind = false;// 검색한 정보가 있는지 확인을 위한 변수
		System.out.print("검색할 이름:");
		String searchName = scanner.next();
		scanner.nextLine();
		// 객체배열에 저장된 친구정보의 갯수만큼 반복
		for (PhoneInfo phoneInfo : set) {

			if (searchName.equals(phoneInfo.name)) {
				phoneInfo.showPhoneInfo();
				System.out.println();
				System.out.println("데이터 검색이 완료되었습니다");
				isFind = true;// 찾는 정보가 있다면 true로 변경
			}
		}

		if (isFind == false)
			System.out.println("데이터가 없습니다");

	}//// end of searchInfo

	public void dataAllShow() {
		System.out.println("==주소록을 출력함==");
		for (PhoneInfo phoneInfo : set) {
			phoneInfo.showPhoneInfo();
		}
	}

	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다.:");
		System.out.print("이름:");
		String name = scanner.next();
		boolean isFind = false;

		Iterator<PhoneInfo> itr = set.iterator();

		while (itr.hasNext()) {

			PhoneInfo phoneInfo = itr.next();

			if (name.equals(phoneInfo.name)) {

				set.remove(phoneInfo);
				isFind = true;

			}

		}
		if (isFind == false) {
			System.out.println("일치하는 데이터가 없어 삭제하지 못했습니다.");
		} else {
			System.out.println("데이터 삭제가 완료되었습니다.");
		}
	}

}