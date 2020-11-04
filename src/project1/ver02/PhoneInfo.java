package project1.ver02;

import java.util.Scanner;

public class PhoneInfo {

	String name;
	String phoneNumber;
	String birthday;

	public PhoneInfo() {

	}

	public PhoneInfo(String name, String phoneNumber) {

		this(name, phoneNumber, null);
	}

	public PhoneInfo(String name, String phoneNumber, String birthday) {

		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	public void showPhoneInfo() {

		System.out.println("이름:" + name);
		System.out.println("전화번호:" + phoneNumber);
		if (birthday == null)
			System.out.println("생년월일:입력되지않음");
		else
			System.out.println("생년월일:" + birthday);

	}
}
